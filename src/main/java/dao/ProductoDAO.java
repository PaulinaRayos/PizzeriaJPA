/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.*;

import persistencia.Producto;


/**
 *
 * @author pauli
 */
public class ProductoDAO {

    private EntityManagerFactory entityManagerFactory;

    public ProductoDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

   // Método para obtener productos con precio mayor a 250
    public List<Producto> obtenerProductosConPrecioMayorA250() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Producto> productos;

        try {
            // Creación de la consulta JPQL
            String jpql = "SELECT p FROM Producto p WHERE p.precio > :precio";
            TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
            query.setParameter("precio", 250);
            
            // Ejecución de la consulta
            productos = query.getResultList();
        } finally {
            em.close();
        }

        return productos;
    }
}