package com.im.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="policies")
public class Policies {
	
	@Id
	private String id;
	private String userName;
	private String policyName;
	private long monthlyIncome;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public long getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(long monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	
	public Policies(String id, String userName, String policyName, long monthlyIncome) {
		super();
		this.id = id;
		this.userName = userName;
		this.policyName = policyName;
		this.monthlyIncome = monthlyIncome;
	}
	
	public Policies() {
		super();
	}
	@Override
	public String toString() {
		return "Policies [id=" + id + ", policyName=" + policyName + ", monthlyIncome=" + monthlyIncome + "]";
	}
	
	

}
