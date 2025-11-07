package com.bsassi.hexagonal.application.core.usecase;

import com.bsassi.hexagonal.application.core.domain.Customer;
import com.bsassi.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.bsassi.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.bsassi.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase (
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort
    ){
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode ) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
