package com.project.picpay.infra.gateway;

import com.project.picpay.domain.entities.user.Commun;
import com.project.picpay.domain.entities.user.Merchant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EmailServiceTest {
  @Test
    void teste() throws Exception{
      Commun commun = Commun.create("Nando Gabriel", "123.456.789-10", "nandogabrie@gmail.com", "johndoe123", 100D);
      Merchant merchant = Merchant.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
      new EmailService().sender(commun, merchant, 100D);
  }
}