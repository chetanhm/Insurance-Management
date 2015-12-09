package com.im.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.im.collection.ProductDetails;

public interface ProductRepository extends MongoRepository<ProductDetails,String>{

	@Query(value="{productName: ?0}")
	public ProductDetails findByName(String name);
}
