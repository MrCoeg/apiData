package com.example.demo.models.lecturer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LecturerRepository
        extends JpaRepository<Lecturer, Long> {

    Optional<Lecturer> findLecturerByEmail(String email);
}
