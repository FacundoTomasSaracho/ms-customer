package org.example.mscustomer.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.mscustomer.business.model.ClientType;
import org.example.mscustomer.presentation.controller.impl.CustomerControllerImpl;
import org.example.mscustomer.presentation.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Customer", description = "Customer methods.")
public interface CustomerControllerApi {

    @Operation(
            summary = "Endpoint que permite crear un nuevo customer.",
            description = "Endpoint que permite crear un nuevo customer retornando dicha entidad en un caso exitoso junto con su ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna el customer luego de ser creado.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            type = "CustomerDto",
                                            implementation = CustomerDto.class
                                    )
                            )
                    )
            }
    )
    @PostMapping
    ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerDto customerDto);

    @PostMapping("calculate-tax")
    ResponseEntity<Double> calculateClientTaxes(@RequestBody CustomerControllerImpl.ClientTax clientTax);
}
