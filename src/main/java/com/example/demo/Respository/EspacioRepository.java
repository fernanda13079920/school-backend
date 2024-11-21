package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Espacio;

@Repository
@EnableJpaRepositories
public interface EspacioRepository extends JpaRepository<Espacio, Long> {

}
