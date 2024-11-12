package com.daza.m6_sistemacalificacionesevfinal.service.subject;

import com.daza.m6_sistemacalificacionesevfinal.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

}

