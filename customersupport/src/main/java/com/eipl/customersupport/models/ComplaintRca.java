package com.eipl.customersupport.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ComplaintRca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rcaid;
    private Long complaintid;
    private String whyFailOccur;
    private String whyDetectFail;
    private String whyPreventFail;
    private String failCause;
    private String detectCause;
    private String preventCause;
    

	public Long getRcaid() {
		return rcaid;
	}
	public void setRcaid(Long rcaid) {
		this.rcaid = rcaid;
	}
	public Long getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(Long complaintid) {
		this.complaintid = complaintid;
	}
	public String getWhyFailOccur() {
		return whyFailOccur;
	}
	public void setWhyFailOccur(String whyFailOccur) {
		this.whyFailOccur = whyFailOccur;
	}
	public String getWhyDetectFail() {
		return whyDetectFail;
	}
	public void setWhyDetectFail(String whyDetectFail) {
		this.whyDetectFail = whyDetectFail;
	}
	public String getWhyPreventFail() {
		return whyPreventFail;
	}
	public void setWhyPreventFail(String whyPreventFail) {
		this.whyPreventFail = whyPreventFail;
	}
	public String getFailCause() {
		return failCause;
	}
	public void setFailCause(String failCause) {
		this.failCause = failCause;
	}
	public String getDetectCause() {
		return detectCause;
	}
	public void setDetectCause(String detectCause) {
		this.detectCause = detectCause;
	}
	public String getPreventCause() {
		return preventCause;
	}
	public void setPreventCause(String preventCause) {
		this.preventCause = preventCause;
	}
    
}
