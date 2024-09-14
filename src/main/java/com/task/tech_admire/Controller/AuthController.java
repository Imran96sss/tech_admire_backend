package com.task.tech_admire.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.task.tech_admire.Models.Student;
import com.task.tech_admire.Models.StudentLoginRequest;
import com.task.tech_admire.Repository.StudentRepository;
import com.task.tech_admire.Service.AuthService;

@RestController
@RequestMapping("/api/v1/student")
public class AuthController {

    public final StudentRepository studentRepository;
    public final AuthService authService;

    public AuthController(StudentRepository studentRepository, AuthService authService) {
        this.studentRepository = studentRepository;
        this.authService = authService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    public ResponseEntity<Student> signupStudent(@RequestBody Student student) {
        Student savedStudent = authService.registerStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody StudentLoginRequest loginRequest) {

        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        // Find student by email
        Student student = studentRepository.findByEmail(email);

        if (student == null) {
            return ResponseEntity.status(401).body("No user Found");
        }

        if (student != null && student.getPassword().equals(password)) {
            return ResponseEntity.ok("true");
        } else {
            return ResponseEntity.status(401).body("false");
        }
    }

}