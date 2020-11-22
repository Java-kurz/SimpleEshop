package cz.eshop.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.eshop.dao.OrderDao;
import cz.eshop.entity.Order;
import cz.eshop.entity.OrderItem;


@Repository("orderDao")
@Transactional(readOnly = true)
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

	@Override
	public List<Order> getList(){
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Order> crit = criteriaBuilder.createQuery(Order.class);
		final Root<Order> orders = crit.from(Order.class);
		crit.select(orders);
		final List<Order> results = findByCriteria(crit);
		return results;
	}
	
	@Override
	public Order loadById(Long id) {
		if (id == null) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Order> crit = criteriaBuilder.createQuery(Order.class);
		final Root<Order> orders = crit.from(Order.class);

		crit.select(orders).where(criteriaBuilder.equal(orders.get("id"), id));

		final List<Order> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
		
	}
	
	
	
}
