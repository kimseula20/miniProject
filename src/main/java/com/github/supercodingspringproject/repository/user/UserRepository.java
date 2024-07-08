package com.github.supercodingspringproject.repository.user;

import com.github.supercodingspringproject.repository.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}