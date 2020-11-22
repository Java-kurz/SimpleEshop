package cz.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.eshop.dao.OrderDao;
import cz.eshop.dao.OrderItemDao;
import cz.eshop.dto.CheckOutModel;
import cz.eshop.dto.ShoppingCart;
import cz.eshop.dto.ShoppingCartItem;
import cz.eshop.entity.Order;
import cz.eshop.entity.OrderItem;
import cz.eshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderItemDao orderItemDao;

	@Override
	public CheckOutModel createOrderModel() {

		CheckOutModel checkOutModel = new CheckOutModel();

		return checkOutModel;
	}

	@Override
	public void createOrder(CheckOutModel checkOutModel, ShoppingCart cart) {

		Order order = new Order();
		order.setName(checkOutModel.getName());
		order.setStreet(checkOutModel.getStreet());
		order.setCity(checkOutModel.getCity());
		order.setPsc(checkOutModel.getPsc());
		order.setPhone(checkOutModel.getPhone());
		order.setEmail(checkOutModel.getEmail());
		order.setStatus(1);
		

		for (Long id : cart.getProductMap().keySet()) {
			OrderItem orderItem = new OrderItem();
			ShoppingCartItem shoppingCartItem = cart.getProductMap().get(id);
			orderItem.setQuantity(shoppingCartItem.getCount());
			orderItem.setProductId(shoppingCartItem.getId());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
			System.out.println();
		}
		orderDao.create(order);

//		for (Map.Entry<Long, ShoppingCartItem> entry : cart.getProductMap().entrySet()) {
//			System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue().getName());
//		}

	}
	
	@Override
	public void changeOrderStatus(Integer status, Long orderId) {
		
		Order order =this.loadById(orderId);
		order.setStatus(status);
		
	}
	
	@Override
	public List<Order> getList(){
		return orderDao.getList();
	}
	
	@Override
	public Order loadById(Long id) {
		return orderDao.loadById(id);
	}
	
	@Override
	public List<OrderItem> loadByOrderId(Long id){
		return orderItemDao.loadByOrderId(id);
	}
}
