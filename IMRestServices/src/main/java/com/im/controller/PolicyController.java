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

import com.im.collection.PolicyDetails;
import com.im.entity.AddPolicy;
import com.im.entity.AggregationList;
import com.im.service.PolicyService;

@CrossOrigin
@RestController
@RequestMapping(value="/imservices")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@RequestMapping(value="/premium/calculate", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public long getTotalPremium(@RequestParam(name="userName") String userName)
	{
		return policyService.calculatePremium(userName);
	}
	
	@RequestMapping(value="/policy/{userName}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PolicyDetails> getAllPoliciesByUserName(@PathVariable(value="userName") String userName)
	{
		return policyService.getPoliciesByUserName(userName);
	}

	@RequestMapping(value="/policy", method=RequestMethod.POST)
	public PolicyDetails addPolicy(@RequestBody AddPolicy policy,@RequestHeader(name="_id") String id)
	{
		return policyService.addPolicy(policy);
	}
	
	@RequestMapping(value="/policy",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PolicyDetails> getAllPolicies()
	{
		return policyService.getAllPolicies();		
	}
	
	@RequestMapping(value="/policy/pending",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PolicyDetails> getPendingPolicies()
	{
		return policyService.getPendingPolicies();
	}
	
	@RequestMapping(value="/policy", method=RequestMethod.PUT)
	public PolicyDetails updateStatus(@RequestParam(name="policyNumber") String policyNumber ,@RequestParam(name="status") String status)
	{
		return policyService.setStatus(policyNumber,status);
	}
	
	@RequestMapping(value="/policy/{userName}/{policyNumber}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public PolicyDetails getPolicy(@PathVariable(value="userName") String userName,@PathVariable(value="policyNumber") String policyNumber)
	{
		return policyService.getPolicyByPolicyNumber(policyNumber);			
	}
	
	@RequestMapping(value="/policy/{userName}/approved", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PolicyDetails> getAllApprovedPoliciesByUserName(@PathVariable(value="userName") String userName)
	{
		return policyService.getApprovedPolicy(userName);
	}
	@RequestMapping(value = "/policy/status/total", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AggregationList getAllPolicyStatusAggregated() {
	
		return 	policyService.getAggregatedPolicyStatus();				 
		
	}
}
