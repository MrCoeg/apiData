package com.example.demo.models.lecturer;

import com.example.demo.models.subject.Subject;
import com.example.demo.models.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LecturerService {

    private final LecturerRepository lecturerRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public LecturerService(LecturerRepository lecturerRepository, SubjectRepository subjectRepository) {
        this.lecturerRepository = lecturerRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Lecturer> getAllLecturer(){
        return lecturerRepository.findAll();
    }

    public void addNewLecturer(Lecturer lecturer){
        Optional<Lecturer> lecturerOptional =
                lecturerRepository.findLecturerByEmail(lecturer.getEmail());
        if(lecturerOptional.isPresent()){
            throw new IllegalStateException("email has taken");
        }
        lecturerRepository.save(lecturer);
    }

    public void deleteLecturer(Long id){

        boolean isLecturerExist = lecturerRepository.existsById(id);

        if(!isLecturerExist){
            throw new IllegalStateException("Lecturer not exist");
        }

        lecturerRepository.deleteById(id);

    }

    public Lecturer getLecturerById(Long id){
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                "Lecturer with id " + id + " is not exist"
        ));

        return lecturer;
    }

    @Transactional
    public void updateLecturerById(Long id, String name, String email){
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Lecturer with id " + id + " is not exist"
                ));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(lecturer.getName(), name)){
            lecturer.setName(name);
        }

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(email, lecturer.getEmail())){
            Optional<Lecturer> lecturerOptional = lecturerRepository.findLecturerByEmail(email);

            if(lecturerOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }else{
                lecturer.setEmail(email);
            }
        }
    }

    @Transactional
    public void enrollToSubject(Long lecturerId, Long subjectId){
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalStateException(
                        "Subject with " + subjectId + " is not exist"
                ));
        Lecturer lecturer = lecturerRepository.findById(lecturerId)
                .orElseThrow(() -> new IllegalStateException(
                        "Lecturer with " + lecturerId + " is not exist"
                ));
        lecturer.getLecturerSubjectList().add(subject);
    }
}
