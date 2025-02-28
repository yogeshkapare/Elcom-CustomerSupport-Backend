package com.eipl.customersupport.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Temporal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ComplaintRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintid;
    private String prodcode;
    private String proddesc;
    private String customer;
    private String invoicenumber;
    private int invoiceqty;
    private int defectiveqty;
    private String customeremailid;
    private String modeofcommunication; //email, phone, 
    private String description;
    private String priority;
    private Date createdDate;
    private String complaintstatus =  "Acknowledged"; // Default status
    private String registeredBy; 
    private Date complaintRecdDate;
    
    private Date complaintacceptedon;
    private Date defectivesamplerecdon; //Defective samples received on date
    private String complainttype; //Technical or Non-technical
    private String actualobservation;
    private String productBatchSerialNumber;
    private String reviewedBy;
    private String closedBy;
    @Column(name = "closed_on_date")
    private Date closedOnDate;
    private String reviewedByRemark;
    private String closedByRemark;
    private int defectiveSampleQty;
    private Date advanceReplacementGivenOn;
    private String advanceReplacementNote;
    
    @OneToMany(mappedBy = "complaintid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ComplaintCa> complaintCa;
    
	public Long getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(Long complaintid) {
		this.complaintid = complaintid;
	}
	public String getProdcode() {
		return prodcode;
	}
	public void setProdcode(String prodcode) {
		this.prodcode = prodcode;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}
	public int getInvoiceqty() {
		return invoiceqty;
	}
	public void setInvoiceqty(int invoiceqty) {
		this.invoiceqty = invoiceqty;
	}
	public int getDefectiveqty() {
		return defectiveqty;
	}
	public void setDefectiveqty(int defectiveqty) {
		this.defectiveqty = defectiveqty;
	}
	public String getCustomeremailid() {
		return customeremailid;
	}
	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}
	public String getModeofcommunication() {
		return modeofcommunication;
	}
	public void setModeofcommunication(String modeofcommunication) {
		this.modeofcommunication = modeofcommunication;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getComplaintstatus() {
		return complaintstatus;
	}
	public void setComplaintstatus(String complaintstatus) {
		this.complaintstatus = complaintstatus;
	}
	public String getRegisteredBy() {
		return registeredBy;
	}
	public void setRegisteredBy(String registeredBy) {
		this.registeredBy = registeredBy;
	}
	public Date getComplaintRecdDate() {
		return complaintRecdDate;
	}
	public void setComplaintRecdDate(Date complaintRecdDate) {
		this.complaintRecdDate = complaintRecdDate;
	}
	public Date getComplaintacceptedon() {
		return complaintacceptedon;
	}
	public void setComplaintacceptedon(Date complaintacceptedon) {
		this.complaintacceptedon = complaintacceptedon;
	}
	public Date getDefectivesamplerecdon() {
		return defectivesamplerecdon;
	}
	public void setDefectivesamplerecdon(Date defectivesamplerecdon) {
		this.defectivesamplerecdon = defectivesamplerecdon;
	}
	public String getComplainttype() {
		return complainttype;
	}
	public void setComplainttype(String complainttype) {
		this.complainttype = complainttype;
	}
	public String getActualobservation() {
		return actualobservation;
	}
	public void setActualobservation(String actualobservation) {
		this.actualobservation = actualobservation;
	}
	public String getProductBatchSerialNumber() {
		return productBatchSerialNumber;
	}
	public void setProductBatchSerialNumber(String productBatchSerialNumber) {
		this.productBatchSerialNumber = productBatchSerialNumber;
	}
	public String getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public String getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}
	public Date getClosedOnDate() {
		return closedOnDate;
	}
	public void setClosedOnDate(Date closedOnDate) {
		this.closedOnDate = closedOnDate;
	}
	public String getReviewedByRemark() {
		return reviewedByRemark;
	}
	public void setReviewedByRemark(String reviewedByRemark) {
		this.reviewedByRemark = reviewedByRemark;
	}
	public String getClosedByRemark() {
		return closedByRemark;
	}
	public void setClosedByRemark(String closedByRemark) {
		this.closedByRemark = closedByRemark;
	}
	public int getDefectiveSampleQty() {
		return defectiveSampleQty;
	}
	public void setDefectiveSampleQty(int defectiveSampleQty) {
		this.defectiveSampleQty = defectiveSampleQty;
	}
	public Date getAdvanceReplacementGivenOn() {
		return advanceReplacementGivenOn;
	}
	public void setAdvanceReplacementGivenOn(Date advanceReplacementGivenOn) {
		this.advanceReplacementGivenOn = advanceReplacementGivenOn;
	}
	public String getAdvanceReplacementNote() {
		return advanceReplacementNote;
	}
	public void setAdvanceReplacementNote(String advanceReplacementNote) {
		this.advanceReplacementNote = advanceReplacementNote;
	}
    
}
