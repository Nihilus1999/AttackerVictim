

import com.ucab.cmcapp.common.enums.UserType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTypeTest {

    @Test
    public void testGetValue_Administrator() {
        // Arrange
        UserType userType = UserType.ADMINISTRATOR;
        Long expectedValue = 1L;

        // Act
        Long actualValue = userType.getValue();

        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetValue_User() {
        // Arrange
        UserType userType = UserType.USER;
        Long expectedValue = 2L;

        // Act
        Long actualValue = userType.getValue();

        // Assert
        assertEquals(expectedValue, actualValue);
    }
}
