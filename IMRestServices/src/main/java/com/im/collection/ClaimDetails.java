package com.im.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "claimDetails")
public class ClaimDetails {
	@Id
	private String id;
	private long claimAmount;
	private String claimDocuments;
	private String claimType;
	private String policyName;
	private String claimStatus;
	private long aprrovedClaimAmount;

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(long claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getClaimDocuments() {
		return claimDocuments;
	}
	public void setClaimDocuments(String claimDocuments) {
		this.claimDocuments = claimDocuments;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public long getAprrovedClaimAmount() {
		return aprrovedClaimAmount;
	}
	public void setAprrovedClaimAmount(long aprrovedClaimAmount) {
		this.aprrovedClaimAmount = aprrovedClaimAmount;
	}
	public ClaimDetails( long claimAmount, String claimDocuments, String claimType, String policyName,
			String claimStatus, long aprrovedClaimAmount) {
		super();
		this.claimAmount = claimAmount;
		this.claimDocuments=claimDocuments;
		this.claimType = claimType;
		this.policyName = policyName;
		this.claimStatus = claimStatus;
		this.aprrovedClaimAmount = aprrovedClaimAmount;
	}
	@Override
	public String toString() {
		return "ClaimDetails [id=" + id + ", claimAmount=" + claimAmount + ", claimDocuments=" + claimDocuments
				+ ", claimType=" + claimType + ", policyName=" + policyName + ", claimStatus=" + claimStatus
				+ ", aprrovedClaimAmount=" + aprrovedClaimAmount + "]";
	}


}
