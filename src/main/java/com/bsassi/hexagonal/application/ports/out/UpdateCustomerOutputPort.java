package com.bsassi.hexagonal.application.ports.out;

import com.bsassi.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
