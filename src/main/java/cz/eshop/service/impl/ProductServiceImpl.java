package cz.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.eshop.dao.ProductDao;
import cz.eshop.dto.ProductAdminDetailModel;
import cz.eshop.entity.Category;
import cz.eshop.entity.Product;
import cz.eshop.service.CategoryService;
import cz.eshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryService categoryService;

	@Override
	public void create(Product product) {
		productDao.create(product);
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	@Override
	public void remove(Product product) {
		productDao.remove(product);
	}

	@Override
	public List<Product> getList() {
		return productDao.getList();
	}
	
	@Override
	public Product loadById(Long id) {
		return productDao.loadById(id);
	}

	@Override
	public List<Product> loadByCategory(Long categoryId) {
		return productDao.loadByCategory(categoryId);

	}

	@Override
	public ProductAdminDetailModel editCreateProduct(Long productId) {

		ProductAdminDetailModel productAdminDetailModel = new ProductAdminDetailModel();

		if (productId != null) {

			Product product = this.loadById(productId);
			productAdminDetailModel.setId(product.getId());
			productAdminDetailModel.setName(product.getName());
			productAdminDetailModel.setDescription(product.getDescription());
			productAdminDetailModel.setPrice(product.getPrice());
			productAdminDetailModel.setImageUrl(product.getImageUrl());
			productAdminDetailModel.setCategoryId(product.getCategoryId());
		}

		List<Category> categories = categoryService.getList();
		productAdminDetailModel.setCategories(categories);

		return productAdminDetailModel;

	}
}
