package cz.eshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cz.eshop.dto.ShoppingCart;
import cz.eshop.entity.Product;
import cz.eshop.service.ProductService;

@Controller
@SessionAttributes("shoppingCart")
public class MainController {

	@Autowired
	ProductService productService;

	@ModelAttribute("shoppingCart")
	public ShoppingCart shoppingCart() {
		return new ShoppingCart();
	}

	/**
	 * Method returns main page.
	 */
	@GetMapping({ "/", "/index" })
	public String index(Model model) {

		List<Product> products = productService.getList();
		model.addAttribute("products", products);

		return "index";
	}

	@GetMapping("/product_detail")
	public String productDetail(
			@RequestParam("id") Long productId, 
			@RequestParam("testParam") Optional<String> testParam,
			@RequestParam("testParam2") String testParam2,
			Model model) {

		System.out.println(productId);
		System.out.println(testParam.isPresent() ? testParam.get() : "testParam does not exists");
		System.out.println(testParam2);

		Product product = productService.loadById(productId);
		model.addAttribute("product", product);

		return "product_detail";
	}

	@GetMapping("/cart")
	public String cart(Model model) {

		return "cart";
	}

}