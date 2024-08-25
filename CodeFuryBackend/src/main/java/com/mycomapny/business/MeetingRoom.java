package com.mycomapny.business;

import java.util.List;

public class MeetingRoom {
    private String roomName;
    private int seatingCapacity;
    private List<Amenity> amenities;
    private List<Meeting> scheduledMeetings;

    public MeetingRoom(String roomName, int seatingCapacity, List<Amenity> amenities) {
        this.roomName = roomName;
        this.seatingCapacity = seatingCapacity;
        this.amenities = amenities;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public int calculateCostPerHour() {
        int cost = 0;

        if (seatingCapacity > 5 && seatingCapacity <= 10) {
            cost += 10;
        } else if (seatingCapacity > 10) {
            cost += 20;
        }

        for (Amenity amenity : amenities) {
            switch (amenity) {
                case PROJECTOR:
                    cost += 5;
                    break;
                case WIFI_CONNECTION:
                    cost += 10;
                    break;
                case CONFERENCE_CALL_FACILITY:
                    cost += 15;
                    break;
                case WHITEBOARD:
                    cost += 5;
                    break;
                case WATER_DISPENSER:
                    cost += 5;
                    break;
                case TV:
                    cost += 10;
                    break;
                case COFFEE_MACHINE:
                    cost += 10;
                    break;
            }
        }
        return cost;
    }

    public List<Meeting> getScheduledMeetings() {
        return scheduledMeetings;
    }

    public void addMeeting(Meeting meeting) {
        this.scheduledMeetings.add(meeting);
    }
}