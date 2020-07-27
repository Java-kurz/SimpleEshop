package cz.eshop.dao;

import java.util.List;

import cz.eshop.entity.Category;

public interface CategoryDao extends GenericDao<Category> {

	/**
	 * @return Collection of all Category entities
	 */
	public List<Category> getList();

	/**
	 * @param id
	 * @return loaded Category entity
	 */
	public Category loadById(Long id);

	

}
