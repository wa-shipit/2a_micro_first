package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Miclogin;

public interface MicloginRepository extends JpaRepository<Miclogin, Integer> {

}