package com.im.service;

import java.util.List;

import com.im.collection.PolicyDetails;
import com.im.entity.AddPolicy;
import com.im.entity.AggregationList;

public interface PolicyService  {
	
	public long calculatePremium(String userName);
	public List<PolicyDetails> getPoliciesByUserName(String userName);
	public PolicyDetails addPolicy(AddPolicy policy);
	public List<PolicyDetails> getAllPolicies();
	public List<PolicyDetails> getPendingPolicies();
	public PolicyDetails setStatus(String policyNumber, String status);
	public PolicyDetails getPolicyByPolicyNumber(String policyNumber);
	public List<PolicyDetails> getApprovedPolicy(String userName);
	public AggregationList getAggregatedPolicyStatus();
	
}
