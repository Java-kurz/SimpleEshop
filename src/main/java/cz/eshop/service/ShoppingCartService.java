package cz.eshop.service;

import cz.eshop.dto.CheckOutModel;
import cz.eshop.dto.ShoppingCart;
import cz.eshop.entity.Order;

public interface ShoppingCartService {

	public void addToCart(Long id, ShoppingCart cart);
	
	public void removeFromCart(Long id, ShoppingCart cart);
	
	public void removeOneFromCart(Long id, ShoppingCart cart);
	
	public void clearCart(ShoppingCart cart);
	
	public CheckOutModel createCustomerModel();
	
	public void createCustomer(Order order, ShoppingCart cart);
	
	
	
}
