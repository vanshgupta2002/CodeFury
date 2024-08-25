package business;


import static org.junit.jupiter.api.Assertions.*;

import com.mycomapny.business.Meeting;
import com.mycomapny.business.MeetingRoom;
import com.mycomapny.business.MeetingType;
import com.mycomapny.business.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.mycomapny.services.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberTest {

    private Member member;
    private MeetingRoomService meetingRoomService;

    @BeforeEach
    public void setUp() {
        member = new Member("Member", "member@example.com", "1122334455");
        meetingRoomService = new MeetingRoomService();
    }

    @Test
    public void testMemberCanViewScheduledMeetings() {
        // Simulate scheduled meeting for a member
        MeetingRoom room = new MeetingRoom("Room 1", 10, new ArrayList<>());
        meetingRoomService.addMeetingRoom(room, MeetingType.BUSINESS);
        room.addMeeting(new Meeting(LocalDateTime.now(), LocalDateTime.now().plusHours(1), MeetingType.BUSINESS, member));

        assertFalse(meetingRoomService.getAllMeetingRooms().isEmpty());
    }
}
