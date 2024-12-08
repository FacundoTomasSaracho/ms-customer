package org.example.mscustomer.business.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ClientType {

    @JsonProperty("B2B") B2B,
    @JsonProperty("B2C") B2C
}
