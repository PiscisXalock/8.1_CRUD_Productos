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
    </head>
    <body>
        <%
            List<Productos> misProductos = (List<Productos>) request.getAttribute("misProductos");
        %>
        <h1>Listado de productos</h1>
        <hr>
        <button style='background-color: white; border: 0.6px solid black'><a style='text-decoration: none; color: cornflowerblue' href="ServletProductos?op=insert1">Añadir producto</a></button>
        <hr>
        <table>
            <tr><th>id</th><th>Nombre</th><th>Categoría</th><th>Precio</th><th>Imagen</th><th>Borrar</th></tr>
                    <%
                        for (Productos p : misProductos) {
                            String cadenaBorrar = "<a onclick='return Confirmation()' href='ServletProductos?op=borrar&id=" + p.getId() + "'>Borrar</a>";
                    %>
            <tr>
                <td><%= p.getId()%>.<hr></td>
                <td><%= p.getNombre()%>.<hr></td>
                <td><%= p.getCategoria()%>.<hr></td>
                <td><%= p.getPrecio()%> €<hr></td>
                <td><%= p.getImagen()%><hr></td>
                <td style="color: red;"><%= cadenaBorrar%>.<hr></td>
            </tr>
            <%
                }
            %>
        </table>
        <script>
            function Confirmation() {
                if (confirm('¿Está seguro de eliminar el regitro?') == true) {
                    alert('El registro ha sido eliminado correctamente');
                    return true;
                } else {
                    alert('Te arrepentiste we');
                    return false;
                }
            }
        </script>
    </body>
</html>
