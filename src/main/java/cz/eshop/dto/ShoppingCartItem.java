package cz.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ShoppingCartItem implements Serializable {

	private static final long serialVersionUID = -4319480662768232958L;

	private Long id;

	private BigDecimal price = new BigDecimal(0);

	private String imageUrl;

	private Integer count = 0;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(int i) {
		this.count = count+i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
