package com.example.demo.models.subject;

import com.example.demo.models.lecturer.Lecturer;
import com.example.demo.models.scholar.Scholar;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Subject {
    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
    @Column(name = "subject_id")
    private Long id;
    private String name;


    @ManyToMany(mappedBy = "lecturerSubjectList")
    private List<Lecturer> lecturerList;

    @ManyToMany(mappedBy = "scholarSubjectList")
    private List<Scholar> studentList;



    public Subject(){

    }

    public Subject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subject(String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lecturer> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(List<Lecturer> lecturerList) {
        this.lecturerList = lecturerList;
    }

    public List<Scholar> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Scholar> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lecturerList=" + lecturerList +
                ", studentList=" + studentList +
                '}';
    }
}
