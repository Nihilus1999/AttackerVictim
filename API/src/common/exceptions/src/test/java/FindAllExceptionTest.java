import com.ucab.cmcapp.common.exceptions.FindAllException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindAllExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String message = "Test Exception";

        // Act
        FindAllException exception = new FindAllException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }
}