package business;

import static org.junit.jupiter.api.Assertions.*;

import com.mycomapny.business.Admin;
import com.mycomapny.business.MeetingRoom;
import com.mycomapny.business.MeetingType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.mycomapny.services.*;
import java.util.ArrayList;

public class AdminTest {

    private MeetingRoomService meetingRoomService;

    @BeforeEach
    public void setUp() {
        Admin admin = new Admin("Admin", "admin@example.com", "1234567890");
        meetingRoomService = new MeetingRoomService();
    }

    @Test
    public void testAdminCanCreateRoom() {
        MeetingRoom room = new MeetingRoom("Room 1", 10, new ArrayList<>());
        meetingRoomService.addMeetingRoom(room, MeetingType.BUSINESS);
        assertNotNull(meetingRoomService.getMeetingRoomByName("Room 1"));
    }

    @org.junit.Test
    @Test
    public void testAdminCannotCreateRoomWithoutMandatoryAmenities() {
        MeetingRoom room = new MeetingRoom("Room 2", 10, new ArrayList<>());
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> meetingRoomService.addMeetingRoom(room, MeetingType.CLASSROOM_TRAINING),
                "Expected addMeetingRoom() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Room does not have all mandatory amenities"));
    }
}
