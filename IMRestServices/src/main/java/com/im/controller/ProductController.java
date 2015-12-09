package com.im.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.im.collection.ProductDetails;
import com.im.entity.AddProduct;
import com.im.service.ProductDetailsService;
import com.im.service.UserDetailsService;

@CrossOrigin
@RestController
@RequestMapping(value="/imservices")
public class ProductController {
	@Autowired
	private ProductDetailsService productDetailService;
	@Autowired
	private UserDetailsService registerService;

	/**
	 * This method handle REST call from  administrator for adding new product
	 * @param 
	 * @return ProductDetails Object given by MongoDB
	 */
	@RequestMapping(value = "/addProduct",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public @ResponseBody ProductDetails addProduct(@RequestBody AddProduct product,@RequestHeader(value="_id") String authenticationId) {
		
		if(authenticationId.equals(registerService.getUserByUsername("admin").getId()))
		{
			return productDetailService.insertProduct(product,authenticationId);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * This method handles REST call for administrator for checking if policy name exists already or not 
	 * @param productName
	 * @return true of false
	 */
	@RequestMapping(value="/checkProductName",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean checkProductName(@RequestParam(name="productName") String productName)
	{
		return productDetailService.ifProductPresent(productName);
	}
	
	/**
	 * This method will list all the products present in database
	 * */

	@RequestMapping(value="/allProducts",method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProductDetails> getAllProducts()
	{
		return productDetailService.getProducts();
	}
}
