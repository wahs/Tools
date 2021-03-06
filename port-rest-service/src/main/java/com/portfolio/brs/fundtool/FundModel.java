package com.portfolio.brs.fundtool;

import java.math.BigDecimal;

/******************************************************************************
 * @author B Stanley
 * 
 * This class contains the individual allocations to support the Equity, Bond 
 * and Cash Allocations for each Model: AggressiveGrowth, Growth, Income, 
 * Retirement
 * 
 * A fundModel is aligned with the customer in the Portfolio class as a 
 * Portfolio member of the Shareholders list.
 */
public class FundModel {
	private String fundCategory; 	// Equity, Bond, Cash 
	private double allocationPercentage; 
	private BigDecimal allocationAmount; 

	public FundModel(String name, double percent)
	{
		fundCategory = name;

		// Need to make sure it does not exceed 100 for all allocations
		allocationPercentage = percent;
		allocationAmount = BigDecimal.ZERO;
	}

	/** 
	 * Calculate the amount to allocate to each of the funds according
	 * to the allocation percentage for each of the asset classes.
	 * 
	 * @param amount
	 */

	public void setAllocationAmount(double amount) {
		BigDecimal bdAmount = new BigDecimal(amount);
		BigDecimal allocPercent = new BigDecimal(allocationPercentage);
		allocationAmount = bdAmount.multiply(allocPercent);
	}

	// Convenience methods
	public double getAllocationPercent() {return allocationPercentage;}
	public double getAllocationAmount() {return allocationAmount.doubleValue();}
	
}
