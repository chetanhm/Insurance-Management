/**
 * 
 */
package com.im.service;

import java.util.List;

import com.im.collection.ClaimDetails;
import com.im.entity.Claim;
import com.im.entity.AggregationList;

/**
 * @author soni_k
 * @author khatwani_s
 * @author gurav_s 
 * @author mendhe_c
 */
public interface ClaimServices {
	
	public ClaimDetails addClaims(Claim claim);
	public List<ClaimDetails> getClaimDisbursementByUserName(String userName);
	public List<ClaimDetails> getAllClaims();
	public ClaimDetails setClaimStatus(String id, String claimStatus);
	public AggregationList getAggregatedClaimType();
	}
