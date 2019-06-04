package net.jeok.writemoon.repository;

import net.jeok.writemoon.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA Repository의 findOne, findAll, save등
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}