package cz.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.eshop.dto.ActionType;
import cz.eshop.entity.Product;
import cz.eshop.service.ProductService;

@Controller
public class AdminController {

	private static final String ADMIN_PATH_PREFIX = "admin/";

	@Autowired
	ProductService productService;

	/**
	 * Method loads products and returns Product admin page.
	 */
	@GetMapping("admin/products")
	public String index(Model model) {

		List<Product> products = productService.getList();
		model.addAttribute("products", products);

		return ADMIN_PATH_PREFIX + "products_list";
	}

	/**
	 * Method prepares and returns edit Product form.
	 */
	@GetMapping("admin/edit_product_{id}")
	public String editProduct(
			@PathVariable("id") Long productId, 
			Model model) {

		Product product = productService.loadById(productId);
		model.addAttribute("product", product);
		model.addAttribute("actionType", ActionType.EDIT);

		return ADMIN_PATH_PREFIX + "product_admin";
	}

	/**
	 * Method handling POST request for updating Product in DB
	 */
	@PostMapping(value = "admin/product_administration")
	public String createUpdateProduct(
			@ModelAttribute("product") Product product, 
			Model model) {

		if (product.getId() == null) {
			productService.create(product);
		} else {
			productService.update(product);
		}

		return "redirect:products";

	}

	@GetMapping("admin/remove_product_{id}")
	public String removeProduct(
			@ModelAttribute("product") Product product, 
			Model model) {

		productService.remove(product);

		return "redirect:products";
	}

	@GetMapping("admin/create_product")
	public String createProduct(Model model) {

		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("actionType", ActionType.CREATE);

		return ADMIN_PATH_PREFIX + "product_admin";
	}

}
