import com.ucab.cmcapp.common.exceptions.AuthenticationException;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuthenticationExceptionTest {
    @Test
    public void testConstructor() {
        String message = "Authentication failed";
        AuthenticationException exception = new AuthenticationException(message);
        assertEquals(message, exception.getMessage());
    }

}
