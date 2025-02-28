package com.eipl.customersupport.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Containment Action

@Entity
public class ComplaintCa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caid;
    private Long complaintid;
    private String stocklocation;
    private Long okqty;
    private Long notokqty;
    private String remark;
    private String responsiblePerson;
    private Date targetDateOfCompletion;
    private Date actualDateOfCompletion;
    private String caStatus;

//    @ManyToOne
//    @JoinColumn(name = "complaintid")
//    private ComplaintRegistration complaintRegistration;
    
	public Long getCaid() {
		return caid;
	}
	public void setCaid(Long caid) {
		this.caid = caid;
	}
	public Long getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(Long complaintid) {
		this.complaintid = complaintid;
	}
	public String getStocklocation() {
		return stocklocation;
	}
	public void setStocklocation(String stocklocation) {
		this.stocklocation = stocklocation;
	}
	public Long getOkqty() {
		return okqty;
	}
	public void setOkqty(Long okqty) {
		this.okqty = okqty;
	}
	public Long getNotokqty() {
		return notokqty;
	}
	public void setNotokqty(Long notokqty) {
		this.notokqty = notokqty;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getResponsiblePerson() {
		return responsiblePerson;
	}
	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}
	public Date getTargetDateOfCompletion() {
		return targetDateOfCompletion;
	}
	public void setTargetDateOfCompletion(Date targetDateOfCompletion) {
		this.targetDateOfCompletion = targetDateOfCompletion;
	}
	public Date getActualDateOfCompletion() {
		return actualDateOfCompletion;
	}
	public void setActualDateOfCompletion(Date actualDateOfCompletion) {
		this.actualDateOfCompletion = actualDateOfCompletion;
	}
	public String getCaStatus() {
		return caStatus;
	}
	public void setCaStatus(String caStatus) {
		this.caStatus = caStatus;
	}
	
}
