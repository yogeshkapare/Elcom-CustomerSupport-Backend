package com.eipl.customersupport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eipl.customersupport.models.ComplaintLotMonitor;
import com.eipl.customersupport.repository.ComplaintLotMonitorRepository;

@RestController
@RequestMapping("/api/complaintLotMonitor")
public class ComplaintLotMonitorController {

	@Autowired
	private ComplaintLotMonitorRepository complaintLotMonitorRepository;
	
    @PostMapping("/addComplaintLotMonitor")
    public ComplaintLotMonitor registerComplaintCa(@RequestBody ComplaintLotMonitor complaintLotMonitor) {
        return complaintLotMonitorRepository.save(complaintLotMonitor);
    }
    
    @GetMapping("/{id}")
    public List<ComplaintLotMonitor> getComplaintLotMonitorById(@PathVariable Long id) {
        return complaintLotMonitorRepository.findByLotd(id);
    }
    
}
