package com.task.tech_admire.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task.tech_admire.Models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail(String email);

    Student findByFirstName(String studentName);
}
