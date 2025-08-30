package com.jawwal.iws.jawwalIWS.repository;

import com.jawwal.iws.jawwalIWS.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
