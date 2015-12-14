package com.im.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.collection.PolicyDetails;
import com.im.entity.AddPolicy;
import com.im.repository.PolicyRepository;
import com.im.repository.ProductRepository;


@Service
public class PolicyServiceImplementation implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;
	@Autowired
	private ProductRepository productRepository;

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

	public List<PolicyDetails> getRespectivePolicies(String userName) {
		return policyRepository.findByUserName(userName);
	}

	public PolicyDetails addPolicy(AddPolicy policy) {
		int policyNumber = (int) (Math.random() * 100000);
		long monthlyPremium = productRepository.findByName(policy.getProductName()).getMonthlyPremium();
		return policyRepository.insert(new PolicyDetails(policyNumber, policy.getUserName(), policy.getProductName(),
				monthlyPremium, policy.getAnnualIncome(), policy.getSmoker(), policy.getIncomeProofFile(),
				policy.getResidenceProofFile(), policy.getAgeProofFile(), policy.getPhotoFile(), "pending"));
	}
	
	public List<PolicyDetails> getAllPolicies() {
		return policyRepository.findAll();
	}

	public PolicyDetails setStatus(String policyNumber, String status) {
		// TODO Auto-generated method stub
		PolicyDetails updatePolicyDetails = policyRepository.findOne(policyNumber);
		updatePolicyDetails.setStatus(status);
		policyRepository.save(updatePolicyDetails);
		return updatePolicyDetails;
	}

	
	
	
}
