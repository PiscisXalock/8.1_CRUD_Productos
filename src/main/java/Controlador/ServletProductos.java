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
            out.println("<h1>Registro insertado " + "<a href='index.jsp'>Volver</a></h1>");
        } else if(op.equals("borrar")){
            int id = Integer.parseInt(request.getParameter("id"));
            if(ProductosCRUD.destroyProducto(id) == 1){
                out.println("<h1>Registro borrado <a href='index.jsp'>Volver</a></h1>");
            }else{
                out.println("<h1>Registro no borrado <a href='listar.jsp'>Volver</a></h1>");
            }
            
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
