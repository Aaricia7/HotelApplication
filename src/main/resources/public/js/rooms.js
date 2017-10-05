var table = $("#table").DataTable();

$("#linkAddRoom").click(function (e) {
    e.preventDefault();
    $("#roomModal").modal("toggle");
});

getAll();

function getAll() {
    $.get("/api/rooms/", function (result) {
        console.log(result);
        table.clear();
        for (var i = 0; i < result.length; i++) {
            table.row.add(["<a href=\"javascript:del(" + result[i].roomID + ")\"><i class='fa fa-trash-o' aria-hidden='true'></i></a>",
                            "<a href=\"javascript:edit("+result[i].roomID+")\">"+result[i].roomID+"</a>",
                            result[i].roomSize,
                            result[i].roomType,
                            result[i].roomNumber,
                            result[i].dateReady]);
        }
        table.draw();
    });
}

$("#btnClose").click(function() {
 $("#roomModal").modal("hide");
});


$("#btnAddRoom").click( function (e) {
    e.preventDefault();
    var obj = getObject();
    $.ajax({
        url: "/api/rooms/",
        method:"PUT",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
        }).done(function () {
        $("#roomModal").modal("toggle");
        getAll();
    })
})

$("#btnUpdateRoom").click( function (e) {
    e.preventDefault();
    var obj = getObject();
    $.ajax({
        url: "/api/rooms/",
        method:"PUT",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
        }).done(function () {
        $("#roomModal").modal("toggle");
        getAll();
    })
})

function del(id) {
    $.ajax({url: "/api/rooms/"+id+"/", type: "DELETE"}).done( function() {
    getAll();
    })
}

function edit(id) {
    $.get({url:"/api/rooms/"+id+"/", type:"GET"}).done( function(result) {
        $("#id").val(result.guestID);
        $("#roomSize").val(result.roomSize);
        $("#roomType").val(result.roomType);
        $("#dateReady").val(result.dateReady);
        $("#roomAvailable").val(result.roomAvailable);
        $("#roomNumber").val(result.roomNumber);
    })
}

function getObject() {
    var obj = {};
    obj.roomSize = $("#roomSize").val();
    obj.roomType =  $("#roomType").val();
    obj.dateReady = $("#dateReady").val();
    obj.roomAvailable = $("#roomAvailable").val();
    obj.roomNumber = $("#roomNumber").val();
    return obj;
}

