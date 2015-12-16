package com.im.service;

import java.util.List;

import com.im.collection.PolicyDetails;
import com.im.entity.AddPolicy;

public interface PolicyService  {
	
	public long calculatePremium(String userName);
	public List<PolicyDetails> getPoliciesByUserName(String userName);
	public PolicyDetails addPolicy(AddPolicy policy);
	public List<PolicyDetails> getAllPolicies();	
	public PolicyDetails setStatus(String policyNumber, String status);
	public PolicyDetails getPolicyByPolicyNumber(String policyNumber);
	
	
}
