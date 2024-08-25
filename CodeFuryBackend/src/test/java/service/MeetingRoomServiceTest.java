package service;


import static org.junit.jupiter.api.Assertions.*;

import com.mycomapny.business.*;
import com.mycomapny.business.MeetingType;
import com.mycomapny.services.MeetingRoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MeetingRoomServiceTest {

    private MeetingRoomService meetingRoomService;

    @BeforeEach
    public void setUp() {
        meetingRoomService = new MeetingRoomService();
    }

    @Test
    public void testAddAndRetrieveMeetingRoom() {
        MeetingRoom room = new MeetingRoom("Room 1", 10, new ArrayList<>());
        meetingRoomService.addMeetingRoom(room, MeetingType.BUSINESS);
        assertNotNull(meetingRoomService.getMeetingRoomByName("Room 1"));
    }

    @Test
    public void testGetMeetingRoomReturnsNullWhenNotFound() {
        assertNull(meetingRoomService.getMeetingRoomByName("Nonexistent Room"));
    }
}
