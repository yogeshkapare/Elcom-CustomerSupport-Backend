package com.eipl.customersupport.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//This is for Corrective Action and Preventive Action

@Entity
public class ComplaintCapa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long capaid;
    private Long complaintid;
    private String actiontype; //Corrective action or Preventive action
    private String action;
    private String responsibility; //Name or email id of person
    private String remark; 
    private Date targetdate;
    private String actionstatus;
    private Date actualDateOfCompletion;
    
	public Long getCapaid() {
		return capaid;
	}
	public void setCapaid(Long capaid) {
		this.capaid = capaid;
	}
	public Long getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(Long complaintid) {
		this.complaintid = complaintid;
	}
	public String getActiontype() {
		return actiontype;
	}
	public void setActiontype(String actiontype) {
		this.actiontype = actiontype;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getTargetdate() {
		return targetdate;
	}
	public void setTargetdate(Date targetdate) {
		this.targetdate = targetdate;
	}
	public String getActionstatus() {
		return actionstatus;
	}
	public void setActionstatus(String actionstatus) {
		this.actionstatus = actionstatus;
	}
	public Date getActualDateOfCompletion() {
		return actualDateOfCompletion;
	}
	public void setActualDateOfCompletion(Date actualDateOfCompletion) {
		this.actualDateOfCompletion = actualDateOfCompletion;
	}
    
}
