package com.jawwal.iws.jawwalIWS.repository;

import com.jawwal.iws.jawwalIWS.entities.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {}