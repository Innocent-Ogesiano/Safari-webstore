package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailOrUsername(String email, String username);
    User findByVerficationToken(String verificationToken);
}
