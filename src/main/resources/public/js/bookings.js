
$("#post").click( function() {
    var json = {};

    json.guestID = $("#guestID").val();
    json.roomID = $("#roomID").val();
    json.bookID = $("#bookID").val();
    json.startDate = $("#startDate").val();
    json.stopDate = $("#stopDate").val();
    json.guestPaid = $("#guestPaid").val();

    $.ajax({
        type: "POST",
        url: "/API/bookings/",
        data: JSON.stringify(json),
        contentType: "application/json; charset=utf-8",
        success: function(result) {

        }
    })
});