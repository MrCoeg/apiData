package com.example.demo.models.scholar;

import com.example.demo.models.subject.Subject;
import com.example.demo.models.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ScholarService {

    private final ScholarRepository scholarRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public ScholarService(ScholarRepository scholarRepository, SubjectRepository subjectRepository) {
        this.scholarRepository = scholarRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Scholar> getScholar(){
        return scholarRepository.findAll();
    }

    public Scholar getScholarById(Long id){
        Scholar scholar = scholarRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Scholar with " + id + "is not exist"
                ));
        return scholar;
    }

    public void addNewScholar(Scholar scholar) {
        Optional<Scholar> studentOptional =
                scholarRepository.findScholarByEmail(scholar.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email has taken");
        }
        scholarRepository.save(scholar);
    }

    public void deleteScholarById(Long id){
        boolean isStudentExist = scholarRepository.existsById(id);
        if(!isStudentExist){
            throw new IllegalStateException(
                    "Student with id " + id + " is not exist"
            );
        }else{
            scholarRepository.deleteById(id);
        }

    }

    @Transactional
    public void updateScholarById(Long id, String name, String email) {
        Scholar scholar = scholarRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + id + " is not exist"
                ));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(scholar.getName(), name)){
            scholar.setName(name);
        }

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(scholar.getEmail(), email)){
            Optional<Scholar> studentOptional =
                    scholarRepository.findScholarByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email has taken");
            }
            scholar.setEmail(email);
        }
    }

    @Transactional
    public void enrollToSubject(Long scholarId, Long subjectId){
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalStateException(
                        "Subject with " + subjectId + " is not exist"
                ));
        Scholar scholar = scholarRepository.findById(scholarId)
                .orElseThrow(() -> new IllegalStateException(
                        "Scholar with " + scholarId + " is not exist"
                ));
        scholar.getScholarSubjectList().add(subject);
    }
}
