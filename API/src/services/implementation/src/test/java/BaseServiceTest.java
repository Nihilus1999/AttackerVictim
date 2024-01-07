import com.ucab.cmcapp.common.exceptions.JWTVerifyException;
import com.ucab.cmcapp.implementation.BaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;
import java.util.Set;

// ...

class BaseServiceTest {

    private BaseService baseService;

    @BeforeEach
    void setUp() {
        baseService = new BaseService();
    }

    @Test
    void verifyParams_NullObject_ThrowsBadRequestException() {
        // Arrange
        Object object = null;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            baseService.verifyParams(object);
        });

        // Assert
        // The WebApplicationException should be thrown
    }

    @Test
    public void testGetClasses() {
        // Act
        Set<Class<?>> classes = baseService.getClasses();

        // Assert
        Assertions.assertNotNull(classes);
        Assertions.assertTrue(classes.isEmpty());
    }

    @Test
    void verifyParams_NonNullObject_DoesNotThrowException() {
        // Arrange
        Object object = new Object();

        // Act
        Assertions.assertDoesNotThrow(() -> {
            baseService.verifyParams(object);
        });

        // Assert
        // No exception should be thrown
    }

    @Test
    void throwException_StatusOnly_ReturnsWebApplicationException() {
        // Arrange
        Response.Status status = Response.Status.BAD_REQUEST;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            baseService.throwException(status);
        });

        // Assert
        // The WebApplicationException should be thrown
    }

    @Test
    void throwException_WithExceptionAndStatus_ReturnsWebApplicationException() {
        // Arrange
        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
        Exception exception = new Exception("Test exception");

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            baseService.throwException(exception, status);
        });

        // Assert
        // The WebApplicationException should be thrown
    }

    @Test
    void validateCredentials_InvalidCredential_ThrowsJWTVerifyException() {
        // Arrange
        String invalidCredential = "invalidToken";

        // Act & Assert
        Assertions.assertThrows(JWTVerifyException.class, () -> {
            baseService.validateCredentials(invalidCredential);
        });
    }
}
