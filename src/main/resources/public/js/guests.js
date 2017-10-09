var table = $("#table").DataTable();

$("#linkAddGuest").click(function (e) {
    e.preventDefault();
    $("#guestModal").modal("toggle");
    $("#btnUpdateGuest").hide();
    $("#btnAddGuest").show();
});

getAll();

function getAll() {
    $.get("/api/guests/", function (result) {
        table.clear();
        for (var i = 0; i < result.length; i++) {
            table.row.add(["<a href=\"javascript:del(" + result[i].guestID + ")\"><font color='#ff3385'><i class='fa fa-trash-o' aria-hidden='true'></i></font></a>",
                            "<a href=\"javascript:edit("+result[i].guestID+")\"><font color='#ff3385'><i class='fa fa-pencil' aria-hidden='true'></i></font></a>",
                            result[i].guestFirstName,
                            result[i].guestLastName,
                            result[i].guestPhonenumber,
                            result[i].guestEmailAdress,
                            result[i].guestAdress,
                            result[i].guestZipcode,
                            result[i].guestCity,
                            result[i].guestCountry]);
        }
        table.draw();
    });
}

$("#btnAddGuest").click(function (e) {
    var obj = getObject();
    $.ajax({
        url: "/api/guests/",
        type: "POST",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
    }).done(function () {
        $("#guestModal").modal("toggle");
        $("#guestModal input").val("");
        getAll();
    });
});

$("#btnUpdateGuest").click( function (e) {
    e.preventDefault();
    var obj = getObject();
    $.ajax({
        url: "/api/guests/",
        method:"PUT",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
        }).done(function () {
        $("#guestModal").modal("toggle");
        $("#guestModal input").val("");
        getAll();
    })
})

function del(id) {
    $.ajax({url: "/api/guests/"+id+"/", type: "DELETE"}).done( function() {
    getAll();
    })
}

function edit(id) {
    $("#btnAddGuest").hide();
    $("#btnUpdateGuest").show();
    $.get({url:"/api/guests/"+id+"/", type:"GET"}).done( function(result) {
        $("#id").val(result.guestID);
        $("#firstName").val(result.guestFirstName);
        $("#lastName").val(result.guestLastName);
        $("#phoneNumber").val(result.guestPhonenumber);
        $("#emailAddress").val(result.guestEmailAdress);
        $("#address").val(result.guestAdress);
        $("#zipCode").val(result.guestZipcode);
        $("#city").val(result.guestCity);
        $("#country").val(result.guestCountry);
        $("#guestModal").modal("toggle");
    })
}

function getObject() {
    var obj = {};
    obj.guestFirstName = $("#firstName").val();
    obj.guestLastName =  $("#lastName").val();
    obj.guestAdress = $("#address").val();
    obj.guestZipcode = $("#zipCode").val();
    obj.guestCity = $("#city").val();
    obj.guestCountry = $("#country").val();
    obj.guestPhonenumber = $("#phoneNumber").val();
    obj.guestEmailAdress = $("#emailAddress").val();
    obj.guestID = $("#id").val();
    return obj;
}

