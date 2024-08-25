// Room form validation and dynamic interactions
const roomForm = document.querySelector('form');
if (roomForm) {
  roomForm.addEventListener('submit', function(event) {
    event.preventDefault();

    const roomType = document.getElementById('roomType').value;
    const openingTime = document.getElementById('openingTime').value;
    const closingTime = document.getElementById('closingTime').value;

    if (!roomType || !openingTime || !closingTime) {
      alert('Please fill in all required fields.');
      return;
    }

    alert('Room details saved successfully!');
    window.location.href = 'admin_home.html';
  });
}
