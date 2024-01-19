import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.properties.Registry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseMapperTest {


    @Test
    public void testIsAnyBlankWithBlankStrings() {
        // Arrange
        String[] strings = {"", "  ", "\t"};

        // Act
        boolean result = BaseMapper.isAnyBlank(strings);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsAnyBlankWithNonBlankStrings() {
        // Arrange
        String[] strings = {"abc", "def", "123"};

        // Act
        boolean result = BaseMapper.isAnyBlank(strings);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsAnyBlankWithEmptyArray() {
        // Arrange
        String[] strings = {};

        // Act
        boolean result = BaseMapper.isAnyBlank(strings);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsBlankWithBlankString() {
        // Arrange
        String string = "   ";

        // Act
        boolean result = BaseMapper.isBlank(string);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsBlankWithNonBlankString() {
        // Arrange
        String string = "abc";

        // Act
        boolean result = BaseMapper.isBlank(string);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsBlankWithNullString() {
        // Arrange
        String string = null;

        // Act
        boolean result = BaseMapper.isBlank(string);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsNullOrEmptyStringWithNullOrEmptyString() {
        // Arrange
        String string = "";

        // Act
        boolean result = BaseMapper.isNullOrEmptyString(string);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsNullOrEmptyStringWithNonEmptyString() {
        // Arrange
        String string = "abc";

        // Act
        boolean result = BaseMapper.isNullOrEmptyString(string);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsNullOrEmptyStringWithNullString() {
        // Arrange
        String string = null;

        // Act
        boolean result = BaseMapper.isNullOrEmptyString(string);

        // Assert
        Assertions.assertTrue(result);
    }
}
