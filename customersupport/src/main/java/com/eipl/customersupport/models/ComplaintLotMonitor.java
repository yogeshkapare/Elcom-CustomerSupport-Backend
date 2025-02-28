package com.eipl.customersupport.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ComplaintLotMonitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lotd;
    private Long complaintid;
    private String invoiceNo;
    private Date invoiceDate;
    private int qtySupplied;
    private int qtyRejectedReworked;
    private int defectPpm;
    private String remark;
    
	public Long getLotd() {
		return lotd;
	}
	public void setLotd(Long lotd) {
		this.lotd = lotd;
	}
	public Long getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(Long complaintid) {
		this.complaintid = complaintid;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public int getQtySupplied() {
		return qtySupplied;
	}
	public void setQtySupplied(int qtySupplied) {
		this.qtySupplied = qtySupplied;
	}
	public int getQtyRejectedReworked() {
		return qtyRejectedReworked;
	}
	public void setQtyRejectedReworked(int qtyRejectedReworked) {
		this.qtyRejectedReworked = qtyRejectedReworked;
	}
	public int getDefectPpm() {
		return defectPpm;
	}
	public void setDefectPpm(int defectPpm) {
		this.defectPpm = defectPpm;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    
}
