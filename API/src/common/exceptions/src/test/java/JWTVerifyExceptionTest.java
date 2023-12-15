
import com.ucab.cmcapp.common.exceptions.JWTVerifyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JWTVerifyExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String message = "Test Exception";

        // Act
        JWTVerifyException exception = new JWTVerifyException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }
}