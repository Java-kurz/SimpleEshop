package cz.eshop.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cz.eshop.dto.CheckOutModel;
import cz.eshop.dto.ShoppingCart;
import cz.eshop.entity.Order;
import cz.eshop.entity.Product;
import cz.eshop.service.CategoryService;
import cz.eshop.service.OrderService;
import cz.eshop.service.ProductService;
import cz.eshop.service.ShoppingCartService;

@Controller
@SessionAttributes({ "shoppingCart" })

public class MainController {

	@Autowired
	ProductService productService;

	@Autowired
	ShoppingCartService shoppingCartService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	OrderService orderService;
	
	@ModelAttribute("shoppingCart")
	public ShoppingCart shoppingCart() {
		return new ShoppingCart();
	}
	
	
	
	/**
	 * Method returns main page.
	 */

	@GetMapping({ "/", "/index", "/category" })
	public String index(Model model, @RequestParam(value = "id", required = false) Long categoryId) {

		if (categoryId != null) {
			List<Product> products = productService.loadByCategory(categoryId);
			model.addAttribute("products", products);
		} else {
			List<Product> products = productService.getList();
			model.addAttribute("products", products);
		}

		Map<Long, String> categoryMap = categoryService.getCategoryMap();
		model.addAttribute("categoryMap", categoryMap);

		return "index";
	}

	/**
	 * Method returns product detail.
	 */
	@GetMapping("/product_detail")
	public String productDetail(@RequestParam("id") Long productId,
			@RequestParam("testParam") Optional<String> testParam, @RequestParam("testParam2") String testParam2,
			Model model) {

		Product product = productService.loadById(productId);
		model.addAttribute("product", product);
		
		/*
		 * System.out.println(productId); System.out.println(testParam.isPresent() ?
		 * testParam.get() : "testParam does not exists");
		 * System.out.println(testParam2);
		 */
		
		return "product_detail";
	}
	
	/**
	 * Method returns shopping cart.
	 */
	@GetMapping("/cart")
	public String cart(Model model) {

		return "cart";
	}
	
	/**
	 * Method put one product to the shopping cart.
	 */
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("id") Long productId,
			@ModelAttribute("shoppingCart") ShoppingCart shoppingCart, Model model) {

		shoppingCartService.addToCart(productId, shoppingCart);

		return "cart";
	}
	
	/**
	 * Method remove item from the shopping cart.
	 */
	@GetMapping("/removefromcart")
	public String removeFromCart(@RequestParam("id") Long productId,
			@ModelAttribute("shoppingCart") ShoppingCart shoppingCart, Model model) {

		shoppingCartService.removeFromCart(productId, shoppingCart);

		return "cart";
	}
	
	/**
	 * Method reduce the amount in shopping cart by one one.
	 */
	@GetMapping("/removeonefromcart")
	public String removeOneFromCart(@RequestParam("id") Long productId,
			@ModelAttribute("shoppingCart") ShoppingCart shoppingCart, Model model) {

		shoppingCartService.removeOneFromCart(productId, shoppingCart);

		return "cart";
	}
	
	/**
	 * Method clear shopping cart.
	 */
	@GetMapping("/clearcart")
	public String clearCart(@ModelAttribute("shoppingCart") ShoppingCart shoppingCart, Model model) {

		shoppingCartService.clearCart(shoppingCart);

		return "cart";
	}
	
	/**
	 * Method prepares and returns create Order form.
	 */
	@GetMapping("/orderform")
	public String orderForm(Model model) {

		model.addAttribute("checkOutModel", orderService.createOrderModel());

		return "checkout";
	}

	/**
	 * Method handling POST request for updating Order in DB
	 */
	@PostMapping(value = "createorder")
	public String createOrder(@ModelAttribute("checkOutModel") CheckOutModel checkOutModel, ShoppingCart shoppingCart, Model model) {

		
		
		orderService.createOrder(checkOutModel, shoppingCart);
		
			
			
		return "cart";
	}
}