package com.shop.demoshop.repository;

import com.shop.demoshop.model.user.Role;
import com.shop.demoshop.model.user.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleUser);

}
