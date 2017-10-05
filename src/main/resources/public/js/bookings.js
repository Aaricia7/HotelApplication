var table = $("#table").DataTable();

$("#linkAddBooking").click(function (e) {
    e.preventDefault();
    $("#bookingModal").modal("toggle");
});

getAll();

function getAll() {
    $.get("/api/bookings/", function (result) {
        console.log(result);
        table.clear();
        for (var i = 0; i < result.length; i++) {
            table.row.add(["<a href=\"javascript:del(" + result[i].bookID + ")\"><i class='fa fa-trash-o' aria-hidden='true'></i></a>",
                            "<a href=\"javascript:edit("+result[i].bookID+")\">"+result[i].bookID+"</a>",
                            result[i].firstName,
                            result[i].lastName,
                            result[i].startDate,
                            result[i].stopDate,
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
    obj.startDate = $("#startDate").val();
    obj.stopDate = $("#stopDate").val();
    obj.guestPaid = $("#paid").val();
    obj.bookID = $("#id").val();
    return obj;
}

