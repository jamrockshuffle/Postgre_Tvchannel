package com.arch.tvchannel.security.repository;

import com.arch.tvchannel.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Role.ERole name);
}
