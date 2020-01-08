package com.smartevn.cokhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartevn.cokhi.model.Role;
import com.smartevn.cokhi.model.RoleName;

import java.util.Optional;

/**
 * 
 * @author vadinh
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
