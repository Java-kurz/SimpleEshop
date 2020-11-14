package cz.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cz.eshop.dto.ActionType;
import cz.eshop.entity.Category;
import cz.eshop.entity.Product;
import cz.eshop.service.CategoryService;
import cz.eshop.service.ProductService;

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
	 * Method prepares and returns edit Product form.
	 */
	@GetMapping("admin/edit_product_{id}")
	public String editProduct(@PathVariable("id") Long productId, Model model) {

		model.addAttribute("productAdminDetailModel", productService.editCreateProduct(productId));
		model.addAttribute("actionType", ActionType.EDIT);

		return ADMIN_PATH_PREFIX + "product_admin";
	}

	/**
	 * Method prepares and returns create Product form.
	 */
	@GetMapping("admin/create_product")
	public String createProduct(Model model) {

		model.addAttribute("productAdminDetailModel", productService.editCreateProduct(null));
		model.addAttribute("actionType", ActionType.CREATE);

		return ADMIN_PATH_PREFIX + "product_admin";
	}
	
	/**
	 * Method handling request for removing Product from DB
	 */
	@GetMapping("admin/remove_product_{id}")
	public String removeProduct(@ModelAttribute("product") Product product, Model model) {

		productService.remove(product);

		return "redirect:products";
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
	
	/**
	 * Method loads categories and returns Category admin page.
	 */
	@GetMapping("admin/categories")
	public String category(Model model) {

		List<Category> categories = categoryService.getList();
		model.addAttribute("categories", categories);

		return ADMIN_PATH_PREFIX + "categories_list";
	}
	
	/**
	 * Method prepares and returns edit Category form.
	 */
	@GetMapping("admin/edit_category_{id}")
	public String editCategory(@PathVariable("id") Long categoryId, Model model) {

		Category category = categoryService.loadById(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("actionType", ActionType.EDIT);

		return ADMIN_PATH_PREFIX + "category_admin";
	}
	
	/**
	 * Method prepares and returns create Category form.
	 */
	@GetMapping("admin/create_category")
	public String createCategory(Model model) {

		Category category = new Category();
		model.addAttribute("category", category);
		model.addAttribute("actionType", ActionType.CREATE);

		return ADMIN_PATH_PREFIX + "category_admin";
	}

	/**
	 * Method handling request for removing Category from DB
	 */
	@GetMapping("admin/remove_category_{id}")
	public String removeCategory(@ModelAttribute("category") Category category, Model model) {

		categoryService.remove(category);

		return "redirect:categories";
	}

	/**
	 * Method handling POST request for updating Category in DB
	 */

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

}