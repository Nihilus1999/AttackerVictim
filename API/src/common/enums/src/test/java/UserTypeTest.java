import com.ucab.cmcapp.common.enums.UserType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTypeTest {

    @Test
    public void testUserTypeValues() {
        assertEquals(1L, UserType.ADMINISTRATOR.getValue());
        assertEquals(2L, UserType.USER.getValue());
    }
}
