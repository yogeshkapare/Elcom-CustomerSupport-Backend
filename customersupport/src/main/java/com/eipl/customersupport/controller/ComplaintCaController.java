package com.eipl.customersupport.controller;

import java.util.List;
import java.util.Optional;

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

import com.eipl.customersupport.models.ComplaintCa;
import com.eipl.customersupport.repository.ComplaintCaRepository;

@RestController
@RequestMapping("/api/complaintsca")
public class ComplaintCaController {

	@Autowired
	private ComplaintCaRepository complaintCaRepository;
	
    @PostMapping("/addComplaintCa")
    public ComplaintCa registerComplaintCa(@RequestBody ComplaintCa complaintCa) {
        return complaintCaRepository.save(complaintCa);
    }
    
    
    @GetMapping("/{id}")
    public List<ComplaintCa> getComplaintCaById(@PathVariable Long id) {
        return complaintCaRepository.findByComplaintid(id);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<ComplaintCa> updateComplaintCa(
            @PathVariable Long id, 
            @RequestBody ComplaintCa complaintCa) {
        
        // Fetch existing complaint from repository
        ComplaintCa existingComplaint = complaintCaRepository.findById(id)
                .orElseThrow();

        // Update fields
        existingComplaint.setComplaintid(complaintCa.getComplaintid()); // Set appropriate fields
        existingComplaint.setStocklocation(complaintCa.getStocklocation()); // Set appropriate fields
        existingComplaint.setOkqty(complaintCa.getOkqty()); // Set appropriate fields
        existingComplaint.setNotokqty(complaintCa.getNotokqty()); // Set appropriate fields
        existingComplaint.setRemark(complaintCa.getRemark()); // Set appropriate fields

        // Save the updated entity
        ComplaintCa updatedComplaint = complaintCaRepository.save(existingComplaint);

        return ResponseEntity.ok(updatedComplaint);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComplaint(@PathVariable Long id) {
        try {
        	complaintCaRepository.deleteById(id);
            return ResponseEntity.ok("Complaint deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage()); // Return 404 if not found
        }
    }

}
