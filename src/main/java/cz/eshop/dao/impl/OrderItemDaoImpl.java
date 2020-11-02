package cz.eshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.eshop.dao.OrderItemDao;
import cz.eshop.entity.OrderItem;


@Repository("orderItemDao")
@Transactional(readOnly = true)
public class OrderItemDaoImpl extends GenericDaoImpl<OrderItem> implements OrderItemDao {

}
