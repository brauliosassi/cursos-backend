package com.bsassi.hexagonal.application.ports.out.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${arantes.client.address.url}"
)
public class FindAddressByZipCodeClient {
}
