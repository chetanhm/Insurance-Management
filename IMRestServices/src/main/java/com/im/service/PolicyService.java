package com.im.service;

import java.util.List;

import com.im.collection.Policies;

public interface PolicyService  {
	
	public long calculatePremium(String userName);
	public List<Policies> getRespectivePolicies(String userName);

}
