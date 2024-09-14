package com.task.tech_admire.Service.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.tech_admire.Models.ApplicationResponse;
import com.task.tech_admire.Repository.ApplicationRepository;
import com.task.tech_admire.Service.ApplicationService;

@Service

public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public void processApplication(ApplicationResponse response) {
        applicationRepository.save(response);

    }
}
