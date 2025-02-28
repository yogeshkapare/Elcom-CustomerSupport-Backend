package com.eipl.customersupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eipl.customersupport.models.ComplaintRegistrationAttachments;

public interface ComplaintRegistrationAttachmentsRepository extends JpaRepository<ComplaintRegistrationAttachments, Long> {

	List<ComplaintRegistrationAttachments> findByComplaintid(Long complaintId);
}
