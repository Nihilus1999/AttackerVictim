

import com.ucab.cmcapp.common.exceptions.FaultBean;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FaultBeanTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String code = "123";
        String message = "Test Exception";
        String supportMessage = "Support Message";

        // Act
        FaultBean faultBean = new FaultBean(code, message, supportMessage);

        // Assert
        assertEquals(code, faultBean.getCode());
        assertEquals(message, faultBean.getMessage());
        assertEquals(supportMessage, faultBean.getSoportMessage());
    }

    @Test
    public void testSetters() {
        // Arrange
        FaultBean faultBean = new FaultBean("123", "Test Exception", "Support Message");
        String newCode = "456";
        String newMessage = "Updated Exception";
        String newSupportMessage = "Updated Support Message";

        // Act
        faultBean.setCode(newCode);
        faultBean.setMessage(newMessage);
        faultBean.setSoportMessage(newSupportMessage);

        // Assert
        assertEquals(newCode, faultBean.getCode());
        assertEquals(newMessage, faultBean.getMessage());
        assertEquals(newSupportMessage, faultBean.getSoportMessage());
    }
}