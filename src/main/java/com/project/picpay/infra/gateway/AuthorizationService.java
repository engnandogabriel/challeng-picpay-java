package com.project.picpay.infra.gateway;

import com.project.picpay.domain.gateway.AuthorizationGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AuthorizationService implements AuthorizationGateway {
    private final String AUTHORIZATION_URL = "https://util.devi.tools/api/v2/authorize";

    public AuthorizationService() {
    }

    @Override
    public boolean authorize(){
        ResponseEntity<Map> authorizationResponse = new RestTemplate().getForEntity(this.AUTHORIZATION_URL, Map.class);
        if (authorizationResponse.getStatusCode() == HttpStatus.OK)
            if (authorizationResponse.getBody().get("status").equals("success"))
                return true;
        return false;
    }
}
