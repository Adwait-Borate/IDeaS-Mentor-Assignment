package com.example.IDeaS.repository;

import com.example.IDeaS.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {
}
