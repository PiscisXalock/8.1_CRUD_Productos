/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProductosCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.*;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ServletProductos extends HttpServlet {

    private int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");
        /* TODO output your page here. You may use following sample code. */
        //ProductosCRUD.destroyProducto(3);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ServletProductos</title>");
        out.println("</head>");
        out.println("<body>");
        //out.println("<h1>He comentado la línea que hace borrar el producto.</h1>");
        if (op.equals("listar")) {
            out.println("<h1>Listar</h1>");
            List<Productos> misProductos = ProductosCRUD.getProductos();
            request.setAttribute("misProductos", misProductos);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
            /*for (Productos p : misProductos) {
                out.println("Nombre ->" + p.getNombre() + "<br>");
                out.println("Categoría ->" + p.getCategoria() + "<br>");
                out.println("Precio ->" + p.getPrecio());
                out.println("<hr>");
            }*/
        } else if (op.equals("insert1")) {
            request.getRequestDispatcher("insert.jsp").forward(request, response);
        } else if (op.equals("insert2")) {
            Productos miProducto = new Productos();
            miProducto.setNombre(request.getParameter("nombre"));
            miProducto.setImagen(request.getParameter("imagen"));
            miProducto.setCategoria(request.getParameter("categoria"));
            miProducto.setPrecio(Float.parseFloat(request.getParameter("precio")));
            ProductosCRUD.insertarProducto(miProducto);
            request.setAttribute("info", "Producto insertado correctamente.");
            List<Productos> misProductos = ProductosCRUD.getProductos();
            request.setAttribute("misProductos", misProductos);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        } else if (op.equals("borrar")) {
            id = Integer.parseInt(request.getParameter("id"));
            if (ProductosCRUD.destroyProducto(id) == 1) {
                request.setAttribute("info", "Producto borrado correctamente.");
                List<Productos> misProductos = ProductosCRUD.getProductos();
                request.setAttribute("misProductos", misProductos);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
            } else {
                request.setAttribute("info", "El producto no se borro correctamente.");
                List<Productos> misProductos = ProductosCRUD.getProductos();
                request.setAttribute("misProductos", misProductos);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
            }

        } else if (op.equals("update1")) {
            id = Integer.parseInt(request.getParameter("id"));
            Productos miProducto = ProductosCRUD.getProducto(id);
            request.setAttribute("miProducto", miProducto);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } else if (op.equals("update2")) {
            id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String imagen = request.getParameter("imagen");
            String categoria = request.getParameter("categoria");
            Float precio = Float.parseFloat(request.getParameter("precio"));
            Productos miProducto = new Productos(id, nombre, imagen, categoria, precio);
            ProductosCRUD.insertarProducto(miProducto);
            request.setAttribute("info", "Producto actualizado correctamente.");
            List<Productos> misProductos = ProductosCRUD.getProductos();
            request.setAttribute("misProductos", misProductos);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
            /*int filas = ProductosCRUD.actualizaProducto(miProducto);
            request.setAttribute("miProducto", miProducto);
            request.getRequestDispatcher("listar.jsp").forward(request, response);*/
        }
        out.println("</body>");
        out.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
