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
import cz.eshop.entity.Category;
import cz.eshop.service.CategoryService;

@Controller
public class AdminController {

	private static final String ADMIN_PATH_PREFIX = "admin/";

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

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
	 * Method loads products and returns Category admin page.
	 */
	@GetMapping("admin/categories")
	public String category(Model model) {

		List<Category> categories = categoryService.getList();
		model.addAttribute("categories", categories);

		return ADMIN_PATH_PREFIX + "categories_list";
	}

	/**
	 * Method prepares and returns edit Product form.
	 */
	@GetMapping("admin/edit_product_{id}")
	public String editProduct(@PathVariable("id") Long productId, Model model) {

		Product product = productService.loadById(productId);
		List<Category> categories = categoryService.getList();
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		model.addAttribute("actionType", ActionType.EDIT);

		return ADMIN_PATH_PREFIX + "product_admin";
	}

	/**
	 * Method handling POST request for updating Product in DB
	 */
	@PostMapping(value = "admin/product_administration")
	public String createUpdateProduct(@ModelAttribute("product") Product product, Model model) {

		if (product.getId() == null) {
			productService.create(product);
		} else {
			productService.update(product);
		}

		return "redirect:products";

	}

	@PostMapping(value = "admin/category_administration")
	public String createUpdateCategory(@ModelAttribute("category") Category category, Model model) {

		if (category.getStatus() == null) {
			category.setStatus(Boolean.FALSE);
		}
		if (category.getId() == null) {
			categoryService.create(category);
		} else {
			categoryService.update(category);
		}

		return "redirect:categories";

	}

	@GetMapping("admin/remove_product_{id}")
	public String removeProduct(@ModelAttribute("product") Product product, Model model) {

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

	@GetMapping("admin/create_category")
	public String createCategory(Model model) {

		Category category = new Category();
		model.addAttribute("category", category);
		model.addAttribute("actionType", ActionType.CREATE);

		return ADMIN_PATH_PREFIX + "category_admin";
	}

	@GetMapping("admin/edit_category_{id}")
	public String editCategory(@PathVariable("id") Long categoryId, Model model) {

		Category category = categoryService.loadById(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("actionType", ActionType.EDIT);

		return ADMIN_PATH_PREFIX + "category_admin";
	}
	
	@GetMapping("admin/remove_category_{id}")
	public String removeCategory(@ModelAttribute("category") Category category, Model model) {

		categoryService.remove(category);

		return "redirect:categories";
	}
}