package com.project.picpay.infra.gateway;

import com.project.picpay.domain.gateway.AuthorizationGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AuthorizationService implements AuthorizationGateway {
    private final String AUTHORIZATION_URL = "https://util.devi.tools/api/v2/authorize";

    @Override
    public boolean authorize() {
        try {
            ResponseEntity<Map> authorizationResponse = new RestTemplate().getForEntity(this.AUTHORIZATION_URL, Map.class);
            if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
                Map<String, Object> responseBody = authorizationResponse.getBody();
                if (responseBody != null && responseBody.containsKey("status")) {
                    String status = (String) responseBody.get("status");
                    return "success".equals(status);
                }
            }
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Acesso proibido: " + e.getMessage());
            return false;
        } catch (HttpServerErrorException.InternalServerError e) {
            System.out.println("O serviço está temporariamente indisponível. Tente novamente mais tarde.");
            return false;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar autorizar: " + e.getMessage());
        }
        return false;
    }
}
