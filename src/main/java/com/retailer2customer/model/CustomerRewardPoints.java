package com.retailer2customer.model;

public class CustomerRewardPoints {
	
	private String nameOfCustomer;
	private long rewardsForMonth1;
	private long rewardsForMonth2;
	private long rewardsForMonth3;
	private long totalRewards;
	
	
	public String getNameOfCustomer() {
		return nameOfCustomer;
	}
	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}
	public long getRewardsForMonth1() {
		return rewardsForMonth1;
	}
	public void setRewardsForMonth1(long rewardsForMonth1) {
		this.rewardsForMonth1 = rewardsForMonth1;
	}
	public long getRewardsForMonth2() {
		return rewardsForMonth2;
	}
	public void setRewardsForMonth2(long rewardsForMonth2) {
		this.rewardsForMonth2 = rewardsForMonth2;
	}
	public long getRewardsForMonth3() {
		return rewardsForMonth3;
	}
	public void setRewardsForMonth3(long rewardsForMonth3) {
		this.rewardsForMonth3 = rewardsForMonth3;
	}
	public long getTotalRewards() {
		return totalRewards;
	}
	public void setTotalRewards(long totalRewards) {
		this.totalRewards = totalRewards;
	}
	
	

}
