package com.jawwal.iws.jawwalIWS.repository;

import com.jawwal.iws.jawwalIWS.entities.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {}
