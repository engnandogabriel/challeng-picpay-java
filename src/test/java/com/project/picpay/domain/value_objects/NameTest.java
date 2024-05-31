package com.project.picpay.domain.value_objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("Should be create a name")
    void createName() throws Exception{
        Name name = Name.create("John Doe");
        Assertions.assertEquals("John Doe", name.getName());
    }
    @Test
    @DisplayName("Should be restore a name")
    void restoreName() throws Exception {
        Name name = Name.restore("John Doe");
        Assertions.assertEquals("John Doe", name.getName());
    }
    @Test
    @DisplayName("Should be throws Exception: Invalid name!")
    void testeName(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> Name.create("John 123"));
        Assertions.assertEquals("Invalid name!", exception.getMessage());
    }
}