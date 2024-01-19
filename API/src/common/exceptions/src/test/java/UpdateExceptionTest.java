package com.ucab.cmcapp.common.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String message = "Test Exception";
        Exception cause = new RuntimeException("Cause Exception");

        // Act
        UpdateException exception = new UpdateException(cause, message);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}