package com.klinnovations.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klinnovations.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
