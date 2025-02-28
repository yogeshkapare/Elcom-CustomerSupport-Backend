package com.eipl.customersupport.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eipl.customersupport.models.ComplaintRegistration;
import com.eipl.customersupport.service.ComplaintregReportService;
import com.eipl.customersupport.service.ComplaintregService;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;
import jakarta.servlet.http.HttpServletResponse;

//@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/api/complaintsreg")
public class ComplaintregController {

    @Autowired
    private ComplaintregService complaintregService;

    @Autowired
    private ComplaintregReportService complaintregReportService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ComplaintRegistration> getComplaintById(@PathVariable Long id) {
        return complaintregService.getComplaintById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // Register a new complaint
    @PostMapping("/addComplaintreg")
    public ComplaintRegistration registerComplaint(@RequestBody ComplaintRegistration complaintreg) {
        return complaintregService.registerComplaint(complaintreg);
    }
    
    @GetMapping("/open")
    public List<ComplaintRegistration> getOpenComplaints() {
        return complaintregService.getOpenComplaints();
    }
    
    @GetMapping("/new")
    public List<ComplaintRegistration> getNewComplaints() {
        return complaintregService.getNewComplaints();
    }
    
    @GetMapping("/inprogress")
    public List<ComplaintRegistration> getInprogressComplaints() {
        return complaintregService.getInprogressComplaints();
    }
    
    @GetMapping("/acknowledge")
    public List<ComplaintRegistration> getAckComplaints() {
        return complaintregService.getAckComplaints();
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<ComplaintRegistration> updateComplaintStatus(
            @PathVariable Long id, 
            @RequestParam String status) {
        
        ComplaintRegistration updatedComplaint = complaintregService.updateComplaintStatus(id, status);
        return ResponseEntity.ok(updatedComplaint);
    }
    
    // Update existing complaint details
    @PutMapping("/update/{id}")
    public ResponseEntity<ComplaintRegistration> updateComplaint(
            @PathVariable Long id, 
            @RequestBody ComplaintRegistration complaintDetails) {
        ComplaintRegistration updatedComplaint = complaintregService.updateComplaint(id, complaintDetails);
        return ResponseEntity.ok(updatedComplaint);
    }
    

    @GetMapping("/generateReport/{complaintId}")
    public void generateReport(HttpServletResponse response,@PathVariable Long complaintId) {
        try {
        	complaintregReportService.generateReport(response,complaintId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
