package com.example.lab_1_user.repositories;

import com.example.lab_1_user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   User findUserById(int id);

   void deleteById(int id);
}
