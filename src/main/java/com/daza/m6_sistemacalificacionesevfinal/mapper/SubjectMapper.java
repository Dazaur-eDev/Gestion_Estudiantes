package com.daza.m6_sistemacalificacionesevfinal.mapper;

import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectDto;
import com.daza.m6_sistemacalificacionesevfinal.model.Subject;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    private final StudentMapper studentMapper;

    public SubjectMapper(@Lazy StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public SubjectDto toDto(Subject subject) {
        if (subject == null) {
            return null;
        }
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        return subjectDto;
    }

    public Subject toEntity(SubjectCreateDto subjectCreateDto) {
        if (subjectCreateDto == null) {
            return null;
        }
        Subject subject = new Subject();
        subject.setName(subjectCreateDto.getName());
        return subject;
    }
}
