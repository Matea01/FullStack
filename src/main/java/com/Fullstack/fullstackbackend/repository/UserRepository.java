package com.Fullstack.fullstackbackend.repository;

import com.Fullstack.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long>{
}
