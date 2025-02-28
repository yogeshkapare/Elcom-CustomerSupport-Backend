package com.eipl.customersupport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eipl.customersupport.models.ComplaintCapa;
import com.eipl.customersupport.repository.ComplaintCapaRepository;

@RestController
@RequestMapping("/api/complaintscapa")
public class ComplaintCapaController {

	@Autowired
	private ComplaintCapaRepository complaintCapaRepository;
	
    @PostMapping("/addComplaintCapa")
    public ComplaintCapa registerComplaintCapa(@RequestBody ComplaintCapa complaintCapa) {
        return complaintCapaRepository.save(complaintCapa);
    }
    
    
    @GetMapping("/{id}")
    public List<ComplaintCapa> getComplaintCapaById(@PathVariable Long id) {
        return complaintCapaRepository.findByComplaintid(id);
    }

    @GetMapping("actionType/{actionType}")
    public List<ComplaintCapa> getComplaintCapaByActionType(@PathVariable String actionType) {
        return complaintCapaRepository.findByActiontype(actionType);
    }
    
    @GetMapping("complaint/{complaintId}/actionType/{actionType}")
    public List<ComplaintCapa> getComplaintCapaByActionTypeAndComplaintId(@PathVariable Long complaintId, @PathVariable String actionType) {
        return complaintCapaRepository.findByComplaintidAndActiontype(complaintId,actionType);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<ComplaintCapa> updateComplaintCapa(
            @PathVariable Long id, 
            @RequestBody ComplaintCapa complaintCapa) {
        
        // Fetch existing complaint from repository
        ComplaintCapa existingComplaint = complaintCapaRepository.findById(id)
                .orElseThrow();

        // Update fields
        existingComplaint.setComplaintid(complaintCapa.getComplaintid()); // Set appropriate fields
        existingComplaint.setActiontype(complaintCapa.getActiontype()); // Set appropriate fields
        existingComplaint.setAction(complaintCapa.getAction()); // Set appropriate fields
        existingComplaint.setResponsibility(complaintCapa.getResponsibility()); // Set appropriate fields
        existingComplaint.setRemark(complaintCapa.getRemark()); // Set appropriate fields
        existingComplaint.setTargetdate(complaintCapa.getTargetdate()); // Set appropriate fields
        existingComplaint.setActionstatus(complaintCapa.getActionstatus()); // Set appropriate fields
        existingComplaint.setActualDateOfCompletion(complaintCapa.getActualDateOfCompletion()); // Set appropriate fields

        // Save the updated entity
        ComplaintCapa updatedComplaint = complaintCapaRepository.save(existingComplaint);

        return ResponseEntity.ok(updatedComplaint);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComplaintCapa(@PathVariable Long id) {
        try {
        	complaintCapaRepository.deleteById(id);
            return ResponseEntity.ok("Complaint capa deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage()); // Return 404 if not found
        }
    }

}

