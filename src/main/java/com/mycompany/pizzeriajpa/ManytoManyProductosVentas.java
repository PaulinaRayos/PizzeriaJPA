/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzeriajpa;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.Producto;
import persistencia.ProductoVenta;
import persistencia.Venta;

/**
 *
 * @author pauli
 */
public class ManytoManyProductosVentas {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pizzeria");
        EntityManager em = emf.createEntityManager();

        //Asignación M:N
        //Prueba para ProductoVenta:
        // Crear productos
        Producto pizza1 = new Producto((long) 99.99f, "Pizza Margarita", "Deliciosa pizza de queso y tomate");
        Producto pizza2 = new Producto((long) 109.99f, "Pizza Pepperoni", "Pizza con rodajas de pepperoni");

        // Crear una venta
        Venta venta = new Venta();
        venta.setFecha(new Timestamp(System.currentTimeMillis())); // Asignar la fecha actual
        venta.setTotal((long) 0.0); // Inicializar total

        // Crear productos de venta (relación intermedia)
        ProductoVenta pv1 = new ProductoVenta();
        pv1.setProducto(pizza1);
        pv1.setVenta(venta);
        pv1.setCantidad(2);
        pv1.setPrecio(pizza1.getPrecio());
        pv1.setSubtotal(pv1.getPrecio() * pv1.getCantidad()); // Calcular subtotal

        ProductoVenta pv2 = new ProductoVenta();
        pv2.setProducto(pizza2);
        pv2.setVenta(venta);
        pv2.setCantidad(1);
        pv2.setPrecio(pizza2.getPrecio());
        pv2.setSubtotal(pv2.getPrecio() * pv2.getCantidad()); // Calcular subtotal

        // Asociar productos de venta a la venta
        List<ProductoVenta> productosVendidos = new ArrayList<>();
        productosVendidos.add(pv1);
        productosVendidos.add(pv2);

        // Asignar productos vendidos a la venta
        venta.setProductosVendidos(productosVendidos);

        // Calcular el total de la venta
        for (ProductoVenta pv : productosVendidos) {
            venta.setTotal(venta.getTotal() + pv.getSubtotal());
        }

        // Iniciar la transacción
        em.getTransaction().begin();

        // Persistir los productos y la venta
        em.persist(pizza1);
        em.persist(pizza2);
        em.persist(venta);

        // Persistir productos de venta
        for (ProductoVenta pv : productosVendidos) {
            em.persist(pv);
        }

        em.getTransaction().commit();
        System.out.println("Operación de venta completada con éxito");

    }
}
