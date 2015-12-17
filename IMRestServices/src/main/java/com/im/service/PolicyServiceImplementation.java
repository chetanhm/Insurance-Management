package com.im.service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import com.im.collection.PolicyDetails;
import com.im.entity.AddPolicy;
import com.im.entity.AggregationList;
import com.im.entity.AggregationElement;
import com.im.repository.PolicyRepository;
import com.im.repository.ProductRepository;


@Service
public class PolicyServiceImplementation implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private MongoOperations mongoOperations;

	public long calculatePremium(String userName) {
		long totalPremium = 0;
		List<PolicyDetails> policyList = policyRepository.findByUserName(userName);
		Iterator<PolicyDetails> iterator = policyList.iterator();
		while (iterator.hasNext()) {
			PolicyDetails policy = iterator.next();
			totalPremium = totalPremium + policy.getMonthlyPremium();
		}
		return totalPremium;
	}

	public List<PolicyDetails> getPoliciesByUserName(String userName) {
		return policyRepository.findByUserName(userName);
	}

	public PolicyDetails addPolicy(AddPolicy policy) {
		int policyNumber = (int) (Math.random() * 100000);
		long monthlyPremium = productRepository.findByName(policy.getProductName()).getMonthlyPremium();
		return policyRepository.insert(new PolicyDetails(policyNumber, policy.getUserName(), policy.getProductName(),
				monthlyPremium, policy.getAnnualIncome(), policy.getSmoker(), policy.getIncomeProofFile(),
				policy.getResidenceProofFile(), policy.getAgeProofFile(), policy.getPhotoFile(), "pending",policy.getEmployement()));
	}
	
	public List<PolicyDetails> getAllPolicies() {
		return policyRepository.findAll();
	}

	public PolicyDetails setStatus(String policyNumber, String status) {
		// TODO Auto-generated method stub
		PolicyDetails updatePolicyDetails = policyRepository.findByPolicyNumber(Long.parseLong(policyNumber));
		updatePolicyDetails.setStatus(status);
		policyRepository.save(updatePolicyDetails);
		return updatePolicyDetails;
	}

	public PolicyDetails getPolicyByPolicyNumber(String policyNumber) {
		// TODO Auto-generated method stub
		return policyRepository.findByPolicyNumber(Long.parseLong(policyNumber));
		
	}

	
	public List<PolicyDetails> getApprovedPolicy(String userName) {
		List<PolicyDetails> approvedPolicyList=new ArrayList<PolicyDetails>();
		List<PolicyDetails> listPolicies=policyRepository.findByUserName(userName);
		Iterator<PolicyDetails> iterator=listPolicies.iterator();
		while(iterator.hasNext())
		{
			PolicyDetails policy=iterator.next();
			if(policy.getStatus().equals("approved"))
			{
				approvedPolicyList.add(policy);
			}
		}
		return approvedPolicyList;
	}

	public AggregationList getAggregatedPolicyStatus() {
		AggregationList aggregationList = new AggregationList(new ArrayList<String>(), new ArrayList<String>());
		Aggregation agg = newAggregation(group("status").count().as("total"));
		AggregationResults<AggregationElement> aggregate = mongoOperations.aggregate(agg, "policies",
				AggregationElement.class);
		List<AggregationElement> mappedResults = aggregate.getMappedResults();
		for (AggregationElement m : mappedResults) {
			aggregationList.getLabels().add(m.get_id());
			aggregationList.getData().add(m.getTotal());
		}
		return aggregationList;
	}

	
}
