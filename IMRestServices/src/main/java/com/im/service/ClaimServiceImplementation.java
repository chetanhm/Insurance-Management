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
 * @author soni_k
 */
@Service
public class ClaimServiceImplementation implements ClaimServices{
	
	@Autowired
	private ClaimRepository claimRepository;

	public ClaimDetails addClaims(Claim claim) {

		ClaimDetails claimDetails=new ClaimDetails(claim.getClaimAmount(), claim.getClaimDocuments(), claim.getClaimType(),
				claim.getPolicyName(), claim.getClaimStatus(), claim.getAprrovedClaimAmount(),
				claim.getUserName(), claim.getDateOfClaim(), claim.getPolicyNumber());
			return claimRepository.insert(claimDetails);
		}
	
	public List<ClaimDetails> getClaimDisbursementByUserName(String userName) {
		
		return claimRepository.findByUserName(userName);

	}

	public List<ClaimDetails> getAllClaims() {
		// TODO Auto-generated method stub
		return claimRepository.findAll();
	}

	public ClaimDetails setClaimStatus(String id, String claimStatus) {
		// TODO Auto-generated method stub
		ClaimDetails updateClaimDetails = claimRepository.findOne(id);
		updateClaimDetails.setClaimStatus(claimStatus);
		claimRepository.save(updateClaimDetails);
		return updateClaimDetails;
	}
}
