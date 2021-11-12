package com.example.demo;

import com.example.demo.models.lecturer.Lecturer;
import com.example.demo.models.lecturer.LecturerRepository;
import com.example.demo.models.scholar.Scholar;
import com.example.demo.models.scholar.ScholarRepository;
import com.example.demo.models.subject.Subject;
import com.example.demo.models.subject.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Config {

    @Bean
    CommandLineRunner studentCommandLineRunner(
            ScholarRepository scholarRepository,
            LecturerRepository lecturerRepository,
            SubjectRepository subjectRepository){
        return args -> {
            Scholar tegar = new Scholar(
                    "Tegar Cahya Bayu Siregar",
                    "tegarcahyabayu150502@gmail.com",
                    LocalDate.of(2002, Month.MAY, 15)
            );
            Scholar fahryan = new Scholar(
                    "Ahmad Fahryan Pasaribu",
                    "ahmadfahryanpasaribu@gmail.com",
                    LocalDate.of(2002, Month.FEBRUARY, 5)
            );

            Lecturer osvari = new Lecturer(
                    "Osvari Arsalan",
                    "osvaroarsalan@gmail.com",
                    LocalDate.of(1990, Month.JANUARY, 10)
            );

            Lecturer ali = new Lecturer(
                    "Ali Buchori",
                    "alibuchori@gmail.com",
                    LocalDate.of(1992, Month.MARCH, 1)
            );

            Subject backend = new Subject(
                    "Backend"
            );

            Subject pemrograman = new Subject(
                    "Algoritma dan Pemrograman"
            );


            scholarRepository.saveAll(
                    List.of(tegar, fahryan)
            );

            lecturerRepository.saveAll(
                    List.of(osvari, ali)
            );

            subjectRepository.saveAll(
                    List.of(backend, pemrograman)
            );


        };
    }
}
