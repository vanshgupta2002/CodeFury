package com.mycomapny.storage;

import com.mycomapny.business.MeetingRoom;
import java.util.List;

public interface MeetingRoomDAO {
    void addMeetingRoom(MeetingRoom room);
    MeetingRoom getMeetingRoomByName(String name);
    List<MeetingRoom> getAllMeetingRooms();
}
