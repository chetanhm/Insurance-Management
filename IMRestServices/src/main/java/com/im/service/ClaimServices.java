/**
 * 
 */
package com.im.service;

import java.util.List;

import com.im.collection.ClaimDetails;
import com.im.entity.Claim;

/**
 * @author khatwani_s
 * @author gurav_s
 *
 */
public interface ClaimServices {
	
	public ClaimDetails addClaims(Claim claim);
	public List<ClaimDetails> getClaimDisbursementByUserName(String userName);
	public List<ClaimDetails> getAllClaims();

	}
