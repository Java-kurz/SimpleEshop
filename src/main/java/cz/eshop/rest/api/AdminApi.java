package cz.eshop.rest.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.eshop.entity.Product;
import cz.eshop.service.ProductService;

@Controller
@RequestMapping("/api/v1/admin")
public class AdminApi {

	private static final Logger LOG = LoggerFactory.getLogger(AdminApi.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Product> getProducts() {
		LOG.info("getProducts");

		List<Product> products = productService.getList();

		return products;
	}

}
