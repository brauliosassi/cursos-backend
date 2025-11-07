package com.bsassi.hexagonal.adapters.out.client.mapper;

import com.bsassi.hexagonal.adapters.out.client.response.AddressResponse;
import com.bsassi.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
