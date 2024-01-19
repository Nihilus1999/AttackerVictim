import com.ucab.cmcapp.properties.Registry;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegistryTest {

    @Test(expected = NullPointerException.class)
    public void testGetPropertyWithNullRegistry() {
        // Arrange
        Registry registry = null;
        String expectedValue = "value";
        String mockConfigDbUnit = "config.db.unit=" + expectedValue;

        // Act
        String actualValue = registry.getProperty("config.db.unit");

        // Assert
        assertEquals(expectedValue, actualValue);
    }
}
