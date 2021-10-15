package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
 Optional<Users>findUserModelByEmail(String email);
}
