package com.eipl.customersupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eipl.customersupport.models.ComplaintCapa;

public interface ComplaintCapaRepository extends JpaRepository<ComplaintCapa, Long>{

	List<ComplaintCapa> findByComplaintid(Long complaintid);
	List<ComplaintCapa> findByActiontype(String actiontype);
	List<ComplaintCapa> findByComplaintidAndActiontype(Long complaintId, String actionType);
	
}
