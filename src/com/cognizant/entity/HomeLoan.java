package com.cognizant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.cognizant.entity.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "HOME_LOAN_DETAILS ")
public class HomeLoan {

	// @GeneratedValue(strategy=GenerationType.AUTO)

	private String homeLoanId;

	// @Column(name="LOAN_AMOUNT")
	@NotNull
	private long loanAmount;

	// @Column(name="LOAN_DURATION")
	@NotNull(message = "Mandatory field")
	private int loanDuration;

	// long accountNumber;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull(message = "Mandatory field")
	private String loanApplyDate;
	@NotNull(message = "Mandatory field")
	private long annualIncome;
	@NotNull(message = "Mandatory field")
	private String companyName;
	@NotNull(message = "Mandatory field")
	private String designation;
	@NotNull(message = "Mandatory field")
	private int totalExperience;
	@NotNull(message = "Mandatory field")
	private int currentExperience;

	@Id
	private long loanAccountNumber;

	public long getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(long loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnore
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private UserDetails user;

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public String getHomeLoanId() {
		return homeLoanId;
	}

	public void setHomeLoanId(String homeLoanId) {
		this.homeLoanId = homeLoanId;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}

	public String getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(String loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public int getCurrentExperience() {
		return currentExperience;
	}

	public void setCurrentExperience(int currentExperience) {
		this.currentExperience = currentExperience;
	}

	/*
	 * @Override public String toString() { return "HomeLoan [homeLoanId=" +
	 * homeLoanId + ", loanAmount=" + loanAmount + ", loanDuration=" +
	 * loanDuration + ", loanApplyDate=" + loanApplyDate + ", annualIncome=" +
	 * annualIncome + ", companyName=" + companyName + ", designation=" +
	 * designation + ", totalExperience=" + totalExperience +
	 * ", currentExperience=" + currentExperience + ", loanAccountNumber=" +
	 * loanAccountNumber + "]"; }
	 */
	public HomeLoan(long loanAmount, int loanDuration, String loanApplyDate, long annualIncome, String companyName,
			String designation, int totalExperience, int currentExperience, UserDetails user) {
		super();
		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExperience = totalExperience;

		this.currentExperience = currentExperience;
		this.user = user;
	}

	public HomeLoan() {
	}
}
