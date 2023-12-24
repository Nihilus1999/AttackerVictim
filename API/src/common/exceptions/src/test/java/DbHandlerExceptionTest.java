
import com.ucab.cmcapp.common.exceptions.DbHandlerException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DbHandlerExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String message = "Test Exception";

        // Act
        DbHandlerException exception = new DbHandlerException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }
}