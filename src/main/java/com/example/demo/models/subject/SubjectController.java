package com.example.demo.models.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping(path = "api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubject();
    }

    @GetMapping("{id}")
    public Subject getSubjectById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public void addNewSubject(@RequestBody Subject subject){
        subjectService.addNewSubject(subject);
    }

    @DeleteMapping("{id}")
    public void deleteSubject(@PathVariable Long id){
        subjectService.deleteSubjectById(id);
    }

    @PutMapping("{id}")
    public void updateSubjectById(@PathVariable Long id,
                                  @RequestParam String name){
        subjectService.UpdateSubjectById(id, name);
    }
}
