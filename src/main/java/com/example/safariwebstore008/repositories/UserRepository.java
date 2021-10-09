package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
 Optional<User> findUserByEmail(String email);


}
