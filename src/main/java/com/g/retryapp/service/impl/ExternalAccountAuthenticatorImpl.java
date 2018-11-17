package com.g.retryapp.service.impl;

import com.g.retryapp.businessobject.AccountAuthentication;
import com.g.retryapp.service.ExternalAccountAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAccountAuthenticatorImpl implements ExternalAccountAuthenticator {

    @Autowired
    private RestTemplate restTemplate;
    public boolean authenticateExternalAccount(String accountNumber) {
        String accountAuthUrl
                = "http://localhost:8080/accountAuth/"+accountNumber;

        ResponseEntity<AccountAuthentication> response
                = restTemplate.getForEntity(accountAuthUrl, AccountAuthentication.class);


        if (response.getStatusCode() == HttpStatus.OK) {
            return true;
        }


        return false;
    }
}
