package com.im.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.collection.ProductDetails;
import com.im.entity.AddProduct;
import com.im.repository.ProductRepository;

@Service
public class ProductDetailsImplementation implements ProductDetailsService {
	@Autowired
	private ProductRepository productRepository;

	public ProductDetails insertProduct(AddProduct product,String id) {
		List<String> productTerms=product.getProductTerms();
		while(productTerms.remove(null));
		
		ProductDetails productDetails = new ProductDetails(product.getProductName(), product.getBasicCoverage(),
				product.getAccidentalBenefit(), product.getSettlementRatio(), product.getMonthlyPremium(),
				productTerms, product.getDescription(), product.getTermYear());

		productDetails = productRepository.insert(productDetails);

		return productDetails;
	}

	public boolean isProductPresent(String name) {
		
		ProductDetails productDetails=productRepository.findByName(name);
		if(productDetails!=null)
		{
			return true;
		}
		return false;
	}

	public List<ProductDetails> getProducts() {
		return productRepository.findAll();
	}
	
	public ProductDetails getProductByName(String name) {
		
		return productRepository.findByName(name);
	}

}
