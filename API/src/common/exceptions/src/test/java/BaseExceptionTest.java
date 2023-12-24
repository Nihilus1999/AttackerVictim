

import com.ucab.cmcapp.common.exceptions.BaseException;
import org.junit.Test;
import static org.junit.Assert.*;

public class BaseExceptionTest {

    @Test
    public void testConstructorWithString() {
        String message = "Base exception occurred";
        BaseException exception = new BaseException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testConstructorWithException() {
        String message = "Base exception occurred";
        Exception cause = new Exception("Cause exception");
        BaseException exception = new BaseException(cause, message);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testConstructorWithIllegalArgumentException() {
        String message = "Invalid argument";
        IllegalArgumentException cause = new IllegalArgumentException(message);
        BaseException exception = new BaseException(cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
    @Test
    public void testConstructorWithExceptionNoMessage() {
        Exception cause = new Exception("Cause exception");
        BaseException exception = new BaseException(cause);
        assertEquals("java.lang.Exception: Cause exception", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}