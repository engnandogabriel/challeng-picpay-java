package com.project.picpay.domain.value_objects;

public class Document {
    private String document;

    private Document(String document) {
        this.document = document;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) throws Exception {
        this.document = validateAndFormatDocument(document);
    }

    public static Document create(String document) throws Exception {
        String validDocument = validateAndFormatDocument(document);
        return new Document(validDocument);
    }

    public static Document restore(String document) {
        return new Document(document);
    }

    private static String validateAndFormatDocument(String document) throws Exception {
        document = document.replaceAll("\\D", "");
        if (document.length() == 11)
            return formatCPF(document);
        if (document.length() == 14)
            return formatCNPJ(document);

        throw new Exception("Invalid document! Must be 11 digits (CPF) or 14 digits (CNPJ)!");

    }

    private static String formatCPF(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    private static String formatCNPJ(String cnpj) {
        return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
    }
}