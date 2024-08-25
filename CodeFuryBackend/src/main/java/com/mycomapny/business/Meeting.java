package com.mycomapny.business;

import java.time.LocalDateTime;

public class Meeting {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private MeetingType meetingType;
    private User organizer;

    public Meeting(LocalDateTime startTime, LocalDateTime endTime, MeetingType meetingType, User organizer) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingType = meetingType;
        this.organizer = organizer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public MeetingType getMeetingType() {
        return meetingType;
    }

    public User getOrganizer() {
        return organizer;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", meetingType=" + meetingType +
                ", organizer=" + organizer.getName() +
                '}';
    }
}
