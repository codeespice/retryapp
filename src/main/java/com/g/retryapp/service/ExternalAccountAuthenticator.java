package com.g.retryapp.service;


import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.client.HttpServerErrorException;

public interface ExternalAccountAuthenticator {

    @Retryable(
            value = { HttpServerErrorException.class },
            maxAttempts = 2,
            backoff = @Backoff(delay = 1000))
    boolean authenticateExternalAccount(String accountNumber);

}
