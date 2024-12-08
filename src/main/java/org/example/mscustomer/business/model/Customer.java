package org.example.mscustomer.business.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
}
