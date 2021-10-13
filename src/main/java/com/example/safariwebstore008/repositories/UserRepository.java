package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 Optional<User>findUserModelByEmail(String email);
 Optional<User> findByRolesAndDispatchRiderLocation(Roles userRole, String location);
}
