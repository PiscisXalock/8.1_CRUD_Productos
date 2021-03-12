<%-- 
    Document   : listar
    Created on : 05-mar-2021, 20:53:26
    Author     : DAW-A
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            List<Productos> misProductos = (List<Productos>) request.getAttribute("misProductos");
        %>
        <h1>Listado de productos</h1>
        <hr>
        <button class="btn btn-info"><a style='text-decoration: none;' href="ServletProductos?op=insert1">Añadir producto</a></button>
        <hr>
        <table class="table table-dark">
            <tr>
                <th scope="col">id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Categoría</th>
                <th scope="col">Precio</th>
                <th scope="col">Imagen</th>
                <th scope="col">Borrar</th>
                <th scope="col">Actualizar</th>
            </tr>
                    <%
                        for (Productos p : misProductos) {
                            String cadenaBorrar = "<a onclick='return Confirmation()' href='ServletProductos?op=borrar&id=" + p.getId() + "'>Borrar</a>";
                            String cadenaActualizar = "<a href='ServletProductos?op=update1&id=" + p.getId() + "'>Actualizar</a>";
                    %>
            <tr>
                <td scope="row"><%= p.getId()%>.<hr></td>
                <td><%= p.getNombre()%>.<hr></td>
                <td><%= p.getCategoria()%>.<hr></td>
                <td><%= p.getPrecio()%> €<hr></td>
                <td><%= p.getImagen()%><hr></td>
                <td><%= cadenaBorrar%></td>
                <td><%= cadenaActualizar%></td>
            </tr>
            <%
                }
            %>
        </table>
        <% 
            String info = (String) request.getAttribute("info");
            if(info != null){
        %>
        <script>
            alert("<%= info %>");            
        </script>
        <%
                }
        %>
        <script>
            function Confirmation() {
                if (confirm('¿Está seguro de eliminar el regitro?') == true) {
                    return true;
                } else {
                    alert('Te arrepentiste we');
                    return false;
                }
            }
        </script>
    </body>
</html>
