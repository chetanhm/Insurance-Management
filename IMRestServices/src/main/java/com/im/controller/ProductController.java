package com.im.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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

@CrossOrigin
@RestController
@RequestMapping(value="/imservices")
public class ProductController {
	@Autowired
	private ProductDetailsService productDetailService;
	/**
	 * This method handle REST call from  administrator for adding new product
	 * @param 
	 * @return ProductDetails Object given by MongoDB
	 */
	@RequestMapping(value = "/product",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public @ResponseBody ProductDetails addProduct(@RequestBody AddProduct product,@RequestHeader(value="_id") String authenticationId) {
			
			return productDetailService.insertProduct(product,authenticationId);
	}
	
	/**
	 * This method handles REST call for administrator for checking if policy name exists already or not 
	 * @param productName
	 * @return true of false
	 */
	@RequestMapping(value="/product/check",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean checkProductName(@RequestParam(name="productName") String productName)
	{
		return productDetailService.isProductPresent(productName);
	}
	
	/**
	 * This method will list all the products present in database
	 * */
	@RequestMapping(value="/product",method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProductDetails> getAllProducts()
	{
		return productDetailService.getProducts();
	}
	/**
	 * This method will view the detailed description of a particular product
	 * */

	@RequestMapping(value="/product/{productName}",method= RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductDetails viewProductDetails(@PathVariable(value="productName") String productName)
	{
		return productDetailService.getProductByName(productName);
	}
	
}
