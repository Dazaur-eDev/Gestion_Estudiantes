package com.daza.m6_sistemacalificacionesevfinal.repository;

import com.daza.m6_sistemacalificacionesevfinal.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByName(String name);
    Page<Subject> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
