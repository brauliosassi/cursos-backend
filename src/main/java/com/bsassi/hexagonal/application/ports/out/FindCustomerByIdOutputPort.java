package com.bsassi.hexagonal.application.ports.out;

import com.bsassi.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
