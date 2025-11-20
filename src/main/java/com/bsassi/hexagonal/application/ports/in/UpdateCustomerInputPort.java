package com.bsassi.hexagonal.application.ports.in;

import com.bsassi.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
