import com.ucab.cmcapp.common.exceptions.ConvertObjectToJsonException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConvertObjectToJsonExceptionTest {

    @Test
    public void testConstructorWithString() {
        String message = "Failed to convert object to JSON";
        ConvertObjectToJsonException exception = new ConvertObjectToJsonException(message);
        assertEquals(message, exception.getMessage());
        assertNull(exception.getCause());
    }
}
