package com.g.retryapp.controller;

import com.g.retryapp.businessobject.AccountAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AccountAuthenticator {

    @Value("${validate.retry}")
    public boolean validateRetry;
    private int counter=0;
    @GetMapping(value = "/accountAuth/{accountNumber}")
    public ResponseEntity authenticate(@PathVariable String accountNumber)
    {
        AccountAuthentication accountAuthentication  = new AccountAuthentication();
        accountAuthentication.setAccountNumber(accountNumber);
        accountAuthentication.setIsvalid(true);
        //during the retry validation the service returns error code SERVICE_UNAVAILABLE
        if(validateRetry)
        {
            counter++;
            if(counter%2==0) {
                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
            }
        }


        return ResponseEntity.ok(accountAuthentication);
    }
}
