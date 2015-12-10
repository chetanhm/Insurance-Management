package com.im.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.collection.Policies;
import com.im.repository.PolicyRepository;

@Service
public class PolicyServiceImplementation implements PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;

	public long calculatePremium(String userName) {
		long totalPremium=0;
		List<Policies> policyList=policyRepository.findByUserName(userName);
		Iterator<Policies> iterator=policyList.iterator();
		while(iterator.hasNext())
		{
			Policies policy=iterator.next();
			totalPremium=totalPremium+policy.getMonthlyIncome();
		}
		return totalPremium;
	}

	public List<Policies> getRespectivePolicies(String userName) {
				return policyRepository.findByUserName(userName);
	}

}
