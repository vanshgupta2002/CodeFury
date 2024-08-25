document.getElementById("bookingForm").addEventListener("submit", function (event) {
    event.preventDefault();
    let roomType = document.getElementById("roomType").value;
    let startTime = document.getElementById("startTime").value;
    let endTime = document.getElementById("endTime").value;
    let amenities = document.getElementById("amenities").value.split(",");
    let emailInvite = document.getElementById("emailInvite").value.split(",");

    // Simulate credit check and booking logic here
    alert(`Meeting Room Booked: ${roomType}\nStart: ${startTime}\nEnd: ${endTime}\nAmenities: ${amenities.join(", ")}\nInvited Members: ${emailInvite.join(", ")}`);

    // Redirect to manager home page after successful booking
    window.location.href = "manager_home.html";
});
