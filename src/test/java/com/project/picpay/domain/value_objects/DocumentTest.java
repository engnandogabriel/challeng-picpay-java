package com.project.picpay.domain.value_objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DocumentTest {

    @Test
    @DisplayName("Should create a new valid Document")
    void createDocument() throws Exception {
        Document document = Document.create("123-456-789-10");
        Assertions.assertEquals("123.456.789-10", document.getDocument());
    }

    @Test
    @DisplayName("Should format and validate CPF document correctly")
    void testValidCPFDocument() throws Exception {
        Document document = Document.create("12345678910");
        Assertions.assertEquals("123.456.789-10", document.getDocument());
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
    @Test
    @DisplayName("Should be restore a document")
    void testRestoreEmail(){
        Document document = Document.restore("123.456.789.10");
        Assertions.assertEquals("123.456.789.10", document.getDocument());
    }
}
