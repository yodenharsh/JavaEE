package com.harsh.product.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.harsh.product.dto.Product;

public class ProductDAOImplTest {

	@Test
	public void createShouldCreateAProduct() {
		ProductDAO  dao = new ProductDAOImpl();
		Product product = new Product();
		product.setId(1);
		product.setName("Android one");
		product.setPrice(39990);
		product.setDescription("Very cool phone");
		dao.create(product);
		
		Product result = dao.read(1);
		assertNotNull(result);
		assertEquals("Android one", result.getName());
	}

}
