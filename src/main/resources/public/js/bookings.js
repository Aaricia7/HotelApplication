var table = $("#table").DataTable();

$("#linkAddBooking").click(function (e) {
    e.preventDefault();
    $("#bookingModal").modal("toggle");
    $("#btnUpdateBooking").hide();
    $("#btnAddBooking").show();
});

getAll();

function getAll() {
    $.get("/api/bookings/", function (result) {
        table.clear();
        for (var i = 0; i < result.length; i++) {
            table.row.add(["<a href=\"javascript:del(" + result[i].bookID + ")\"><i class='fa fa-trash-o' aria-hidden='true'></i></a>",
                            "<a href=\"javascript:edit("+result[i].bookID+")\">"+result[i].bookID+"</a>",
                            result[i].firstName,
                            result[i].lastName,
                            result[i].roomNumber,
                            (result[i].startDate[2]+"/"+result[i].startDate[1]+"/"+result[i].startDate[0]),
                            (result[i].stopDate[2]+"/"+result[i].stopDate[1]+"/"+result[i].stopDate[0]),
                            result[i].guestPaid]);
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
        getAll();
    });
});

function getObject() {
    var obj = {};
    obj.firstName = $("#firstName").val();
    obj.lastName =  $("#lastName").val();
    obj.roomNumber = $("#roomNumber").val();
    obj.startDate = $("#startDate").val();
    obj.stopDate = $("#stopDate").val();
    obj.guestPaid = $("#paid").val();
    obj.bookID = $("#id").val();
    return obj;
}

function del(id) {
    $.ajax({url: "/api/bookings/"+id+"/", type: "DELETE"}).done( function() {
    getAll();
    })
}

function edit(id) {
    $("#btnAddBooking").hide();
    $("#btnUpdateBooking").show();
    $.get({url:"/api/bookings/"+id+"/", type:"GET"}).done( function(result) {
        var paid = result.guestPaid;
        var start = result.startDate[2] + "/" + result.startDate[1] + "/" + result.startDate[0];
        $("#id").val(result.bookID);
        $("#firstName").val(result.firstName);
        $("#lastName").val(result.lastName);
        $("#roomNumber").val(result.roomNumber);
        $("#startDate").val(result.startDate);
        $("#stopDate").val(result.stopDate);
         $('#paid option:contains(' +  paid + ')').prop({selected: true});
        $("#bookingModal").modal("toggle");
    })
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
        getAll();
    })
})


