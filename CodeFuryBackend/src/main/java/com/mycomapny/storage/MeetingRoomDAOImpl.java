package com.mycomapny.storage;

import com.mycomapny.business.MeetingRoom;
import java.util.ArrayList;
import java.util.List;

public class MeetingRoomDAOImpl implements MeetingRoomDAO {
    private final List<MeetingRoom> meetingRooms = new ArrayList<>();

    @Override
    public void addMeetingRoom(MeetingRoom room) {
        meetingRooms.add(room);
    }

    @Override
    public MeetingRoom getMeetingRoomByName(String name) {
        for (MeetingRoom room : meetingRooms) {
            if (room.getRoomName().equals(name)) {
                return room;
            }
        }
        return null;
    }

    @Override
    public List<MeetingRoom> getAllMeetingRooms() {
        return meetingRooms;
    }
}