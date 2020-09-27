package cz.eshop.service;

import java.util.List;
import java.util.Map;

import cz.eshop.entity.Category;



public interface CategoryService {
	
	public void create(Category category);

	public void update(Category category);
	
	public void remove(Category category);
	
	public List<Category> getList();
	
	public Category loadById(Long id);

	public Map<Long, String> getCategoryMap();
	
	
}
