/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductosCRUD {

    public static int destroyProducto(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_8.1_CRUD_Productos_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Productos p WHERE p.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();
        return filasAfectadas;
    }
    
    public static int actualizarProductoTest(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_8.1_CRUD_Productos_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.categoria = 'zumos' WHERE p.id = 13";
        Query q = manager.createQuery(sql,Productos.class);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;
    }
    
    public static List<Productos> getProductos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_8.1_CRUD_Productos_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM productos";
        Query q = manager.createNativeQuery(sql,Productos.class); //Método para consultas SQL
        List<Productos> productosBD = q.getResultList();
        return productosBD;
    }
    
    public static int actualizarProducto(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_8.1_CRUD_Productos_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.nombre = :nombre, p.imagen = :imagen, p.categoria = :categoria, p.precio = :precio, WHERE p.id = 10";
        Query q = manager.createQuery(sql,Productos.class);
        q.setParameter("categoria", "Digestivos");
        q.setParameter("nombre", "Pacharán");
        q.setParameter("imagen", "pacharan.jpg");
        q.setParameter("precio", "4.0");
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        // manager.close();
        return filasAfectadas;
    }
    
    public static int actualizaProducto(Productos miProducto){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_8.1_CRUD_Productos_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.nombre = :nombre, p.imagen = :imagen, p.categoria = :categoria, p.precio = :precio, p.id = :id WHERE p.id = 10";
        Query q = manager.createQuery(sql,Productos.class);
        q.setParameter("id", miProducto.getId());
        q.setParameter("categoria", miProducto.getCategoria());
        q.setParameter("nombre", miProducto.getNombre());
        q.setParameter("imagen", miProducto.getImagen());
        q.setParameter("precio", miProducto.getPrecio());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        // manager.close();
        return filasAfectadas;
    }
    
    public static void insertaProducto(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_8.1_CRUD_Productos_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Productos producto = new Productos();
        producto.setNombre("Espinacas");
        producto.setPrecio(10);
        producto.setImagen("espinacas.jpg");
        producto.setCategoria("complementos");
        manager.merge(producto);
        manager.getTransaction().commit();
    }

}
