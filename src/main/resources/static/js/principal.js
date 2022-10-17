//*Principal*//

function traerInformacion0(){
    $.ajax({
        url: "http://localhost:8080/api/Cabin/all",
        type: "GET",
        dataType: "json",
        success: function (respuesta0){
            pintarRespuesta0(respuesta0);
        },
        error: function (respuesta0, xhr){
            alert("Error de peticion!");
        }
    });
}

function pintarRespuesta0(items){

    let myTable="<table>";
    myTable += "<thead>";
    myTable += "<tr>";
    myTable += "<th>id</th>"
    myTable += "<th>name</th>"
    myTable += "<th>brand</th>"
    myTable += "<th>rooms</th>"
    myTable += "<th>description</th>"
    myTable += "</tr>"
    myTable += "</thead>"
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].brand+"</td>";
        myTable+="<td>"+items[i].rooms+"</td>";
        myTable+="<td>"+items[i].description+"</td>";
        myTable+="<td> <button onclick='borrarElemento0("+items[i].id+")'>ELIMINAR</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado0").empty();
    $("#resultado0").append(myTable);
}

function guardarInformacion0(){
    let myData={
        id:$("#id").val(),
        name:$("#name").val(),
        brand:$("#brand").val(),
        rooms:$("#rooms").val(),
        description:$("#description").val(),
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:8080/api/Cabin/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta0){
            $("#resultado0").empty();
            $("#id").val("");
            $("#name").val("");
            $("#brand").val("");
            $("#rooms").val("");
            $("#description").val("");
            traerInformacion0();
            alert("se ha guardado el dato")
        }
    });
}

function editarInformacion0(){
    let myData={
        id:$("#id").val(),
        name:$("#name").val(),
        brand:$("#brand").val(),
        rooms:$("#rooms").val(),
        description:$("#description").val(),
    };
    let dataToSend=JSON.stringify(myData);
    console.log(myData)
    $.ajax({
        url:"http://localhost:8080/api/Cabin/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta0){
            $("#resultado0").empty();
            $("#id").val("");
            $("#name").val("");
            $("#brand").val("");
            $("#rooms").val("");
            $("#description").val("");
            traerInformacion0();
            alert("se ha actualizado")
        }
    });
}

function borrarElemento0(idElemento){
    let myData={
        id:idElemento,
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:8080/api/Cabin/"+idElemento,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        dataType:"JSON",
        success:function(respuesta0){
            $("#resultado0").empty();
            traerInformacion0();
            alert("se ha eliminado")
        }
    });
}