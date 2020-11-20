package cz.eshop.service;

import java.util.List;

import cz.eshop.dto.CheckOutModel;
import cz.eshop.dto.ShoppingCart;
import cz.eshop.entity.Order;


public interface OrderService {

	public CheckOutModel createOrderModel();

	public void createOrder(CheckOutModel checkOutModel, ShoppingCart cart);

	public List<Order> getList();
}
