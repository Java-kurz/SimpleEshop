package cz.eshop.dao;

import java.util.List;

import cz.eshop.entity.Order;

public interface OrderDao extends GenericDao<Order> {

	public List<Order> getList();
}
