import com.ucab.cmcapp.common.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotFoundExceptionTest {

    @Test
    public void testEquals() {
        // Arrange
        String message1 = "Test Message";
        String message2 = "Test Message";
        String differentMessage = "Different Message";

        NotFoundException exception1 = new NotFoundException(message1);
        NotFoundException exception2 = new NotFoundException(message2);
        NotFoundException differentException = new NotFoundException(differentMessage);

        // Act and Assert
        Assertions.assertNotEquals(exception1, differentException); // Verifica que los objetos no sean iguales
    }
}