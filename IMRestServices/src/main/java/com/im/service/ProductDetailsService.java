package com.im.service;

import com.im.collection.ProductDetails;
import com.im.entity.AddProduct;

public interface ProductDetailsService {

	public ProductDetails insertProduct(AddProduct product,String id);
	public boolean ifProductPresent(String name);
}
