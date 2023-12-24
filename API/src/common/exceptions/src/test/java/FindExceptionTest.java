import com.ucab.cmcapp.common.exceptions.FindException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String message = "Test Exception";

        // Act
        FindException exception = new FindException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }
}