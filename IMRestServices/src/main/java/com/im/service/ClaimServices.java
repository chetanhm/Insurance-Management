/**
 * 
 */
package com.im.service;

import java.util.List;

import com.im.collection.ClaimDetails;
import com.im.entity.Claim;

/**
 * @author khatwani_s
 *
 */
public interface ClaimServices {
	
	public ClaimDetails addClaims(Claim claim);
	public List<ClaimDetails> assessClaimDisbursement(String userName);

	}
