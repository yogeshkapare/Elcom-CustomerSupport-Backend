package com.eipl.customersupport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eipl.customersupport.models.ComplaintCa;
import com.eipl.customersupport.models.ComplaintRca;
import com.eipl.customersupport.repository.ComplaintRcaRepository;

@RestController
@RequestMapping("/api/complaintsrca")
public class ComplaintRcaController {

	@Autowired
	private ComplaintRcaRepository complaintRcaRepository;
	
    @PostMapping("/addComplaintRca")
    public ComplaintRca registerComplaintCa(@RequestBody ComplaintRca complaintRca) {
        return complaintRcaRepository.save(complaintRca);
    }
    
    @GetMapping("/{id}")
    public List<ComplaintRca> getComplaintRcaById(@PathVariable Long id) {
        return complaintRcaRepository.findByComplaintid(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComplaintRca(@PathVariable Long id) {
        try {
        	complaintRcaRepository.deleteById(id);
            return ResponseEntity.ok("RCA deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage()); // Return 404 if not found
        }
    }
    
}
