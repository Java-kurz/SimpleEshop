package cz.eshop.controller;

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
import cz.eshop.service.ShoppingCartService;

@Controller
@SessionAttributes("shoppingCart")
public class MainController {

	@Autowired
	ProductService productService;

	@Autowired
	ShoppingCartService shoppingCartService;

	@ModelAttribute("shoppingCart")
	public ShoppingCart shoppingCart() {
		return new ShoppingCart();
	}

	/**
	 * Method returns main page.
	 */

	@GetMapping({ "/", "/index", "/ovoce", "/zelenina" })
	public String index(Model model, @RequestParam(required = false) Long categoryId) {

		if (categoryId != null) {
			List<Product> products = productService.loadByCategory(categoryId);
			model.addAttribute("products", products);
		} else {
			List<Product> products = productService.getList();
			model.addAttribute("products", products);
		}

		return "index";
	}

	@GetMapping("/product_detail")
	public String productDetail(@RequestParam("id") Long productId,
			@RequestParam("testParam") Optional<String> testParam, @RequestParam("testParam2") String testParam2,
			Model model) {

		// System.out.println(productId);
		// System.out.println(testParam.isPresent() ? testParam.get() : "testParam does
		// not exists");
		// System.out.println(testParam2);

		Product product = productService.loadById(productId);
		model.addAttribute("product", product);

		return "product_detail";
	}

	@GetMapping("/cart")
	public String cart(Model model) {

		return "cart";
	}

	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("id") Long productId,
			@ModelAttribute("shoppingCart") ShoppingCart shoppingCart, Model model) {

		shoppingCartService.addToCart(productId, shoppingCart);

		return "cart";
	}

	@GetMapping("/removefromcart")
	public String removeFromCart(@RequestParam("id") Long productId,
			@ModelAttribute("shoppingCart") ShoppingCart shoppingCart, Model model) {

		shoppingCartService.removeFromCart(productId, shoppingCart);

		return "cart";
	}

	@GetMapping("/removeonefromcart")
	public String removeOneFromCart(@RequestParam("id") Long productId,
			@ModelAttribute("shoppingCart") ShoppingCart shoppingCart, Model model) {

		shoppingCartService.removeOneFromCart(productId, shoppingCart);

		return "cart";
	}

	@GetMapping("/clearcart")
	public String clearCart(@ModelAttribute("shoppingCart") ShoppingCart shoppingCart, Model model) {

		shoppingCartService.clearCart(shoppingCart);

		return "cart";
	}
}