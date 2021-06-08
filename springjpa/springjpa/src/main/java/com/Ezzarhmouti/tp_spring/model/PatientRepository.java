package com.Ezzarhmouti.tp_spring.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    public List<Patient> findByMalade(boolean b);
    public List<Patient> findByNomContainsAndMalade(String name, boolean b);
    public Page<Patient> findByNomContains(String name, Pageable pageable);


}
