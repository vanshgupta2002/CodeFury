document.getElementById("bookRoomBtn").addEventListener("click", function () {
    window.location.href = "book_meeting.html"; // Redirect to booking page
});

// Simulate fetching booking data
let bookings = [
    { room: "Conference Room 1", time: "10:00 AM - 11:00 AM", date: "2024-08-19" },
    { room: "Training Room", time: "1:00 PM - 2:00 PM", date: "2024-08-20" }
];

let bookingList = document.getElementById("bookingList");

bookings.forEach(booking => {
    let li = document.createElement("li");
    li.classList.add("list-group-item");
    li.textContent = `${booking.room} | ${booking.date} | ${booking.time}`;
    bookingList.appendChild(li);
});
