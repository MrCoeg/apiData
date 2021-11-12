package com.example.demo.models.scholar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScholarRepository
        extends JpaRepository<Scholar, Long> {

    Optional<Scholar> findScholarByEmail(String email);
}
