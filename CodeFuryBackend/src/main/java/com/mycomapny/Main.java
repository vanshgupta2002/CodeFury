package com.mycomapny;



import com.mycomapny.business.*;
import com.mycomapny.services.MeetingRoomService;
import com.mycomapny.services.UserService;
import com.mycomapny.exceptions.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final UserService userService = new UserService();
    private static final MeetingRoomService meetingRoomService = new MeetingRoomService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add default users
        Admin admin = new Admin("Admin", "admin@example.com", "1234567890");
        Manager manager = new Manager("Manager", "manager@example.com", "0987654321");
        Member member = new Member("Member", "member@example.com", "1122334455");
        userService.addUser(admin);
        userService.addUser(manager);
        userService.addUser(member);

        int option;

        do {
            System.out.println("\n1. Login as Admin");
            System.out.println("2. Login as Manager");
            System.out.println("3. Login as Member");
            System.out.println("4. Exit");
            System.out.print("Enter option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    loginAsAdmin(scanner);
                    break;
                case 2:
                    loginAsManager(scanner);
                    break;
                case 3:
                    loginAsMember(scanner);
                    break;
                case 4:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }

    private static void loginAsAdmin(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        User user = null;
        try {
            user = userService.getUserByEmail(email);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        if (user instanceof Admin) {
            int adminOption;
            do {
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Create Meeting Room");
                System.out.println("2. View All Meeting Rooms");
                System.out.println("3. Logout");
                System.out.print("Enter option: ");
                adminOption = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (adminOption) {
                    case 1:
                        createMeetingRoom(scanner);
                        break;
                    case 2:
                        viewAllMeetingRooms();
                        break;
                    case 3:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (adminOption != 3);
        } else {
            System.out.println("Unauthorized access.");
        }
    }

    private static void createMeetingRoom(Scanner scanner) {
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        System.out.print("Enter seating capacity: ");
        int seatingCapacity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Select amenities (comma-separated):");
        System.out.println("1. PROJECTOR");
        System.out.println("2. WIFI_CONNECTION");
        System.out.println("3. CONFERENCE_CALL_FACILITY");
        System.out.println("4. WHITEBOARD");
        System.out.println("5. WATER_DISPENSER");
        System.out.println("6. TV");
        System.out.println("7. COFFEE_MACHINE");
        String[] amenitiesInput = scanner.nextLine().split(",");
        List<Amenity> amenities = Arrays.stream(amenitiesInput)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(i -> Amenity.values()[i - 1])
                .collect(Collectors.toList());

        System.out.println("Select Meeting Type:");
        System.out.println("1. CLASSROOM_TRAINING");
        System.out.println("2. ONLINE_TRAINING");
        System.out.println("3. CONFERENCE_CALL");
        System.out.println("4. BUSINESS");
        int meetingTypeChoice = scanner.nextInt();
        MeetingType meetingType = MeetingType.values()[meetingTypeChoice - 1];

        try {
            MeetingRoom room = new MeetingRoom(roomName, seatingCapacity, amenities);
            meetingRoomService.addMeetingRoom(room, meetingType);
            System.out.println("Meeting room created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewAllMeetingRooms() {
        List<MeetingRoom> rooms = meetingRoomService.getAllMeetingRooms();
        if (rooms.isEmpty()) {
            System.out.println("No meeting rooms available.");
        } else {
            rooms.forEach(room -> {
                System.out.println("Room Name: " + room.getRoomName());
                System.out.println("Seating Capacity: " + room.getSeatingCapacity());
                System.out.println("Amenities: " + room.getAmenities());
                System.out.println("Cost per hour: " + room.calculateCostPerHour() + " credits");
                System.out.println();
            });
        }
    }

    private static void loginAsManager(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        User user = null;
        try {
            user = userService.getUserByEmail(email);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        if (user instanceof Manager) {
            Manager manager = (Manager) user;
            int managerOption;
            do {
                System.out.println("\nManager Menu:");
                System.out.println("1. Book Meeting Room");
                System.out.println("2. View All Meeting Rooms");
                System.out.println("3. Logout");
                System.out.print("Enter option: ");
                managerOption = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (managerOption) {
                    case 1:
                        bookMeetingRoom(scanner, manager);
                        break;
                    case 2:
                        viewAllMeetingRooms();
                        break;
                    case 3:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (managerOption != 3);
        } else {
            System.out.println("Unauthorized access.");
        }
    }

    private static void bookMeetingRoom(Scanner scanner, Manager manager) {
        System.out.println("Available Meeting Rooms:");
        viewAllMeetingRooms();

        System.out.print("Enter room name to book: ");
        String roomName = scanner.nextLine();
        MeetingRoom room = meetingRoomService.getMeetingRoomByName(roomName);

        if (room != null) {
            int cost = room.calculateCostPerHour();
            System.out.print("Enter start time (yyyy-MM-ddTHH:mm): ");
            LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine());
            System.out.print("Enter end time (yyyy-MM-ddTHH:mm): ");
            LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine());

            System.out.println("Select Meeting Type:");
            System.out.println("1. CLASSROOM_TRAINING");
            System.out.println("2. ONLINE_TRAINING");
            System.out.println("3. CONFERENCE_CALL");
            System.out.println("4. BUSINESS");
            int meetingTypeChoice = scanner.nextInt();
            MeetingType meetingType = MeetingType.values()[meetingTypeChoice - 1];

            try {
                manager.deductCredits(cost);
                Meeting meeting = new Meeting(startTime, endTime, meetingType, manager);
                room.addMeeting(meeting);
                System.out.println("Room booked successfully. Remaining credits: " + manager.getCredits());
            } catch (InsufficientCreditsException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Room not found.");
        }
    }

    private static void loginAsMember(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        User user = null;
        try {
            user = userService.getUserByEmail(email);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        if (user instanceof Member) {
            Member member = (Member) user;
            int memberOption;
            do {
                System.out.println("\nMember Menu:");
                System.out.println("1. View Meeting Schedule");
                System.out.println("2. Logout");
                System.out.print("Enter option: ");
                memberOption = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (memberOption) {
                    case 1:
                        viewMeetingSchedule(member);
                        break;
                    case 2:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (memberOption != 2);
        } else {
            System.out.println("Unauthorized access.");
        }
    }

    private static void viewMeetingSchedule(Member member) {
        List<MeetingRoom> rooms = meetingRoomService.getAllMeetingRooms();
        boolean hasMeetings = false;

        for (MeetingRoom room : rooms) {
            for (Meeting meeting : room.getScheduledMeetings()) {
                if (meeting.getOrganizer().equals(member)) {
                    System.out.println("Room: " + room.getRoomName());
                    System.out.println("Meeting Details: " + meeting);
                    hasMeetings = true;
                }
            }
        }

        if (!hasMeetings) {
            System.out.println("No scheduled meetings found.");
        }
    }
}
