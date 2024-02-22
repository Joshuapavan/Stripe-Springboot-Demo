package com.joshuapavan.stripepaymentexampleapp.configs;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfigs {

    @Value("${stripe.api.secretKey}")
    private String secretKey;

    @PostConstruct
    public void initializeStripeSecret(){
        Stripe.apiKey = this.secretKey;
    }

}
