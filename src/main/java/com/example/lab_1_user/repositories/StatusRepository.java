package com.example.lab_1_user.repositories;

import com.example.lab_1_user.entities.Status;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusRepository {
    Status getStatus();
}