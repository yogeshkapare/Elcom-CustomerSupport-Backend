package com.eipl.customersupport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eipl.customersupport.models.ComplaintRegistration;
import com.eipl.customersupport.repository.CusotmerregRepository;

@Service
public class ComplaintregService {
    @Autowired
    private CusotmerregRepository cusotmerregRepository;

    public ComplaintRegistration registerComplaint(ComplaintRegistration complaintreg) {
        return cusotmerregRepository.save(complaintreg);
    }
    
    public Optional<ComplaintRegistration> getComplaintById(Long id) {
        return cusotmerregRepository.findById(id);
    }

    public List<ComplaintRegistration> getOpenComplaints() {
        return cusotmerregRepository.findByComplaintstatusNotOrderByComplaintid("Closed");
    }
    
    public List<ComplaintRegistration> getNewComplaints() {
        return cusotmerregRepository.findByComplaintstatus("New");
    }
    
    public List<ComplaintRegistration> getInprogressComplaints() {
        return cusotmerregRepository.findByComplaintstatus("InProgress");
    }
    
    public List<ComplaintRegistration> getAckComplaints() {
        return cusotmerregRepository.findByComplaintstatus("Acknowledged");
    }
    
    public List<ComplaintRegistration> getAllComplaints() {
        return cusotmerregRepository.findAll();
    }

    public ComplaintRegistration updateComplaintStatus(Long id, String status) {
    	ComplaintRegistration complaint = cusotmerregRepository.findById(id).orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setComplaintstatus(status);
        return cusotmerregRepository.save(complaint);
    }
    
    public ComplaintRegistration updateComplaint(Long id, ComplaintRegistration complaintDetails) {
        System.out.println("Updating Complaint: " + complaintDetails.getComplainttype());
        System.out.println("Updating Complaint: " + complaintDetails.getComplaintstatus());

        Optional<ComplaintRegistration> optionalComplaint = cusotmerregRepository.findById(id);
        
        if (optionalComplaint.isPresent()) {
            ComplaintRegistration existingComplaint = optionalComplaint.get();
            
            // Update fields with new data
            existingComplaint.setProductBatchSerialNumber(complaintDetails.getProductBatchSerialNumber());
            existingComplaint.setComplainttype(complaintDetails.getComplainttype());
            existingComplaint.setActualobservation(complaintDetails.getActualobservation());
            existingComplaint.setDefectiveSampleQty(complaintDetails.getDefectiveSampleQty());
            existingComplaint.setDefectivesamplerecdon(complaintDetails.getDefectivesamplerecdon());
            existingComplaint.setAdvanceReplacementGivenOn(complaintDetails.getAdvanceReplacementGivenOn());
            existingComplaint.setAdvanceReplacementNote(complaintDetails.getAdvanceReplacementNote());
            existingComplaint.setComplaintstatus(complaintDetails.getComplaintstatus());
            //existingComplaint.setComplaintstatus("InProgress");
            
            // Save updated entity
            return cusotmerregRepository.save(existingComplaint);
        } else {
            throw new RuntimeException("Complaint not found with id " + id);
        }
    }
}
