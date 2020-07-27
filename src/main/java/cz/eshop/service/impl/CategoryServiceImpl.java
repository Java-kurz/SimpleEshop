package cz.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.eshop.dao.CategoryDao;
import cz.eshop.entity.Category;
import cz.eshop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public void create(Category category) {
		categoryDao.create(category);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void remove(Category category) {
		categoryDao.remove(category);
	}

	@Override
	public List<Category> getList() {
		return categoryDao.getList();
	}

	@Override
	public Category loadById(Long id) {
		return categoryDao.loadById(id);
	}

	

}
