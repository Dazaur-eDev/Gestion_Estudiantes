package com.daza.m6_sistemacalificacionesevfinal.service.student;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDtoSm;
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
    public StudentDto updateStudent(Long id, StudentCreateDto studentCreateDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));

        Boolean rutExist = studentRepository.existsByRut(studentCreateDto.getRut());
        if (rutExist){
            throw new PSQLException("Rut already exist: " + studentCreateDto.getRut());
        }

        if (studentCreateDto.getRut() != null){
            student.setRut(studentCreateDto.getRut());
        }
        if (studentCreateDto.getName() != null) {
            student.setName(studentCreateDto.getName());
        }
        if (studentCreateDto.getDirection() != null) {
            student.setDirection(studentCreateDto.getDirection());
        }
        if (studentCreateDto.getEmail() != null) {
            student.setEmail(studentCreateDto.getEmail());
        }

        Student studentSaved = studentRepository.save(student);
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
        return null;
    }

    @Override
    public Page<StudentDtoSm> findAllStudentsSm(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toDtoSm);
    }


}

