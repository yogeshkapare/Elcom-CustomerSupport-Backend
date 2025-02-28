package com.eipl.customersupport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eipl.customersupport.models.ComplaintRegistrationAttachments;
import com.eipl.customersupport.repository.ComplaintRegistrationAttachmentsRepository;

@RestController
@RequestMapping("/api/complaintsregAttachments")
public class ComplaintRegistrationAttachmentsController {
	
	@Autowired
	private ComplaintRegistrationAttachmentsRepository complaintRegistrationAttachmentsRepository;

    @GetMapping("/{complaintid}")
    public List<ComplaintRegistrationAttachments> getComplaintAttchaments(@PathVariable Long complaintid) {
    	System.out.println("Hello "+complaintid);
        return complaintRegistrationAttachmentsRepository.findByComplaintid(complaintid);
    }
}
