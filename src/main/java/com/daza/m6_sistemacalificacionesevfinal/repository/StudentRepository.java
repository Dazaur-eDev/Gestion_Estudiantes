package com.daza.m6_sistemacalificacionesevfinal.repository;

import com.daza.m6_sistemacalificacionesevfinal.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Student> findByRutContains(String rut, Pageable pageable);
    Boolean existsByRut(String rut);
}

