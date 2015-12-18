/**
 * 
 */
package com.im.service;


import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import com.im.collection.ClaimDetails;
import com.im.collection.ProductDetails;
import com.im.entity.Claim;
import com.im.entity.AggregationList;
import com.im.entity.AggregationElement;
import com.im.repository.ClaimRepository;
import com.im.repository.ProductRepository;

/**
 * @author khatwani_s
 * @author gurav_s
 * @author soni_k
 * @author mendhe_c
 */
@Service
public class ClaimServiceImplementation implements ClaimServices{
	
	@Autowired
	private ClaimRepository claimRepository;
	@Autowired
	private MongoOperations mongoOperations;
	@Autowired
	private ProductRepository productRepository;
	
	public ClaimDetails addClaims(Claim claim) {

		ProductDetails productDetails  = productRepository.findByName(claim.getPolicyName());
		long applicableClaimAmount = (long) (claim.getClaimAmount()*(productDetails.getSettlementRatio()/100));
		ClaimDetails claimDetails=new ClaimDetails(claim.getClaimAmount(), claim.getClaimDocuments(), claim.getClaimType(),
				claim.getPolicyName(), claim.getClaimStatus(), applicableClaimAmount,
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

	public AggregationList getAggregatedClaimType() {
		AggregationList aggregationList = new AggregationList(new ArrayList<String>(), new ArrayList<String>());
		Aggregation agg = newAggregation(group("claimType").count().as("total"));
		AggregationResults<AggregationElement> aggregate = mongoOperations.aggregate(agg, "claimDetails",
				AggregationElement.class);
		List<AggregationElement> mappedResults = aggregate.getMappedResults();
		for (AggregationElement m : mappedResults) {
			aggregationList.getLabels().add(m.get_id());
			aggregationList.getData().add(m.getTotal());
		}
		return aggregationList;
	}
}
