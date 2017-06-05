package com.cognizant.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "EDUCATION_LOAN_DETAILS")
public class EducationLoan {

	@Column(name = "EDUCATION_LOAN_ID")
	private String educationLoanID;

	// @Column(name="Account_number")
	// private int Account_Number;
	@Id
	@Column(name = "Edu_Loan_Account_Number")
	private long eduLoanAccountNumber;

	@NotNull(message = "Mandatory field")
	@Column(name = "Edu_Loan_Amount")
	private double eduLoanAmount;

	@NotNull(message = "Mandatory field")
	@Column(name = "Loan_Apply_Date")
	private Date loanApplyDate;

	@NotNull(message = "Mandatory field")
	@Column(name = "Edu_Loan_Duration")
	private int eduLoanDuration;

	@NotNull(message = "Mandatory field")
	@Column(name = "Father_Annual_Income")
	private double fatherAnnualIncome;

	@NotNull(message = "Mandatory field")
	@Min(0)
	@Max(2000000)
	@Column(name = "Course_Fee")
	private double courseFee;

	@NotBlank(message = "Mandatory field")
	@Column(name = "Course_Name")
	private String courseName;

	@NotNull(message = "Mandatory field")
	@Column(name = "Father_Name")
	private String fatherName;
	
	@NotNull(message = "Mandatory field")
	@Column(name = "ID_Card_Number")
	private int idCardNumber;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Account_Number")
	private UserDetails user;

	public EducationLoan() {

	}

	/*
	 * @Override public String toString() { return
	 * "EducationLoan [educationLoanID=" + educationLoanID +
	 * ", eduLoanAccountNumber=" + eduLoanAccountNumber + ", eduLoanAmount=" +
	 * eduLoanAmount + ", loanApplyDate=" + loanApplyDate + ", eduLoanDuration="
	 * + eduLoanDuration + ", fatherAnnualIncome=" + fatherAnnualIncome +
	 * ", courseFee=" + courseFee + ", courseName=" + courseName +
	 * ", fatherName=" + fatherName + ", idCardNumber=" + idCardNumber +
	 * ", user=" + user + "]"; }
	 */

	public EducationLoan(double eduLoanAmount, Date loanApplyDate, int eduLoanDuration, double fatherAnnualIncome,
			double courseFee, String courseName, String fatherName, int idCardNumber, UserDetails user) {
		super();

		// this.eduLoanAccountNumber = eduLoanAccountNumber;
		this.eduLoanAmount = eduLoanAmount;
		this.loanApplyDate = loanApplyDate;
		this.eduLoanDuration = eduLoanDuration;
		this.fatherAnnualIncome = fatherAnnualIncome;
		this.courseFee = courseFee;
		this.courseName = courseName;
		this.fatherName = fatherName;
		this.idCardNumber = idCardNumber;
		this.user = user;
	}

	public String getEducationLoanID() {
		return educationLoanID;
	}

	public void setEducationLoanID(String educationLoanID) {
		this.educationLoanID = educationLoanID;
	}

	public long getEduLoanAccountNumber() {
		return eduLoanAccountNumber;
	}

	public void setEduLoanAccountNumber(long eduLoanAccountNumber) {
		this.eduLoanAccountNumber = eduLoanAccountNumber;
	}

	public double getEduLoanAmount() {
		return eduLoanAmount;
	}

	public void setEduLoanAmount(double eduLoanAmount) {
		this.eduLoanAmount = eduLoanAmount;
	}

	public Date getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public int getEduLoanDuration() {
		return eduLoanDuration;
	}

	public void setEduLoanDuration(int eduLoanDuration) {
		this.eduLoanDuration = eduLoanDuration;
	}

	public double getFatherAnnualIncome() {
		return fatherAnnualIncome;
	}

	public void setFatherAnnualIncome(double fatherAnnualIncome) {
		this.fatherAnnualIncome = fatherAnnualIncome;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public int getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(int idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
}
