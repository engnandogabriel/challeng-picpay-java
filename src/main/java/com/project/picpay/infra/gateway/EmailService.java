package com.project.picpay.infra.gateway;

import com.project.picpay.domain.entities.user.User;
import com.project.picpay.domain.gateway.EmailGateway;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;

public class EmailService implements EmailGateway {
    private final String EMAIL_SERVICE_URL = "https://util.devi.tools/api/v1/notify";

    @Override
    public void sender(User from, User to, Double value) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> emailData = new HashMap<>();
        emailData.put("to", to.getEmail());
        emailData.put("subject", "Transferência Bancária Recebida");
        emailData.put("body", this.message(from, to, value));

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(emailData, headers);
        new RestTemplate().postForEntity(EMAIL_SERVICE_URL, requestEntity, String.class);
        System.out.println(emailData.toString());
    }

    private String message(User from, User to, Double value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Olá, " + to.getName() + "\n");
        stringBuilder.append("Informamos que você recebeu uma transferência bancária.\n\n");
        stringBuilder.append("Abaixo estão alguns detalhes importantes:\n\n");
        stringBuilder.append("1. Valor da transferência: R$ " + value + "\n");
        stringBuilder.append("2. A transferência veio de " + from.getName() + " - " + from.getEmail() + "\n");
        stringBuilder.append("Obrigado por usar nossos serviços!");
        return stringBuilder.toString();
    }
}
