package net.jeok.writemoon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jeok.writemoon.model.User;

/**
 * Spring Data JPA Repository의 findOne, findAll, save등
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
