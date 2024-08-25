package exceptions;


import static org.junit.jupiter.api.Assertions.*;

import com.mycomapny.exceptions.UserNotFoundException;
import org.junit.jupiter.api.Test;

public class UserNotFoundExceptionTest {

    @Test
    public void testExceptionMessage() {
        UserNotFoundException exception = new UserNotFoundException("User not found.");
        assertEquals("User not found.", exception.getMessage());
    }
}