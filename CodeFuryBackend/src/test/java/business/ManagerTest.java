package business;


import static org.junit.jupiter.api.Assertions.*;

import com.mycomapny.business.Manager;
import com.mycomapny.business.MeetingRoom;
import com.mycomapny.business.MeetingType;
import com.mycomapny.exceptions.InsufficientCreditsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.mycomapny.services.MeetingRoomService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ManagerTest {

    private Manager manager;
    private MeetingRoomService meetingRoomService;

    @BeforeEach
    public void setUp() {
        manager = new Manager("Manager", "manager@example.com", "0987654321");
        meetingRoomService = new MeetingRoomService();
    }

    @Test
    public void testManagerCanBookRoomWithSufficientCredits() {
        MeetingRoom room = new MeetingRoom("Room 1", 10, new ArrayList<>());
        meetingRoomService.addMeetingRoom(room, MeetingType.BUSINESS);

        assertDoesNotThrow(() -> {
            manager.deductCredits(100);
        });
        assertEquals(1900, manager.getCredits());
    }

    @Test
    public void testManagerCannotBookRoomWithInsufficientCredits() {
        assertThrows(InsufficientCreditsException.class, () -> {
            manager.deductCredits(2100);
        });
    }
}
