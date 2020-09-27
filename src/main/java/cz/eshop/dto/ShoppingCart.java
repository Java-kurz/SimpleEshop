package cz.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import cz.eshop.entity.Product;


public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = -4319480662768232958L;

	
	private BigDecimal allPrice = new BigDecimal(0);


	private Map<Long, ShoppingCartItem> productMap = new HashMap<Long, ShoppingCartItem>();
	
	
	public Map<Long, ShoppingCartItem> getProductMap() {
		return productMap;
	}


	public void setProductMap(Map<Long, ShoppingCartItem> productMap) {
		this.productMap = productMap;
	}


	public BigDecimal getAllPrice() {
		return allPrice;
	}


	public void setAllPrice(BigDecimal allPrice) {
		this.allPrice = allPrice;
	}
	
	
	

}


