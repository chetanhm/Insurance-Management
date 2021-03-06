package com.im.entity;

import java.util.Date;

public class Claim {
private long claimAmount;
private String claimDocuments;
private String claimType;
private String policyName;
private String claimStatus;
private long aprrovedClaimAmount;
private String userName;
private Date dateOfClaim;
private String policyNumber; 

public Claim(){
	
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public Date getDateOfClaim() {
	return dateOfClaim;
}

public void setDateOfClaim(Date dateOfClaim) {
	this.dateOfClaim = dateOfClaim;
}

public String getPolicyNumber() {
	return policyNumber;
}

public void setPolicyNumber(String policyNumber) {
	this.policyNumber = policyNumber;
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
	this.claimDocuments= claimDocuments;
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

public Claim(long claimAmount, String claimDocuments, String claimType, String policyName, String claimStatus,
		long aprrovedClaimAmount, String userName, Date dateOfClaim, String policyNumber) {
	super();
	this.claimAmount = claimAmount;
	this.claimDocuments = claimDocuments;
	this.claimType = claimType;
	this.policyName = policyName;
	this.claimStatus = claimStatus;
	this.aprrovedClaimAmount = aprrovedClaimAmount;
	this.userName = userName;
	this.dateOfClaim = dateOfClaim;
	this.policyNumber = policyNumber;
}

@Override
public String toString() {
	return "Claim [claimAmount=" + claimAmount + ", claimDocuments=" + claimDocuments + ", claimType=" + claimType
			+ ", policyName=" + policyName + ", claimStatus=" + claimStatus + ", aprrovedClaimAmount="
			+ aprrovedClaimAmount + ", userName=" + userName + ", dateOfClaim=" + dateOfClaim + ", policyNumber="
			+ policyNumber + "]";
}




}
