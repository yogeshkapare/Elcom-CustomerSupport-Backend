package com.eipl.customersupport.models;

import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ComplaintCommunication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long communicationid;
    private Long complaintid;
    private String postedby; //Communication posted by
    private Timestamp postedon;
    private String comments;
    private String filename;
    
	public Long getCommunicationid() {
		return communicationid;
	}
	public void setCommunicationid(Long communicationid) {
		this.communicationid = communicationid;
	}
	public Long getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(Long complaintid) {
		this.complaintid = complaintid;
	}
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	public Timestamp getPostedon() {
		return postedon;
	}
	public void setPostedon(Timestamp postedon) {
		this.postedon = postedon;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
    
}
