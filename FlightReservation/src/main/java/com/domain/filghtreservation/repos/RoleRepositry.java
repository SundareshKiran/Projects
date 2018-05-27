package com.domain.filghtreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.filghtreservation.entities.Role;

public interface RoleRepositry extends JpaRepository<Role, Long> {

}
