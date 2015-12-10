package com.im.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.im.collection.Policies;
import com.im.service.PolicyService;

@CrossOrigin
@RestController
@RequestMapping(value="/imservices")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@RequestMapping(value=" /getPremium", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public long getTotalPremium(@RequestParam(name="userName") String userName)
	{
		return policyService.calculatePremium(userName);
	}
	
	@RequestMapping(value=" /getAllPolicies", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Policies> getAllPolicies(@RequestParam(name="userName") String userName)
	{
		return policyService.getRespectivePolicies(userName);
	}


}
