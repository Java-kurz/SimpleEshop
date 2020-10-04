package cz.eshop.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import cz.eshop.entity.Product;
import cz.eshop.service.ProductService;

public class ProductAdminDetailModel implements Serializable {
	
	private static final long serialVersionUID = -4319480662768232958L;
		
	@Autowired
	ProductService productService;
	
	public Model productDetail1(Model model, Long productId) {
	
		Product product = productService.loadById(productId);
		model.addAttribute("product", product);
	
	return model;
	
	}
}