package com.bsassi.hexagonal.application.ports.out;

import com.bsassi.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
