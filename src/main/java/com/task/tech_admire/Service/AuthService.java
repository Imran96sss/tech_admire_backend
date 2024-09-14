package com.task.tech_admire.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.task.tech_admire.Models.Student;
import com.task.tech_admire.Repository.StudentRepository;

@Service
public class AuthService {

    public final StudentRepository studentRepository;

    public AuthService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }
}