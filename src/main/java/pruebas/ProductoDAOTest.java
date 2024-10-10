/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import dao.ProductoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.Producto;

/**
 *
 * @author pauli
 */
public class ProductoDAOTest {
    public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pizzeria");
        EntityManager em = emf.createEntityManager();
    ProductoDAO productoDAO;

    
    
        // Inicializar EntityManagerFactory y ProductoDAO
        
        productoDAO = new ProductoDAO(emf);
    



        // Llama al método a probar
        List<Producto> productos = productoDAO.obtenerProductosConPrecioMayorA250();

        // Comprobaciones
        // Imprimir la lista de productos
        System.out.println("Productos con precio mayor a 250:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}