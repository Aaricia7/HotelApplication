$("#linkAddGuest").click(function (e) {
    e.preventDefault();
    $("#guestModal").modal("toggle");
});

$("#btnAddGuest").click(function() {
    var obj = {};
    obj.guestFirstName = $("#firstName").val();
    obj.guestLastName =  $("#lastName").val();
    obj.guestAdress = $("#address").val();
    obj.guestZipcode = $("#zipCode").val();
    obj.guestCity = $("#city").val();
    obj.guestCountry = $("#country").val();
    obj.guestPhoneNumber = $("#phoneNumber").val();
    obj.guestEmailAdress = $("#emailAddress").val();
    obj.guestID = 1;
    console.log(obj);
    $.ajax({
        url: "/api/guest/add",
        type: "POST",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            console.log(result);
            return result;
        },
        error: function(err) {
            console.log(err);
        }
    });
    $("#guestModal").modal("hide");
});

