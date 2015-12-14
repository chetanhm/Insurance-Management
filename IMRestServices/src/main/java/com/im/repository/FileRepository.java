package com.im.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.im.collection.AgentDetails;
import com.im.collection.FileDetails;

public interface FileRepository extends MongoRepository<FileDetails,String>{


}
