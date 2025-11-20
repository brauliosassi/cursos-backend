package com.bsassi.hexagonal.config;

import com.bsassi.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.bsassi.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.bsassi.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.bsassi.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerByIdConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ){
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
