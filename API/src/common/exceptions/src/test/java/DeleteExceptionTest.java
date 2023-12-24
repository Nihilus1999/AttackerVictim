import com.ucab.cmcapp.common.exceptions.DeleteException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String message = "Test Exception";

        // Act
        DeleteException exception = new DeleteException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }
}