package com.im.service;

import java.util.List;

import com.im.collection.ProductDetails;
import com.im.entity.AddProduct;

public interface ProductDetailsService {

	public ProductDetails insertProduct(AddProduct product,String id);
	public boolean ifProductPresent(String name);
	public List<ProductDetails> getProducts();
	public ProductDetails getProductByName(String name);
}
