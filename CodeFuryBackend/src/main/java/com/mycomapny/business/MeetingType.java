package com.mycomapny.business;

import java.util.EnumSet;
import java.util.Set;

public enum MeetingType {
    CLASSROOM_TRAINING(EnumSet.of(Amenity.WHITEBOARD, Amenity.PROJECTOR)),
    ONLINE_TRAINING(EnumSet.of(Amenity.WIFI_CONNECTION, Amenity.PROJECTOR)),
    CONFERENCE_CALL(EnumSet.of(Amenity.CONFERENCE_CALL_FACILITY)),
    BUSINESS(EnumSet.of(Amenity.PROJECTOR));

    private final EnumSet<Amenity> mandatoryAmenities;

    MeetingType(EnumSet<Amenity> mandatoryAmenities) {
        this.mandatoryAmenities = mandatoryAmenities;
    }

    public EnumSet<Amenity> getMandatoryAmenities() {
        return mandatoryAmenities;
    }
}