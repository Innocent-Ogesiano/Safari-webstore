package com.example.safariwebstore008.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface UserRepository extends JpaRepository<User,Long> {
}
