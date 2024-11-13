package com.daza.m6_sistemacalificacionesevfinal.service.subject;

import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectService {
    Page<SubjectDto> findAllSubjects(Pageable pageable);
    SubjectDto createSubject(SubjectCreateDto subjectCreateDto);
    SubjectDto updateSubject(Long id, SubjectCreateDto subjectCreateDto);
    void deleteSubject(Long id);
}
