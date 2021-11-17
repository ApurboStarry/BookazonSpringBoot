package com.starryinc.Bookazon.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByEmailAndPassword(String email, String password);
    Optional<User> findUserByUserId(Long id);
}
