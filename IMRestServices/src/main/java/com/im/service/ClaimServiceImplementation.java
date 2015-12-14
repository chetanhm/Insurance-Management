/**
 * 
 */
package com.im.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.collection.ClaimDetails;
import com.im.entity.Claim;
import com.im.repository.ClaimRepository;

/**
 * @author khatwani_s
 *
 */
@Service
public class ClaimServiceImplementation implements ClaimServices{
	
	@Autowired
	private ClaimRepository claimRepository;

	public ClaimDetails addClaims(Claim claim) {
		ClaimDetails claimDetails=new ClaimDetails(
				claim.getClaimAmount(), claim.getClaimDocuments(), claim.getClaimType(), 
				claim.getPolicyName(), claim.getClaimStatus(), claim.getAprrovedClaimAmount());
		return claimRepository.insert(claimDetails);
		}
	

}
