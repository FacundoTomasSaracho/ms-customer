package org.example.mscustomer.strategy.client.impl;

import org.example.mscustomer.strategy.client.ClientTaxStrategy;
import org.springframework.stereotype.Service;

@Service
public class B2cClientTaxStrategyServiceImpl implements ClientTaxStrategy {
    @Override
    public Double calculateTax(Double amount) {
        return amount * 4.6;
    }
}
