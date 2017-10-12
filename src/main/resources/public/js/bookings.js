var table = $("#table").DataTable();

$("#linkAddBooking").click(function (e) {
    e.preventDefault();
    getOptionsRoom();
    $("#bookingModal").modal("toggle");
    $("#btnUpdateBooking").hide();
    $("#btnAddBooking").show();
    $("#titleAddBooking").show();
    $("#titleChangeBooking").hide();
});

getAll();

function getAll() {
    $.get("/api/bookings/", function (result) {
        table.clear();
        for (var i = 0; i < result.length; i++) {
            var paid = (result[i].guestPaid) ? "Betaald" : "Niet betaald";
            table.row.add(["<a href=\"javascript:del(" + result[i].bookID + ")\"><font color='#ff3385'><i class='fa fa-trash-o' aria-hidden='true'></i></font></a>",
                            "<a href=\"javascript:edit("+result[i].bookID+")\"><font color='#ff3385'><i class='fa fa-pencil' aria-hidden='true'></i></font></a>",
                            result[i].guest.guestFirstName,
                            result[i].guest.guestLastName,
                            result[i].room.roomNumber,
                            result[i].peopleBooking,
                            (result[i].startDate[2]+"/"+result[i].startDate[1]+"/"+result[i].startDate[0]),
                            (result[i].stopDate[2]+"/"+result[i].stopDate[1]+"/"+result[i].stopDate[0]),
                            paid,
                            result[i].checkIn]);
        }
        table.draw();
    });
}

$("#btnAddBooking").click(function (e) {
    var obj = getObject();
    $.ajax({
        url: "/api/bookings/",
        type: "POST",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
    }).done(function () {
        $("#bookingModal").modal("toggle");
        $("#bookingModal input").val("");
        $("#bookingModal date").val("");
        getAll();
    });
});

function getObject() {
    var obj = {};
    obj.guestID = $("#guestID").val();
    obj.roomID = $("#roomID").val();
    obj.startDate = $("#startDate").val();
    obj.stopDate = $("#stopDate").val();
    obj.peopleBooking = $("#peopleBooking").val();
    obj.guestPaid = ($("#paid").val()=="Betaald") ? true : false;
    obj.checkIn = $("#checkIn").val();
    obj.bookID = $("#id").val();
    return obj;
}

function del(id) {
    $.confirm({
        title: 'Verwijdering bevestigen',
        content: 'Weet u zeker dat u deze boeking wilt verwijderen?',
        buttons: {
            confirm: function () {
                $.ajax({url: "/api/bookings/"+id+"/", type: "DELETE"}).done( function() {
                    getAll();
                    })
                $.alert('Boeking is verwijderd');
            },
            cancel: function () {
            }
        }
    });

}

function edit(id) {
    getOptionsRoom();
    $("#btnAddBooking").hide();
    $("#btnUpdateBooking").show();
    $("#titleAddBooking").hide();
    $("#titleChangeBooking").show();
    $.get({url:"/api/bookings/"+id+"/", type:"GET"}).done( function(result) {
        var paid = result.guestPaid;
        var start = result.startDate[0] + "-" + result.startDate[1] + "-" + result.startDate[2];
        var stop = result.stopDate[0] + "-" + result.stopDate[1] + "-" + result.stopDate[2];
        $("#id").val(result.bookID);
        $("#guestID").val(result.guestID);
        $("roomID").val(result.roomID);
        $("#peopleBooking").val(result.peopleBooking);
        $("#startDate").val(start);
        $("#stopDate").val(stop);
        $('#paid option:contains(' +  paid + ')').prop({selected: true});
        $("#checkIn").val(result.checkIn);
        $("#bookingModal").modal("toggle");
    })
}

function getOptionsRoom(){
    $.get("/api/guests/", function (result) {
        table.clear();
        document.getElementById("guestID").options.length = 0;
        for (var i = 0; i< result.length; i++) {
            $("#guestID").append("<option value="+result[i].guestID+">"
            +result[i].guestFirstName+ " "
            +result[i].guestLastName+", "
            +result[i].guestAdress+", "
            +result[i].guestCity+"</option>");
    }})
    $.get("/api/rooms/", function (result) {
        table.clear();
        document.getElementById("roomID").options.length = 0;
        for (var i = 0; i < result.length; i++) {
           $("#roomID").append("<option value="+result[i].roomID+">"
           +result[i].roomNumber+ ", "
           +result[i].roomSize+ ", "
           +result[i].roomType+"</option>");
           }
        }
    );
}

$("#btnUpdateBooking").click( function (e) {
    e.preventDefault();
    var obj = getObject();
    $.ajax({
        url: "/api/bookings/",
        method:"PUT",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
        }).done(function () {
        $("#bookingModal").modal("toggle");
        $("#bookingModal input").val("");
        $("#bookingModal date").val("");
        getAll();
    })
})


