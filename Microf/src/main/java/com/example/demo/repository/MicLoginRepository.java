package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MicLogin;

public interface MicLoginRepository extends JpaRepository<MicLogin, Long> {

}
