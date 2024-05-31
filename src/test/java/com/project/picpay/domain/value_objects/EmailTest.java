package com.project.picpay.domain.value_objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class EmailTest {

    @Test
    @DisplayName("Should be create a email valid")
    void createEmail () throws Exception{
        Email email = Email.create("johndoe@gmail.com");
        Assertions.assertEquals("johndoe@gmail.com", email.getEmail());
    }
    void restoreEmail () throws Exception{
        Email email = Email.restore("johndoe@gmail.com");
        Assertions.assertEquals("johndoe@gmail.com", email.getEmail());
    }
    @Test
    @DisplayName("Should be throws a Exception: E-mail is invalid!")
    void testeEmail() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> Email.create("invalid"));
        Assertions.assertEquals("E-mail is invalid!", exception.getMessage());
    }
}