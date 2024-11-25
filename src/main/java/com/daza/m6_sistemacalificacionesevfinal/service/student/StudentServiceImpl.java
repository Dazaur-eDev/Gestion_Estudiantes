package com.daza.m6_sistemacalificacionesevfinal.service.student;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.*;
import com.daza.m6_sistemacalificacionesevfinal.exception.PSQLException;
import com.daza.m6_sistemacalificacionesevfinal.exception.StudentNotFoundException;
import com.daza.m6_sistemacalificacionesevfinal.mapper.StudentMapper;
import com.daza.m6_sistemacalificacionesevfinal.mapper.SubjectMapper;
import com.daza.m6_sistemacalificacionesevfinal.model.Student;
import com.daza.m6_sistemacalificacionesevfinal.repository.StudentRepository;
import com.daza.m6_sistemacalificacionesevfinal.repository.SubjectRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final StudentMapper studentMapper;
    private final SubjectMapper subjectMapper;

    public StudentServiceImpl(StudentRepository studentRepository, SubjectRepository subjectRepository, StudentMapper studentMapper, SubjectMapper subjectMapper) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.studentMapper = studentMapper;
        this.subjectMapper = subjectMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StudentDto> findAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toDto);
    }

    @Override
    public StudentDto createStudent(StudentCreateDto studentCreateDto) {
        Student studentToAdd = studentMapper.toEntity(studentCreateDto);
        Student studentSaved;
        try {
            studentSaved = studentRepository.save(studentToAdd);
        } catch (DataIntegrityViolationException e) {
            throw new PSQLException("Rut already exist: " + studentCreateDto.getRut());
        }
        return studentMapper.toDto(studentSaved);
    }

    @Override
    public StudentDtoSm updateStudent(Long id, StudentDtoSm studentDtoSm) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));

        if (studentDtoSm.getName() != null) {
            student.setName(studentDtoSm.getName());
        }
        if (studentDtoSm.getDirection() != null) {
            student.setDirection(studentDtoSm.getDirection());
        }
        if (studentDtoSm.getEmail() != null) {
            student.setEmail(studentDtoSm.getEmail());
        }

        Student studentSaved = studentRepository.save(student);
        return studentMapper.toDtoSm(studentSaved);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentUpdateDto studentUpdateDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));

        if (studentUpdateDto.getRut() != null) {
            student.setRut(studentUpdateDto.getRut());
        }

        if (studentUpdateDto.getName() != null) {
            student.setName(studentUpdateDto.getName());
        }
        if (studentUpdateDto.getDirection() != null) {
            student.setDirection(studentUpdateDto.getDirection());
        }
        if (studentUpdateDto.getEmail() != null) {
            student.setEmail(studentUpdateDto.getEmail());
        }
        if (studentUpdateDto.getSubjects() != null) {
            student.setListOfSubjects(studentUpdateDto.getSubjects().stream()
                    .map(subjectMapper::toEntity)
                    .collect(Collectors.toSet()));
        }

        Student studentSaved = studentRepository.save(student);
        System.out.println(studentSaved.getListOfSubjects());
        return studentMapper.toDto(studentSaved);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
        studentRepository.delete(student);
    }

    @Override
    public Page<StudentDto> findStudentByName(String name, Pageable pageable) {
        Page<Student> byNameContainingIgnoreCase = studentRepository.findByNameContainingIgnoreCase(name, PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))));
        return byNameContainingIgnoreCase.map(studentMapper::toDto);
    }

    @Override
    public Page<StudentDto> findStudentByRut(String rut, Pageable pageable) {
        return studentRepository.findByRutContains(rut, pageable).map(studentMapper::toDto);
    }

    @Override
    public Page<StudentDtoSm> findAllStudentsSm(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toDtoSm);
    }

    @Override
    public StudentDto searchStudentId(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
        return studentMapper.toDto(student);
    }

    @Override
    public StudentUpdateDto searchStudentIdForUpdate(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
        return studentMapper.toDtoUpd(student);
    }
}

