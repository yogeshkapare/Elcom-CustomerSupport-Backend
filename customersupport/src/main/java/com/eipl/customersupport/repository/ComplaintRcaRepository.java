package com.eipl.customersupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eipl.customersupport.models.ComplaintRca;

public interface ComplaintRcaRepository  extends JpaRepository<ComplaintRca, Long>{

	List<ComplaintRca> findByComplaintid(Long complaintid);
	
}
