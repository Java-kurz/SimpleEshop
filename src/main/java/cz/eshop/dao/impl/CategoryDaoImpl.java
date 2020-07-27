package cz.eshop.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.eshop.dao.CategoryDao;
import cz.eshop.entity.Category;

/**
 * Repository layer for db operations with Product entity
 * Extends AbstractDaoImpl for CRUD operations
 */
@Repository("categoryDao")
@Transactional(readOnly = true)
	
	public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {

		@Override
		public List<Category> getList() {
			final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			final CriteriaQuery<Category> crit = criteriaBuilder.createQuery(Category.class);
			final Root<Category> categories = crit.from(Category.class);
			crit.select(categories);
			final List<Category> results = findByCriteria(crit);
			return results;
		}

		@Override
		public Category loadById(Long id) {
			if (id == null) {
				return null;
			}
			final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			final CriteriaQuery<Category> crit = criteriaBuilder.createQuery(Category.class);
			final Root<Category> categories = crit.from(Category.class);

			crit.select(categories).where(criteriaBuilder.equal(categories.get("id"), id));

			final List<Category> results = findByCriteria(crit);
			if (results.size() != 0) {
				return results.get(0);
			}
			return null;
		}

}
