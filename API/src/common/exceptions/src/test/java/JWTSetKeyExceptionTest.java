package com.ucab.cmcapp.common.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JWTSetKeyExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String message = "Test Exception";

        // Act
        JWTSetKeyException exception = new JWTSetKeyException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }
}