/**
 * 
 */
package com.im.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.collection.ClaimDetails;
import com.im.entity.Claim;
import com.im.repository.ClaimRepository;

/**
 * @author khatwani_s
 * @author gurav_s
 *
 */
@Service
public class ClaimServiceImplementation implements ClaimServices{
	
	@Autowired
	private ClaimRepository claimRepository;

	public ClaimDetails addClaims(Claim claim) {
return null;
		}
	
	public List<ClaimDetails> assessClaimDisbursement(String userName) {
		
		return claimRepository.findByUserName(userName);

	}
}
