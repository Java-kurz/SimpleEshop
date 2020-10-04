package cz.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cz.eshop.dao.ProductDao;
import cz.eshop.dto.ProductAdminDetailModel;
import cz.eshop.entity.Product;
import cz.eshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductAdminDetailModel productAdminDetailModel;

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
	public List<Product> loadByCategory(String categoryName) {
		return productDao.loadByCategory(categoryName);
		
	}

	@Override
	public Model productDetail1(Model model, Long productId) {
		return productAdminDetailModel.productDetail1(model, productId);
		
	}
}
