-- Create Users Table
CREATE TABLE Users (
    UserID INT PRIMARY KEY NOT NULL UNIQUE,
    Name VARCHAR(255) NOT NULL CHECK (Name <> ''),
    PhoneNumber BIGINT CHECK (PhoneNumber IS NULL OR LENGTH(CAST(PhoneNumber AS TEXT)) = 10),
    Email VARCHAR(255) NOT NULL UNIQUE CHECK (Email ~* '^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$'),
    Password VARCHAR(512) NOT NULL CHECK (LENGTH(Password) >= 8 AND Password ~* '[A-Z]' AND Password ~* '[0-9]'),
    Role VARCHAR(50) NOT NULL CHECK (Role IN ('admin', 'manager', 'member')),
    Credit FLOAT NOT NULL CHECK ((Role = 'manager' AND Credit = 2000) OR (Role <> 'manager' AND Credit = 0)),
    CreationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create MeetingRooms Table
CREATE TABLE MeetingRooms (
    RoomID SERIAL PRIMARY KEY NOT NULL UNIQUE,
    RoomType VARCHAR(255) NOT NULL CHECK (RoomType IN ('Classroom', 'Conference Call', 'Online Training', 'Business')),
    Address TEXT,
    AdminID INT NOT NULL REFERENCES Users(UserID) ON DELETE CASCADE,
    OpeningTime TIME NOT NULL,
    ClosingTime TIME NOT NULL,
    CreationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create BookedMeetings Table
CREATE TABLE BookedMeetings (
    MeetingID SERIAL PRIMARY KEY NOT NULL UNIQUE,
    ManagerID INT NOT NULL REFERENCES Users(UserID) ON DELETE CASCADE,
    RoomID INT NOT NULL REFERENCES MeetingRooms(RoomID) ON DELETE CASCADE,
    RoomCost INT NOT NULL CHECK (RoomCost > 0),
    Amentities TEXT[] NOT NULL CHECK (ARRAY_LENGTH(Amentities, 1) > 0),
    RoomType VARCHAR(255) NOT NULL,
    StartingTime TIME NOT NULL,
    EndingTime TIME NOT NULL,
    CreationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create MeetingRoomMembers Table
CREATE TABLE MeetingRoomMembers (
    ID SERIAL PRIMARY KEY NOT NULL UNIQUE,
    MeetingID INT NOT NULL REFERENCES BookedMeetings(MeetingID) ON DELETE CASCADE,
    UserID INT NOT NULL REFERENCES Users(UserID) ON DELETE CASCADE,
    CreationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
