package com.github.supercodingspringproject.repository.shipping;

import com.github.supercodingspringproject.repository.shipping.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
}