package com.harsh.product.bo;

import com.harsh.product.dto.Product;

public interface ProductBO {
	
	void create(Product product);
	Product findProduct(int id);
}
