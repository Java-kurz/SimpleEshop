package cz.eshop.service;

import java.util.List;

import cz.eshop.entity.Category;

public interface CategoryService {
	/**
	 * Create new Product
	 * @param product
	 */
	public void create(Category category);

	/**
	 * Update new Product
	 * @param product
	 */
	public void update(Category category);

	/**
	 * Remove Product
	 * @param product
	 */
	public void remove(Category category);

	/**
	 * @return Collection of all Product entities
	 */
	public List<Category> getList();

	/**
	 * @param id
	 * @return loaded Product entity
	 */
	public Category loadById(Long id);


}
