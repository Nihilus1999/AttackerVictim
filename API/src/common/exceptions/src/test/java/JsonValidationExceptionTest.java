import com.ucab.cmcapp.common.exceptions.JsonValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonValidationExceptionTest {

    @Test
    public void testConstructorAndGetMessage() {
        // Arrange
        String message = "Test Message";

        // Act
        JsonValidationException exception = new JsonValidationException(message);
        String actualMessage = exception.getMessage();

        // Assert
        Assertions.assertEquals(message, actualMessage);
    }
}