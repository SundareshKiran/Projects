package com.domain.filghtreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.filghtreservation.entities.User;

public interface UserRepositry extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
