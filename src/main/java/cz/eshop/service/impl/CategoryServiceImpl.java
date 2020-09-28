package cz.eshop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.eshop.dao.CategoryDao;
import cz.eshop.entity.Category;
import cz.eshop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	public static final Map<Long, String> categoryMap = new HashMap<Long, String>();

	@Override
	public void create(Category category) {
		categoryDao.create(category);
		refreshCategoryMap();
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
		refreshCategoryMap();
	}

	@Override
	public void remove(Category category) {
		categoryDao.remove(category);
		refreshCategoryMap();
	}

	@Override
	public List<Category> getList() {
		return categoryDao.getList();
	}

	@Override
	public Category loadById(Long id) {
		return categoryDao.loadById(id);
	}

	@Override
	public Map<Long, String> getCategoryMap() {
		if (MapUtils.isEmpty(categoryMap)) {
			fillCategoryMap();
		}
		return categoryMap;
	}

	private void fillCategoryMap() {
		List<Category> categories = getList();
		for (final Category category : categories) {
			System.out.println(category.getStatus());
			if (Boolean.TRUE == category.getStatus()) {
				categoryMap.put(category.getId(), category.getName());
			}
		}
	}

	private void refreshCategoryMap() {
		categoryMap.clear();
		fillCategoryMap();
	}

}
