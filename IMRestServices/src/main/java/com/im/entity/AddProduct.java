package com.im.entity;

import java.util.List;
/**
 * This is bean class for request on add policy REST
 * @author mendhe_c
 *
 */
public class AddProduct {

	/**
	 * Stores product name 
	 */
	private String productName;
	/**
	 * Stores basic coverage amount which is going to be given to customer/nominee on maturity or accident or natural death
	 */
	private long basicCoverage;
	/**
	 * Stores accidental benefit amount which is going to be given to customer's nominee on event of accident
	 */
	private long accidentalBenefit;
	/**
	 * If claims are made, if claim is approved percentage (stored in settlementRatio) of claim amount will be given out
	 */
	private double settlementRatio;
	/**
	 * Stores monthly premium 
	 */
	private long monthlyPremium;
	/**
	 * Stores list of product terms
	 */
	private List<String> productTerms;
	/**
	 * Stores description of policy
	 */
	private String description;
	/**
	 * Stores term of policy, in years
	 * @return
	 */
	private int termYear;
	
	/**
	 * Default constructor
	 */
	public AddProduct() {
		
	}
	
	public int getTermYear() {
		return termYear;
	}


	public void setTermYear(int termYear) {
		this.termYear = termYear;
	}

	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	

	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public long getBasicCoverage() {
		return basicCoverage;
	}


	public void setBasicCoverage(long basicCoverage) {
		this.basicCoverage = basicCoverage;
	}


	public long getAccidentalBenefit() {
		return accidentalBenefit;
	}


	public void setAccidentalBenefit(long accidentalBenefit) {
		this.accidentalBenefit = accidentalBenefit;
	}


	public double getSettlementRatio() {
		return settlementRatio;
	}


	public void setSettlementRatio(double settlementRatio) {
		this.settlementRatio = settlementRatio;
	}


	public long getMonthlyPremium() {
		return monthlyPremium;
	}


	public void setMonthlyPremium(long monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}

	public List<String> getProductTerms() {
		return productTerms;
	}

	public void setProductTerms(List<String> productTerms) {
		this.productTerms = productTerms;
	}

	@Override
	public String toString() {
		return "AddProduct [productName=" + productName + ", basicCoverage=" + basicCoverage + ", accidentalBenefit="
				+ accidentalBenefit + ", settlementRatio=" + settlementRatio + ", monthlyPremium=" + monthlyPremium
				+ ", productTerms=" + productTerms + ", description=" + description + ", termYear=" + termYear + "]";
	}


	
	
	
	
}
