package com.retailer2customer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "transactionlist")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "NameOfCustomer")
	private String nameOfCustomer;
	@Column(name = "firstMonthAmount")
	private long firstMonthAmount;
	@Column(name = "secondMonthAmount")
	private long secondMonthAmount;
	@Column(name = "thirdMonthAmount")
	private long thirdMonthAmount;
	@Column(name = "totalPoints")
	private long totalPoints;
	@Column(name = "updatedtransactionDate")
	@DateTimeFormat(pattern="yyy-MM-dd-HH.mm.ss")
	private Date updatedtransactionDate;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getNameOfCustomer() {
		return nameOfCustomer;
	}
	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}
	public long getFirstMonthAmount() {
		return firstMonthAmount;
	}
	public void setFirstMonthAmount(long firstMonthAmount) {
		this.firstMonthAmount = firstMonthAmount;
	}
	public long getSecondMonthAmount() {
		return secondMonthAmount;
	}
	public void setSecondMonthAmount(long secondMonthAmount) {
		this.secondMonthAmount = secondMonthAmount;
	}
	public long getThirdMonthAmount() {
		return thirdMonthAmount;
	}
	public void setThirdMonthAmount(long thirdMonthAmount) {
		this.thirdMonthAmount = thirdMonthAmount;
	}
	public long getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(long totalPoints) {
		this.totalPoints = totalPoints;
	}
	public Date getUpdatedtransactionDate() {
		return updatedtransactionDate;
	}
	public void setUpdatedtransactionDate(Date updatedtransactionDate) {
		this.updatedtransactionDate = updatedtransactionDate;
	}






}
