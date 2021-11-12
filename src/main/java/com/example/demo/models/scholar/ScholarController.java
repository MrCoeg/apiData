package com.example.demo.models.scholar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping(path= "api/scholar")
public class ScholarController {

    private final ScholarService scholarService;

    @Autowired
    public ScholarController(ScholarService scholarService) {
        this.scholarService = scholarService;
    }

    @GetMapping
    public List<Scholar> getAllScholars(){
        return scholarService.getScholar();
    }

    @GetMapping("{id}")
    public Scholar getScholarById(@PathVariable("id") Long id){
        return scholarService.getScholarById(id);
    }

    @PostMapping
    public void registerNewScholar(@RequestBody Scholar scholar){
        scholarService.addNewScholar(scholar);
    }

    @PostMapping("/enrollment/{subjectId}/{scholarId}")
    public void addScholarToSubject(@PathVariable Long subjectId,
                                    @PathVariable Long scholarId){
        scholarService.enrollToSubject(subjectId, scholarId);
    }

    @DeleteMapping("{id}")
    public void deleteScholar(@PathVariable("id") Long id){
        scholarService.deleteScholarById(id);
    }

    @PutMapping("{id}")
    public void updateScholar(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
            ){
        scholarService.updateScholarById(id, name, email);
    }

}
