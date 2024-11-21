package com.example.demo.Respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Aula;


@Repository
@EnableJpaRepositories
public interface AulaRepository extends JpaRepository<Aula,Long> {
    boolean existsByNombre(String name);

}
