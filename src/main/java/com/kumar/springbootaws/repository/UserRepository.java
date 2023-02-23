package com.kumar.springbootaws.repository;

import com.kumar.springbootaws.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
