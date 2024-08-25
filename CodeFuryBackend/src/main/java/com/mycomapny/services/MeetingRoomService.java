package com.mycomapny.services;

import com.mycomapny.business.Amenity;
import com.mycomapny.business.MeetingRoom;
import com.mycomapny.business.MeetingType;
import com.mycomapny.storage.MeetingRoomDAO;
import com.mycomapny.storage.MeetingRoomDAOImpl;
import java.util.EnumSet;
import java.util.List;

public class MeetingRoomService {
    private final MeetingRoomDAO meetingRoomDAO = new MeetingRoomDAOImpl();

    public void addMeetingRoom(MeetingRoom room, MeetingType meetingType) {
        EnumSet<Amenity> requiredAmenities = meetingType.getMandatoryAmenities();
        if (!room.getAmenities().containsAll(requiredAmenities)) {
            throw new IllegalArgumentException("Room does not have all mandatory amenities for the selected meeting type.");
        }
        meetingRoomDAO.addMeetingRoom(room);
    }

    public MeetingRoom getMeetingRoomByName(String name) {
        return meetingRoomDAO.getMeetingRoomByName(name);
    }

    public List<MeetingRoom> getAllMeetingRooms() {
        return meetingRoomDAO.getAllMeetingRooms();
    }
}