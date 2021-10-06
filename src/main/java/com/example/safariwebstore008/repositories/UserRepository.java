package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
 Optional<UserModel>findUserModelByEmail(String email);
}
