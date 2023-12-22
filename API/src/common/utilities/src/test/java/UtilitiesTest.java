

import com.ucab.cmcapp.common.exceptions.ConvertObjectToJsonException;
import com.ucab.cmcapp.common.util.Utilities;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilitiesTest {

    private Utilities utilities;

    @Before
    public void setUp() {
        utilities = new Utilities();
    }

    @Test
    public void testJsonToObject() {
        // Arrange
        String json = "{\"key\": \"value\"}";
        JSONObject expectedObject = new JSONObject(json);

        // Act
        JSONObject actualObject = utilities.jsonToObject(json);

        // Assert
        assertEquals(expectedObject.toString(), actualObject.toString());
    }

    @Test(expected = ConvertObjectToJsonException.class)
    public void testJsonToObject_InvalidJson() {
        // Arrange
        String invalidJson = "{invalidJson}";

        // Act
        utilities.jsonToObject(invalidJson);
    }
}