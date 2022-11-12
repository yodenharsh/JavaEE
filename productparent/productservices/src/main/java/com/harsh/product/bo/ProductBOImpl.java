package com.harsh.product.bo;

import com.harsh.product.dao.ProductDAO;
import com.harsh.product.dao.ProductDAOImpl;
import com.harsh.product.dto.Product;

public class ProductBOImpl implements ProductBO {

	private static ProductDAO dao = new ProductDAOImpl();
	
	@Override
	public void create(Product product) {
		dao.create(product);
	}

	@Override
	public Product findProduct(int id) {
		return dao.read(id);
	}

}
