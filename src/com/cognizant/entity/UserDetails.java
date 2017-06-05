package com.cognizant.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@Column(name = "ACCOUNT_NUMBER")
	long accountNumber;

	@Column(name = "ACCOUNT_TYPE", length = 20)
	// @Type(type="text")
	String accountType;

	@Column(name = "ACCOUNT_HOLDER_NAME", length = 20)
	// @Type(type="text")
	String acountHolderName;

	@Column(name = "ACCOUNT_BALANCE", length = 20)
	// @Type(type="number")
	int accountBalance;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private List<HomeLoan> homeLoan;

	public List<HomeLoan> getHomeLoan() {
		return homeLoan;
	}

	public void setHomeLoan(List<HomeLoan> homeLoan) {
		this.homeLoan = homeLoan;
	}

	public UserDetails() {
	}

	public UserDetails(long accountNumber, String accountType, String acountHolderName, int accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.acountHolderName = acountHolderName;
		this.accountBalance = accountBalance;
	}

	/*
	 * @Override public String toString() { return "UserDetails [accountNumber="
	 * + accountNumber + ", accountType=" + accountType + ", acountHolderName="
	 * + acountHolderName + ", accountBalance=" + accountBalance + ", homeLoan="
	 * + homeLoan + ", eduLoan=" + eduLoan + ", tdDetails=" + tdDetails + "]"; }
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_NUMBER")
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAcountHolderName() {
		return acountHolderName;
	}

	public void setAcountHolderName(String acountHolderName) {
		this.acountHolderName = acountHolderName;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EducationLoan> eduLoan;

	public List<EducationLoan> getEduLoan() {
		return eduLoan;
	}

	public void setEduLoan(List<EducationLoan> eduLoan) {
		this.eduLoan = eduLoan;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<TransactionDetails> tdDetails;

	public List<TransactionDetails> getTdDetails() {
		return tdDetails;
	}

	public void setTdDetails(List<TransactionDetails> tdDetails) {
		this.tdDetails = tdDetails;
	}

}
