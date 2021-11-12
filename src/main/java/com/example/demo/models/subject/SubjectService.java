package com.example.demo.models.subject;

import com.example.demo.models.lecturer.LecturerRepository;
import com.example.demo.models.scholar.ScholarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ScholarRepository scholarRepository;
    private final LecturerRepository lecturerRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, ScholarRepository scholarRepository, LecturerRepository lecturerRepository) {
        this.subjectRepository = subjectRepository;
        this.scholarRepository = scholarRepository;
        this.lecturerRepository = lecturerRepository;
    }

    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id){
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Subject with " + id + "is not exist"
                ));
        return subject;
    }

    public void addNewSubject(Subject subject){
        subjectRepository.save(subject);
    }

    public void deleteSubjectById(Long id){
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Subject with " + id + "is not exist"
                ));
        subjectRepository.deleteById(id);
    }

    @Transactional
    public void UpdateSubjectById(Long id, String name){
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Subject with " + id + "is not exist"
                ));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(name, subject.getName())){
            subject.setName(name);
        }
    }




}
