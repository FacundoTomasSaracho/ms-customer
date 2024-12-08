package org.example.mscustomer.strategy.client.fabric;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.mscustomer.business.model.ClientType;
import org.example.mscustomer.strategy.client.ClientTaxStrategy;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.EnumSet;

@Component
@RequiredArgsConstructor
public class ClientFabric {

    private final BeanFactory beanFactory;
    private static final EnumMap<ClientType, ClientTaxStrategy> CLIENT_STRATEGY_ENUM_MAP = new EnumMap<>(ClientType.class);

    @PostConstruct
    public void postConstruct() {
        EnumSet.allOf(TaxesForClients.class)
                .forEach(taxesForClients -> CLIENT_STRATEGY_ENUM_MAP.put(taxesForClients.getClientType(),
                        beanFactory.getBean(taxesForClients.getBeanName(), ClientTaxStrategy.class)));
    }

    public ClientTaxStrategy getStrategy(ClientType clientType) {
        return CLIENT_STRATEGY_ENUM_MAP.get(clientType);
    }


    @RequiredArgsConstructor
    @Getter
    private enum TaxesForClients {

        B2C(ClientType.B2C, "b2cClientTaxStrategyServiceImpl"),
        B2B(ClientType.B2B, "b2bClientTaxStrategyServiceImpl");

        private final ClientType clientType;
        private final String beanName;
    }
}


