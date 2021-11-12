package com.example.demo.models.lecturer;


import com.example.demo.models.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping(path = "api/lecturer")
public class LecturerController {

    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping
    public List<Lecturer> getAllLecturer(){
        return lecturerService.getAllLecturer();
    }

    @GetMapping("{id}")
    public Lecturer getLecturer(@PathVariable Long id){
        return lecturerService.getLecturerById(id);
    }

    @PostMapping
    public void addNewLecturer(@RequestBody Lecturer lecturer){
        lecturerService.addNewLecturer(lecturer);
    }

    @PostMapping("/enrollment/{subjectId}/{lecturerId}")
    public void addLecturerToSubject(@PathVariable Long subjectId,
                                    @PathVariable Long lecturerId){
        lecturerService.enrollToSubject(subjectId, lecturerId);
    }
    @DeleteMapping("{id}")
    public void deleteLecturerById(@PathVariable Long id){
        Lecturer lecturer = lecturerService.getLecturerById(id);
        List<Subject> subjects = lecturer.getLecturerSubjectList();

        for(int i = 0; i < subjects.size(); i++){

        }
        lecturerService.deleteLecturer(id);
    }

    @PutMapping("{id}")
    public void updateLecturerById(@PathVariable Long id,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String email){
        lecturerService.updateLecturerById(id, name, email);
    }




}
