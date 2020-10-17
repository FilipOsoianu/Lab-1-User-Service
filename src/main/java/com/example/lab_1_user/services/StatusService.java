package com.example.lab_1_user.services;


import com.example.lab_1_user.entities.Status;
import com.example.lab_1_user.repositories.StatusRepository;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements StatusRepository {
//    TODO return number of threads
    @Override
    public Status getStatus() {
        return new Status(4);
    }
}
