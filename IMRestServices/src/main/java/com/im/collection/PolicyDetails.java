package com.im.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "policies")
public class PolicyDetails {

	@Id
	private String id;
	private long policyNumber;
	private String userName;
	private String productName;
	private long monthlyPremium;
	private long annualIncome;
	private String smoker;
	private String incomeProofFile;
	private String residenceProofFile;
	private String ageProofFile;
	private String photoFile;
	private String status;

	public PolicyDetails() {

	}

	public PolicyDetails(int policyNumber, String userName, String productName, long monthlyPremium,
			long annualIncome, String smoker, String incomeProofFile, String residenceProofFile, String ageProofFile,
			String photoFile, String status) {
		this.policyNumber = policyNumber;
		this.userName = userName;
		this.productName = productName;
		this.monthlyPremium = monthlyPremium;
		this.annualIncome = annualIncome;
		this.smoker = smoker;
		this.incomeProofFile = incomeProofFile;
		this.residenceProofFile = residenceProofFile;
		this.ageProofFile = ageProofFile;
		this.photoFile = photoFile;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getMonthlyPremium() {
		return monthlyPremium;
	}

	public void setMonthlyPremium(long monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}

	public long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getSmoker() {
		return smoker;
	}

	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}

	public String getIncomeProofFile() {
		return incomeProofFile;
	}

	public void setIncomeProofFile(String incomeProofFile) {
		this.incomeProofFile = incomeProofFile;
	}

	public String getResidenceProofFile() {
		return residenceProofFile;
	}

	public void setResidenceProofFile(String residenceProofFile) {
		this.residenceProofFile = residenceProofFile;
	}

	public String getAgeProofFile() {
		return ageProofFile;
	}

	public void setAgeProofFile(String ageProofFile) {
		this.ageProofFile = ageProofFile;
	}

	public String getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(String photoFile) {
		this.photoFile = photoFile;
	}

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
		return productName;
	}

	public void setPolicyName(String policyName) {
		this.productName = policyName;
	}


	@Override
	public String toString() {
		return "PolicyDetails [id=" + id + ", policyNumber=" + policyNumber + ", userName=" + userName
				+ ", productName=" + productName + ", monthlyPremium=" + monthlyPremium + ", annualIncome="
				+ annualIncome + ", smoker=" + smoker + ", incomeProofFile=" + incomeProofFile + ", residenceProofFile="
				+ residenceProofFile + ", ageProofFile=" + ageProofFile + ", photoFile=" + photoFile + "]";
	}

}
