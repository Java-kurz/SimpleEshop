package cz.eshop.service;

import java.util.List;

import cz.eshop.dto.CheckOutModel;
import cz.eshop.dto.ShoppingCart;
import cz.eshop.entity.Order;
import cz.eshop.entity.OrderItem;

public interface OrderService {

	public CheckOutModel createOrderModel();

	public void createOrder(CheckOutModel checkOutModel, ShoppingCart cart);

	public List<Order> getList();
	
	public Order loadById(Long id);
	
	public List<OrderItem> loadByOrderId(Long id);
	
	public void changeOrderStatus(Integer status, Long orderId);
	
}
