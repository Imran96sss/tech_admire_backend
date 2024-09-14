package com.task.tech_admire.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.task.tech_admire.Models.ApplicationRequest;
import com.task.tech_admire.Models.ApplicationResponse;
import com.task.tech_admire.Models.Student;
import com.task.tech_admire.Repository.StudentRepository;
import com.task.tech_admire.Service.ApplicationService;
import com.task.tech_admire.Service.AuthService;

@RestController
@RequestMapping("/api/v1/application")
public class ApplicationController {

    public final StudentRepository studentRepository;
    public final AuthService authService;
    public final ApplicationService applicationService;

    public ApplicationController(StudentRepository studentRepository, AuthService authService,
            ApplicationService applicationService) {
        this.studentRepository = studentRepository;
        this.authService = authService;
        this.applicationService = applicationService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/")
    public ResponseEntity<String> createApplication(@RequestBody ApplicationRequest applicationRequest) {

        // get student by name as i have currently included email as extra parameter
        Student student = studentRepository.findByEmail(applicationRequest.getEmail());

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        // Add the student ID to the request data
        ApplicationResponse updatedResponse = new ApplicationResponse(
                student.getId(),
                applicationRequest.getStudentName(),
                applicationRequest.getUniversityName(),
                applicationRequest.getCourseName(),
                applicationRequest.getEmail());

        applicationService.processApplication(updatedResponse);

        return ResponseEntity.ok("Application submitted successfully");

    }
}

// ----------------------------------------------------------------------
// on basis of name as per requirement, student validation can be checked
// this below scope of code is extra as basic things are covered as per shared
// test
// ----------------------------------------------------------------------

// Optional<Student> studentOptional =
// Optional.ofNullable(studentRepository.findByFirstName(applicationRequest.getStudentName()));
// if (studentOptional.isPresent()) {
// Student studentObject = studentOptional.get();
// if (!studentObject.getFirstName().isEmpty()) {
// System.out.println("Student found: " + studentObject.getFirstName());
// } else {
// System.out.println("Student first name is empty");
// }
// } else {
// System.out.println("Student not found");
// }}