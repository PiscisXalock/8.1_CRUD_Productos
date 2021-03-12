<%-- 
    Document   : update
    Created on : 08-mar-2021, 19:46:38
    Author     : Usuario
--%>

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
            Productos miProducto = (Productos) request.getAttribute("miProducto");
        %>
        <h1>Actualizar producto</h1>
        <div class="form-group">
            <form action="ServletProductos" method="get">
                <p><label>Nombre: <input class="form-control" value="<%= miProducto.getNombre()%>" type="text" name="nombre" required > </label></p>
                <p><label>Imagen: <input class="form-control" value="${miProducto.imagen}" type="text" name="imagen" required > </label></p>
                <p><label>Categoría: <input class="form-control" value="${ miProducto.categoria}" type="text" name="categoria" required > </label></p>
                <p><label>Precio: <input class="form-control" value="${miProducto.precio}" type="text" name="precio" required > </label></p>
                <input hidden type="number" name="id" required value="${miProducto.id}">
                <input hidden type="text" name="op" required value="update2">
                <input class="btn btn-primary" type="submit" value="insertar" >
            </form>
        </div>
    </body>
</html>
