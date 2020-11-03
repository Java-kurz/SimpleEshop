package cz.eshop.service.impl;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.eshop.dao.OrderDao;
import cz.eshop.dto.CheckOutModel;
import cz.eshop.dto.ShoppingCart;
import cz.eshop.dto.ShoppingCartItem;
import cz.eshop.entity.Order;
import cz.eshop.entity.OrderItem;
import cz.eshop.entity.Product;
import cz.eshop.service.ProductService;
import cz.eshop.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	ProductService productService;

	@Autowired
	OrderDao orderDao;

	@Override
	public void addToCart(Long id, ShoppingCart cart) {
		// TODO Auto-generated method stub

		if (cart.getProductMap().containsKey(id)) {

			ShoppingCartItem shoppingCartItem = cart.getProductMap().get(id);
			shoppingCartItem.changeCount(1);
		} else {
			Product product = productService.loadById(id);
			ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
			shoppingCartItem.setId(product.getId());
			shoppingCartItem.setName(product.getName());
			shoppingCartItem.setPrice(product.getPrice());
			shoppingCartItem.setImageUrl(product.getImageUrl());
			shoppingCartItem.changeCount(1);
			cart.getProductMap().put(id, shoppingCartItem);
		}
		rePrice(cart);

	}

	@Override
	public void removeFromCart(Long id, ShoppingCart cart) {
		// TODO Auto-generated method stub

		cart.getProductMap().remove(id);
		rePrice(cart);

	}

	@Override
	public void removeOneFromCart(Long id, ShoppingCart cart) {
		// TODO Auto-generated method stub

		ShoppingCartItem shoppingCartItem = cart.getProductMap().get(id);
		shoppingCartItem.changeCount(-1);
		if (shoppingCartItem.getCount() == 0) {
			cart.getProductMap().remove(id);
		}
		rePrice(cart);

	}

	@Override
	public void clearCart(ShoppingCart cart) {
		// TODO Auto-generated method stub

		cart.getProductMap().clear();
		rePrice(cart);

	}

	private void rePrice(ShoppingCart cart) {
		BigDecimal allPrice = BigDecimal.ZERO;

		for (Long id : cart.getProductMap().keySet()) {
			ShoppingCartItem shoppingCartItem = cart.getProductMap().get(id);
			BigDecimal onePrice = shoppingCartItem.getPrice().multiply(new BigDecimal(shoppingCartItem.getCount()));
			allPrice = onePrice.add(allPrice);

		}
		cart.setAllPrice(allPrice);
	}

	public CheckOutModel createCustomerModel() {

		CheckOutModel checkOutModel = new CheckOutModel();

		return checkOutModel;
	}

	public void createCustomer(Order order, ShoppingCart cart) {

		for (Long id : cart.getProductMap().keySet()) {
			ShoppingCartItem shoppingCartItem = cart.getProductMap().get(id);
			OrderItem orderItem = new OrderItem();
			orderItem.setQuantity(shoppingCartItem.getCount());
			orderItem.setProductId(shoppingCartItem.getId());
			order.getOrderItems().add(orderItem);

			System.out.println(shoppingCartItem.getCount());
			System.out.println(shoppingCartItem.getId());

			

		}
		orderDao.create(order);
		/*
		 * for (Map.Entry<Long, ShoppingCartItem> entry :
		 * cart.getProductMap().entrySet()) { System.out.println("[Key] : " +
		 * entry.getKey() + " [Value] : " + entry.getValue(cart.get(entry.getKey()))); }
		 */

	}
}
