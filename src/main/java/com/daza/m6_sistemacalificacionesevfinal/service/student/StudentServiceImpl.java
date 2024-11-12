package com.daza.m6_sistemacalificacionesevfinal.service.student;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectDto;
import com.daza.m6_sistemacalificacionesevfinal.exception.StudentNotFoundException;
import com.daza.m6_sistemacalificacionesevfinal.mapper.StudentMapper;
import com.daza.m6_sistemacalificacionesevfinal.mapper.SubjectMapper;
import com.daza.m6_sistemacalificacionesevfinal.model.Student;
import com.daza.m6_sistemacalificacionesevfinal.model.Subject;
import com.daza.m6_sistemacalificacionesevfinal.repository.StudentRepository;
import com.daza.m6_sistemacalificacionesevfinal.repository.SubjectRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
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
    public Page<StudentDto> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDto findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDto createStudent(StudentCreateDto studentCreateDto) {
        Student studentToAdd = studentMapper.toEntity(studentCreateDto);
        Student studentSaved = studentRepository.save(studentToAdd);
        return studentMapper.toDto(studentSaved);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentCreateDto studentCreateDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not founded"));

        if (studentCreateDto.getRut() != null) {
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
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not founded"));
        studentRepository.delete(student);
    }
}

