package cz.eshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.eshop.dao.OrderDao;
import cz.eshop.entity.Order;


@Repository("orderDao")
@Transactional(readOnly = true)
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

}
