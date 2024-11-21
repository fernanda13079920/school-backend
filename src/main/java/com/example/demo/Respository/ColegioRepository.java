package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Colegio;

@Repository
@EnableJpaRepositories
public interface ColegioRepository extends JpaRepository<Colegio, Integer> {

}
