/*
 * 
 * 
 * 
 */

function ajaxCallSync(controlador,objeto,operacion,metodo, datatype) {
    var jsonOb;
    $.ajax({
        url: controlador + "?ob=" + objeto + "&op=" + operacion,
        type: metodo,
        dataType: datatype,
        success: function (json) {                        
            jsonOb = json;
            return jsonOb;
        },
        error: function (dato) {
            console.log("ERROR en la recepción de datos de clientes: "+dato);
        }
    });
    return jsonOb;
}

function trataClick() {
    
    var controlador= "control";
    var objeto = "table";
    var operacion = "get";
    var datatype="json";
    $.ajax({
        url: controlador + "?ob=" + objeto + "&op=" + operacion,
        type: "GET",
        dataType: datatype,
        success: function (json) { 
            
            var strRender = "<"+json.message.tag+" class=\""+json.message.clase+"\">";
            strRender += "<tr>";
            $.each(json.message.cabecera, function(index,valor){
                strRender +="<"+valor.tag+" id=\""+valor.id+"\" >"+valor.content+"</"+valor.tag+">";  
            });    
            strRender += "</tr>";
            
            $.each(json.message.cuerpo, function(index,valor) {
                strRender += "<tr>";
                $.each(valor, function(index,valor) {
                    strRender+="<"+valor.tag+" id=\""+valor.id+"\">"+valor.content+"</"+valor.tag+">";
                });
                strRender += "</tr>";
            });
             
             strRender += "</"+json.message.tag+">";
             
            var jsonStr = JSON.stringify(json); 
            $("#paneljson").empty().html(jsonStr);
            $("#panelhtml").empty().text(strRender);
            $("#panelrender").empty().append(strRender);
            
            $("#panelrender td").click(function () {
                $("#paneldetalle").empty().append("<h3>"+this.innerHTML+"</h3>");
            });
            
        },
        error: function (dato) {
            console.log("ERROR en la recepción de datos de clientes: "+dato);
        }
    });
    
    
}

$("#inicio01").click(trataClick);








