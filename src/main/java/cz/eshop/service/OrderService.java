package cz.eshop.service;

import cz.eshop.dto.CheckOutModel;
import cz.eshop.dto.ShoppingCart;


public interface OrderService {

	public CheckOutModel createOrderModel();

	public void createOrder(CheckOutModel checkOutModel, ShoppingCart cart);

}
