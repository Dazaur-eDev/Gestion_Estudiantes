package com.daza.m6_sistemacalificacionesevfinal.repository;

import com.daza.m6_sistemacalificacionesevfinal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
