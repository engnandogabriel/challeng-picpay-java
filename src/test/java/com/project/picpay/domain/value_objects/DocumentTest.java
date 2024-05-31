package com.project.picpay.domain.value_objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DocumentTest {

    @Test
    @DisplayName("Should create a new valid Document")
    void createDocument() throws Exception {
        Document document = Document.create("628.031.203-80");
        Assertions.assertEquals("628.031.203-80", document.getDocument());
    }

    @Test
    @DisplayName("Should format and validate CPF document correctly")
    void testValidCPFDocument() throws Exception {
        Document document = Document.create("62803120380");
        Assertions.assertEquals("628.031.203-80", document.getDocument());
    }

    @Test
    @DisplayName("Should format and validate CNPJ document correctly")
    void testValidCNPJDocument() throws Exception {
        Document document = Document.create("12345678000195");
        Assertions.assertEquals("12.345.678/0001-95", document.getDocument());
    }

    @Test
    @DisplayName("Should throw exception for invalid document")
    void testInvalidDocument() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            Document.create("invalid");
        });
        Assertions.assertEquals("Invalid document! Must be 11 digits (CPF) or 14 digits (CNPJ)!", exception.getMessage());
    }
}
