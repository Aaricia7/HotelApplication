
$("#post").click( function() {
    var json = {};

    json.streetName = $("#street").val();
    json.houseNumber = $("#housenumber").val();
    json.city = $("#city").val();
    json.companyName = $("#company").val();

    $.ajax({
        type: "POST",
        url: "API/bookings",
        data: JSON.stringify(json),
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            $("#output").html(result.companyName + "," + " " + result.streetName + " " + result.houseNumber + ", " + "" + result.city );
        }
    })
});