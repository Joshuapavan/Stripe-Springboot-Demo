package com.joshuapavan.stripepaymentexampleapp.controllers;

import com.joshuapavan.stripepaymentexampleapp.model.Response;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    @PostMapping("/create-payment-intent")
    public Response createPaymentIntent() throws StripeException {
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount((long) calculateOrderAmount())
                        .setCurrency("inr")
                        // In the latest version of the API, specifying the `automatic_payment_methods` parameter is optional because Stripe enables its functionality by default.
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams.AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();

        // Create a PaymentIntent with the order amount and currency
        PaymentIntent intent =
                PaymentIntent.create(params);
        return new Response(intent.getId(),
                intent.getClientSecret());
    }






    int calculateOrderAmount() {
        // Replace this constant with a calculation of the order's amount
        // Calculate the order total on the server to prevent
        // people from directly manipulating the amount on the client
        return 1400;
    }


}
