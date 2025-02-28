package com.eipl.customersupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eipl.customersupport.models.ComplaintCa;

public interface ComplaintCaRepository extends JpaRepository<ComplaintCa, Long> {

	List<ComplaintCa> findByComplaintid(Long complaintid);
	
}
