package cz.eshop.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.eshop.dao.OrderDao;
import cz.eshop.entity.Order;


@Repository("orderDao")
@Transactional(readOnly = true)
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

	public List<Order> getList(){
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Order> crit = criteriaBuilder.createQuery(Order.class);
		final Root<Order> orders = crit.from(Order.class);
		crit.select(orders);
		final List<Order> results = findByCriteria(crit);
		return results;
	}
}
