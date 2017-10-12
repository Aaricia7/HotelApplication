var table = $("#table").DataTable();

$("#linkAddRoom").click(function (e) {
    e.preventDefault();
    $("#roomModal").modal("toggle");
    $("#btnUpdateRoom").hide();
    $("#btnAddRoom").show();
    $("#titleAddRoom").show();
    $("#titleChangeRoom").hide();
});

getAll();

function getAll() {
    $.get("/api/rooms/", function (result) {
        table.clear();
        for (var i = 0; i < result.length; i++) {
            var available = (result[i].roomAvailable) ? "Ja" : "Nee";
            table.row.add(["<a href=\"javascript:del(" + result[i].roomID + ")\"><font color='#ff3385'><i class='fa fa-trash-o' aria-hidden='true'></i></font></a>",
                            "<a href=\"javascript:edit("+result[i].roomID+")\"><font color='#ff3385'><i class='fa fa-pencil' aria-hidden='true'></i></font></a>",
                            result[i].roomSize.toLowerCase().replace(/\_/g, ' '),
                            result[i].roomType.toLowerCase(),
                            result[i].roomNumber,
                            available,
                            (result[i].dateReady[2]+"/"+result[i].dateReady[1]+"/"+result[i].dateReady[0])]);
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
        method:"POST",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
        }).done(function () {
        $("#roomModal").modal("toggle");
        $("#roomModal input").val("");
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
        $("#roomModal input").val("");
        getAll();
    })
})

function del(id) {
    $.confirm({
        title: 'Verwijdering bevestigen',
        content: 'Weet u zeker dat u deze kamer wilt verwijderen?',
        buttons: {
            confirm: function () {
                 $.ajax({url: "/api/rooms/"+id+"/", type: "DELETE"}).done( function() {
                 getAll();
                 })
                $.alert('Kamer is verwijderd');
            },
            cancel: function () {
            }
        }
    });
}

function edit(id) {
    $("#btnAddRoom").hide();
    $("#btnUpdateRoom").show();
    $("#titleAddRoom").hide();
    $("#titleChangeRoom").show();
    $.get({url:"/api/rooms/"+id+"/", type:"GET"}).done( function(result) {
        var available = result.roomAvailable;
        var date = result.dateReady[0]+"-"+result.dateReady[1]+"-"+result.dateReady[2];
        $("#id").val(result.roomID);
        $("#roomSize").val(result.roomSize);
        $("#roomType").val(result.roomType);
        document.getElementById("dateReady").value = date;
        $("#roomNumber").val(result.roomNumber);
        $('#roomAvailable option:contains(' +  available + ')').prop({selected: true});
        $("#roomModal").modal("toggle");
    })
}

function getObject() {
    var obj = {};
    obj.roomSize = $("#roomSize").val();
    obj.roomType =  $("#roomType").val();
    console.debug(obj.roomSize);
    obj.dateReady = $("#dateReady").val();
    obj.roomAvailable = $("#roomAvailable").val();;
    obj.roomNumber = $("#roomNumber").val();
    obj.roomID = $("#id").val();
    return obj;
}

