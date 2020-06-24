package cz.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cz.eshop.entity.Product;
import cz.eshop.service.ProductService;

@Controller
public class MainController {

	/**private static final String ADMIN_PATH_PREFIX = "admin/";*/
	
	@Autowired
	ProductService productService;

	/**
	 * Method returns main page.
	 */
	@GetMapping( { "/", "/index" } )
	public String index(Model model) {

		List<Product> products = productService.getList();
		model.addAttribute("products", products);

	
		return "index";
	
	
	
	/**public String index() {

	return "index";
	*/
	}

}