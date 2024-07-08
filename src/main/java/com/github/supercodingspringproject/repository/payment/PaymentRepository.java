package com.github.supercodingspringproject.repository.payment;

import com.github.supercodingspringproject.repository.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}