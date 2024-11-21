package com.example.demo.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.PersonaIdioma;
import com.example.demo.Serializable.PersonaIdiomaId;

import jakarta.transaction.Transactional;

@Repository
@EnableJpaRepositories
public interface PersonaIdiomaRepository extends JpaRepository<PersonaIdioma, PersonaIdiomaId> {
    List<PersonaIdioma> findByIdIdPersonal(Integer idPersonal);
    List<PersonaIdioma> findByIdIdIdioma(Long idIdioma);

    @Modifying
    @Transactional
    @Query("DELETE FROM PersonaIdioma pi WHERE pi.personal.carnet = :carnet")
    void deleteByPersonalCarnet(Integer carnet);
}   
