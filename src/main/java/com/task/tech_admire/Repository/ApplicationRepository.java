package com.task.tech_admire.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task.tech_admire.Models.ApplicationResponse;

public interface ApplicationRepository extends JpaRepository<ApplicationResponse, Long> {

}
