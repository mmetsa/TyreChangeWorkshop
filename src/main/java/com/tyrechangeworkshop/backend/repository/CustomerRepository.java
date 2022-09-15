package com.tyrechangeworkshop.backend.repository;

import com.tyrechangeworkshop.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
