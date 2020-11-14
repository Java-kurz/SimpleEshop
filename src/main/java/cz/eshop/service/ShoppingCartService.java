package cz.eshop.service;

import cz.eshop.dto.ShoppingCart;

public interface ShoppingCartService {

	public void addToCart(Long id, ShoppingCart cart);
	
	public void removeFromCart(Long id, ShoppingCart cart);
	
	public void removeOneFromCart(Long id, ShoppingCart cart);
	
	public void clearCart(ShoppingCart cart);
	
	
	
	
}
