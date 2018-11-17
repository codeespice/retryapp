package com.g.retryapp.controller;

import com.g.retryapp.businessobject.PaymentOption;
import com.g.retryapp.service.ExternalAccountAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;

@RestController
public class PaymenOptionController {

    @Autowired
    private ExternalAccountAuthenticator externalAccountAuthenticator;

    @PostMapping(value="/paymentOption")
    public ResponseEntity addPaymentOption(@RequestBody PaymentOption paymentOption)
    {

        if(externalAccountAuthenticator.authenticateExternalAccount(paymentOption.getAccountNumber()))
        {
          URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(paymentOption.getAccountNumber()).toUri();
          return ResponseEntity.created(location).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


    }

}
