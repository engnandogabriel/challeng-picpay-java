package com.project.picpay.infra.gateway;

import com.project.picpay.domain.entities.user.User;
import com.project.picpay.domain.gateway.EmailGateway;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService implements EmailGateway {
    private final String EMAIL_SERVICE_URL = "https://util.devi.tools/api/v1/notify";

    @Override
    public void sender(User from, User to, Double value) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, String> emailData = new HashMap<>();
            emailData.put("to", to.getEmail());
            emailData.put("subject", "Transferência Bancária Recebida");
            emailData.put("body", this.message(from, to, value));

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(emailData, headers);
            ResponseEntity<String> response = new RestTemplate().postForEntity(EMAIL_SERVICE_URL, requestEntity, String.class);
            if (response.getStatusCode() == HttpStatus.NO_CONTENT) System.out.println(emailData.get("body").toString());

        } catch (HttpServerErrorException.GatewayTimeout e) {
            // Lidar com o erro de tempo limite do gateway aqui
            System.out.println("O serviço de e-mail está temporariamente indisponível. Tente novamente mais tarde.");
        } catch (Exception e) {
            // Lidar com outros erros de maneira genérica aqui
            System.out.println("Ocorreu um erro ao enviar o e-mail: " + e.getMessage());
        }
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
