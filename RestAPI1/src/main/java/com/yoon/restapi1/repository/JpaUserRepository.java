package com.yoon.restapi1.repository;

import com.yoon.restapi1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {
}
