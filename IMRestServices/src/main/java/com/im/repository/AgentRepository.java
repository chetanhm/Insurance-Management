package com.im.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.im.collection.AgentDetails;

public interface AgentRepository extends MongoRepository<AgentDetails,String>{


}
