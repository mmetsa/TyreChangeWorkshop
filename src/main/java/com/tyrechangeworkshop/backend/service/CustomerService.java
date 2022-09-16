package com.tyrechangeworkshop.backend.service;

import com.tyrechangeworkshop.backend.entity.Customer;
import com.tyrechangeworkshop.backend.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

}
