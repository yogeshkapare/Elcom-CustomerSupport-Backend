package com.eipl.customersupport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eipl.customersupport.models.ComplaintLotMonitor;
import com.eipl.customersupport.models.ComplaintRca;

public interface ComplaintLotMonitorRepository extends JpaRepository<ComplaintLotMonitor, Long>{

	List<ComplaintLotMonitor> findByLotd(Long id);
}
