package com.daza.m6_sistemacalificacionesevfinal.service.subject;

import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectCreateDto;

import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectDto;

import com.daza.m6_sistemacalificacionesevfinal.exception.PSQLException;
import com.daza.m6_sistemacalificacionesevfinal.exception.SubjectNotFoundException;
import com.daza.m6_sistemacalificacionesevfinal.mapper.StudentMapper;
import com.daza.m6_sistemacalificacionesevfinal.mapper.SubjectMapper;
import com.daza.m6_sistemacalificacionesevfinal.model.Subject;
import com.daza.m6_sistemacalificacionesevfinal.repository.StudentRepository;
import com.daza.m6_sistemacalificacionesevfinal.repository.SubjectRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final StudentMapper studentMapper;
    private final SubjectMapper subjectMapper;

    public SubjectServiceImpl(StudentRepository studentRepository, SubjectRepository subjectRepository, StudentMapper studentMapper, SubjectMapper subjectMapper) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.studentMapper = studentMapper;
        this.subjectMapper = subjectMapper;
    }


    @Override
    public Page<SubjectDto> findAllSubjects(Pageable pageable) {
        return subjectRepository.findAll(pageable)
                .map(subjectMapper::toDto);
    }

    @Override
    public SubjectDto createSubject(SubjectCreateDto subjectCreateDto) {
        Subject subjectToAdd = subjectMapper.toEntity(subjectCreateDto);
        Subject subjectSaved;
        try {
            subjectSaved = subjectRepository.save(subjectToAdd);
        } catch (DataIntegrityViolationException e) {
            throw new PSQLException("La asignatura ya existe: " + subjectCreateDto.getName());
        }
        return subjectMapper.toDto(subjectSaved);
    }

    @Override
    public SubjectDto updateSubject(Long id, SubjectCreateDto subjectCreateDto) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new SubjectNotFoundException("Subject with id " + id + " not found"));
        Subject subjectSaved;
        if (subjectCreateDto.getName() != null) {
            subject.setName(subjectCreateDto.getName());
        }
        try {
            subjectSaved = subjectRepository.save(subject);
        } catch (DataIntegrityViolationException e) {
            throw new PSQLException("La asignatura ya existe: " + subjectCreateDto.getName());
        }
        return subjectMapper.toDto(subjectSaved);
    }

    @Override
    public void deleteSubject(Long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new SubjectNotFoundException("Subject with id " + id + " not found"));
        subjectRepository.delete(subject);
    }
}

