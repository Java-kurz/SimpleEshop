package cz.eshop.dao;

import java.util.List;

import cz.eshop.entity.OrderItem;

public interface OrderItemDao extends GenericDao<OrderItem> {

	public List<OrderItem> loadByOrderId(Long id);
	
}



