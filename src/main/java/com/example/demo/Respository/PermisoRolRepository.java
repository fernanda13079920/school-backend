package com.example.demo.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.PermisoRol;


@Repository
@EnableJpaRepositories
public interface PermisoRolRepository extends JpaRepository<PermisoRol, Long> {
        List<PermisoRol> findByRolId(Long id);

        @Modifying
    @Query("DELETE FROM PermisoRol pr WHERE pr.rol.id = :rolId")
    void deleteByRolId(@Param("rolId") Long rolId);
}
