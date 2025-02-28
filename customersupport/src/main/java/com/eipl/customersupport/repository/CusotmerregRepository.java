package com.eipl.customersupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eipl.customersupport.models.ComplaintRegistration;


public interface CusotmerregRepository extends JpaRepository<ComplaintRegistration, Long> {

    //@Query("SELECT c FROM ComplaintRegistration c WHERE c.complaintstatus <> :status")
    //List<ComplaintRegistration> findByStatusNot(@Param("status") String status);
    
	List<ComplaintRegistration> findByComplaintstatusNotOrderByComplaintid(String status);
	List<ComplaintRegistration> findByComplaintstatus(String status);
	List<ComplaintRegistration> findByComplaintid(Long complaintid);
}
