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


$("#btnAddRoom").click(function() {
    console.log("test");
    var obj = {};
    obj.roomID = $("#id").val();
    obj.roomSize = $("#roomSize").val();
    obj.roomType =  $("#roomType").val();
    obj.dateReady = $("#dateReady").val();
    obj.roomAvailable = $("#roomAvailable").val();
    obj.roomNumber = $("#roomNumber").val();

    console.log(obj);

    $.ajax({
        url: "/api/rooms/",
        type: "POST",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            console.log(result);
            return result;
        },
        error: function(err) {
            console.log(err.responseText);
        }
    });
    $("#roomModal").modal("hide");
});

