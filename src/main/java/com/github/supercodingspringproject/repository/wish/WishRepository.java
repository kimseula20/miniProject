package com.github.supercodingspringproject.repository.wish;

import com.github.supercodingspringproject.repository.wish.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Integer> {
}