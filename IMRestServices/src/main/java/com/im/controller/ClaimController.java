package com.im.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.im.collection.ClaimDetails;
import com.im.entity.Claim;
import com.im.entity.AggregationList;
import com.im.service.ClaimServices;


@CrossOrigin
@RestController
@RequestMapping(value = "/imservices")
public class ClaimController {
	
	@Autowired
	private ClaimServices claimService;
	
	@RequestMapping(value="/claim", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ClaimDetails submitClaim(@RequestBody Claim claim)
	{
		return claimService.addClaims(claim);
	}
	
	@RequestMapping(value = "/claim", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ClaimDetails> getClaimDisbursementByUserName(
			@RequestParam(name = "userName") String userName)
	{
	return claimService.getClaimDisbursementByUserName(userName);
		
	}
	
	@RequestMapping(value="/claim/pending", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClaimDetails> getAllClaims()
	{
		return claimService.getPendingClaims();		
	}
	
	@RequestMapping(value="/claim",method = RequestMethod.PUT)
	public ClaimDetails updateStatus(@RequestParam(name="id")String id, @RequestParam(name="claimStatus")String claimStatus)
	{
		return claimService.setClaimStatus(id,claimStatus);
	}
	@RequestMapping(value = "/claim/type/total", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AggregationList getAllClaimsAggregated() {
	
		return 	claimService.getAggregatedClaimType();				 
		
	}
}
