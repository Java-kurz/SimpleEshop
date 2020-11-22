package cz.eshop.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.eshop.dao.OrderItemDao;
import cz.eshop.entity.OrderItem;


@Repository("orderItemDao")
@Transactional(readOnly = true)
public class OrderItemDaoImpl extends GenericDaoImpl<OrderItem> implements OrderItemDao {

	@Override
	public List<OrderItem> loadByOrderId(Long id){
		
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<OrderItem> crit = criteriaBuilder.createQuery(OrderItem.class);
		final Root<OrderItem> orderItems = crit.from(OrderItem.class);
		crit.select(orderItems).where(criteriaBuilder.equal(orderItems.get("orderId"), id));
		final List<OrderItem> results = findByCriteria(crit);
		return results;
		
	}
}
