import com.ucab.cmcapp.common.exceptions.InsertException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String message = "Test Exception";

        // Act
        InsertException exception = new InsertException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }
}