package exceptions;


import static org.junit.jupiter.api.Assertions.*;

import com.mycomapny.exceptions.InsufficientCreditsException;
import org.junit.jupiter.api.Test;

public class InsufficientCreditsExceptionTest {

    @Test
    public void testExceptionMessage() {
        InsufficientCreditsException exception = new InsufficientCreditsException("Insufficient credits to book the room.");
        assertEquals("Insufficient credits to book the room.", exception.getMessage());
    }
}
