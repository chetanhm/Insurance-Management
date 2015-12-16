package com.im.entity;

public class AddPolicy {

	private String userName;
	private String productName;
	private long annualIncome;
	private String smoker;
	private String incomeProofFile;
	private String residenceProofFile;
	private String ageProofFile;
	private String photoFile;
	private String employement;
	
	
	public AddPolicy() {
		// TODO Auto-generated constructor stub
	}




	public AddPolicy(String userName, String productName, long annualIncome, String smoker, String incomeProofFile,
			String residenceProofFile, String ageProofFile, String photoFile, String employement) {
		this.userName = userName;
		this.productName = productName;
		this.annualIncome = annualIncome;
		this.smoker = smoker;
		this.incomeProofFile = incomeProofFile;
		this.residenceProofFile = residenceProofFile;
		this.ageProofFile = ageProofFile;
		this.photoFile = photoFile;
		this.employement = employement;
	}




	public String getEmployement() {
		return employement;
	}




	public void setEmployement(String employement) {
		this.employement = employement;
	}




	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
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


	@Override
	public String toString() {
		return "AddPolicy [userName=" + userName + ", productName=" + productName + ", annualIncome=" + annualIncome
				+ ", smoker=" + smoker + ", incomeProofFile=" + incomeProofFile + ", residenceProofFile="
				+ residenceProofFile + ", ageProofFile=" + ageProofFile + ", photoFile=" + photoFile + "]";
	}

	


	
}
