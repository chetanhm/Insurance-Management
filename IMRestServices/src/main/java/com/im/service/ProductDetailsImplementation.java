package com.im.service;

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
		ProductDetails productDetails = new ProductDetails(product.getProductName(), product.getBasicCoverage(),
				product.getAccidentalBenefit(), product.getSettlementRatio(), product.getMonthlyPremium(),
				product.getProductTerms(), product.getDescription(), product.getTermYear());

		productDetails = productRepository.insert(productDetails);

		return productDetails;
	}

	public boolean ifProductPresent(String name) {
		
		ProductDetails productDetails=productRepository.findByName(name);
		if(productDetails!=null)
		{
			return true;
		}
		return false;
	}

}
