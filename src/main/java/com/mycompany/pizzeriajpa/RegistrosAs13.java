/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzeriajpa;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.Empleado;
import persistencia.Ingrediente;
import persistencia.Producto;
import persistencia.ProductoVenta;
import persistencia.TipoIngrediente;
import persistencia.Venta;

/**
 *
 * @author pauli Asignacion 13
 */
public class RegistrosAs13 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pizzeria");
        EntityManager em = emf.createEntityManager();
        
        // Crear 5 empleados
        List<Empleado> empleados = new ArrayList<>();
        
        empleados.add(new Empleado("Juan", "Pérez", "García", new Date(90, 1, 1), 
                                    new Timestamp(System.currentTimeMillis()), "Gerente", "1234567890"));
        empleados.add(new Empleado("Ana", "López", "Martínez", new Date(92, 3, 15), 
                                    new Timestamp(System.currentTimeMillis()), "Cajera", "0987654321"));
        empleados.add(new Empleado("Carlos", "Hernández", "Ramírez", new Date(85, 5, 20), 
                                    new Timestamp(System.currentTimeMillis()), "Cocinero", "2345678901"));
        empleados.add(new Empleado("María", "González", "Jiménez", new Date(88, 7, 30), 
                                    new Timestamp(System.currentTimeMillis()), "Mesero", "3456789012"));
        empleados.add(new Empleado("Luis", "Torres", "Mendoza", new Date(95, 9, 10), 
                                    new Timestamp(System.currentTimeMillis()), "Repartidor", "4567890123"));

        // Persistir empleados
        for (Empleado empleado : empleados) {
            em.persist(empleado);
        }
        
        
        
        

        // Crear 5 tipos de ingredientes
        TipoIngrediente tipo1 = new TipoIngrediente("Refrigerados");
        TipoIngrediente tipo2 = new TipoIngrediente("Secos");
        TipoIngrediente tipo3 = new TipoIngrediente("Enlatados");
        TipoIngrediente tipo4 = new TipoIngrediente("Frescos");
        TipoIngrediente tipo5 = new TipoIngrediente("Congelados");

        // Persistir los tipos de ingredientes
        em.persist(tipo1);
        em.persist(tipo2);
        em.persist(tipo3);
        em.persist(tipo4);
        em.persist(tipo5);

        // Crear listas para los ingredientes
        List<Ingrediente> ingredientesTipo1 = new ArrayList<>();
        List<Ingrediente> ingredientesTipo2 = new ArrayList<>();
        List<Ingrediente> ingredientesTipo3 = new ArrayList<>();
        List<Ingrediente> ingredientesTipo4 = new ArrayList<>();
        List<Ingrediente> ingredientesTipo5 = new ArrayList<>();

        // Crear 5 ingredientes para cada tipo
        ingredientesTipo1.add(new Ingrediente("Salami", 10, tipo1));
        ingredientesTipo1.add(new Ingrediente("Queso mozzarella", 50, tipo1));
        ingredientesTipo1.add(new Ingrediente("Jamon", 25, tipo1));
        ingredientesTipo1.add(new Ingrediente("Pepperoni", 30, tipo1));
        ingredientesTipo1.add(new Ingrediente("Mortadela", 15, tipo1));

        ingredientesTipo2.add(new Ingrediente("Pasta", 5, tipo2));
        ingredientesTipo2.add(new Ingrediente("Arroz", 3, tipo2));
        ingredientesTipo2.add(new Ingrediente("Frijoles", 2, tipo2));
        ingredientesTipo2.add(new Ingrediente("Harina", 1, tipo2));
        ingredientesTipo2.add(new Ingrediente("Azucar", 4, tipo2));

        ingredientesTipo3.add(new Ingrediente("Atun", 20, tipo3));
        ingredientesTipo3.add(new Ingrediente("Sopa", 12, tipo3));
        ingredientesTipo3.add(new Ingrediente("Guiso", 15, tipo3));
        ingredientesTipo3.add(new Ingrediente("Chiles", 8, tipo3));
        ingredientesTipo3.add(new Ingrediente("Verduras", 5, tipo3));

        ingredientesTipo4.add(new Ingrediente("Tomate", 30, tipo4));
        ingredientesTipo4.add(new Ingrediente("Lechuga", 20, tipo4));
        ingredientesTipo4.add(new Ingrediente("Cebolla", 15, tipo4));
        ingredientesTipo4.add(new Ingrediente("Pepino", 12, tipo4));
        ingredientesTipo4.add(new Ingrediente("Zanahoria", 10, tipo4));

        ingredientesTipo5.add(new Ingrediente("Pescado", 40, tipo5));
        ingredientesTipo5.add(new Ingrediente("Pollo", 35, tipo5));
        ingredientesTipo5.add(new Ingrediente("Carne", 50, tipo5));
        ingredientesTipo5.add(new Ingrediente("Camarones", 60, tipo5));
        ingredientesTipo5.add(new Ingrediente("Verduras congeladas", 25, tipo5));

        // Asociar ingredientes a cada tipo
        tipo1.setIngredientes(ingredientesTipo1);
        tipo2.setIngredientes(ingredientesTipo2);
        tipo3.setIngredientes(ingredientesTipo3);
        tipo4.setIngredientes(ingredientesTipo4);
        tipo5.setIngredientes(ingredientesTipo5);

        // Persistir los ingredientes
        for (Ingrediente ingrediente : ingredientesTipo1) {
            em.persist(ingrediente);
        }
        for (Ingrediente ingrediente : ingredientesTipo2) {
            em.persist(ingrediente);
        }
        for (Ingrediente ingrediente : ingredientesTipo3) {
            em.persist(ingrediente);
        }
        for (Ingrediente ingrediente : ingredientesTipo4) {
            em.persist(ingrediente);
        }
        for (Ingrediente ingrediente : ingredientesTipo5) {
            em.persist(ingrediente);
        }





        //Crear 5 productos 
        Producto pizza1 = new Producto((long) 99.99, "Pizza Clasica", "Pizza de queso y tomate");
        Producto pizza2 = new Producto((long) 149.99, "Pizza Pepperoni", "Pizza con rodajas de pepperoni");
        Producto pizza3 = new Producto((long) 139.99, "Pizza Carnes Frias", "Pizza con carne, chilorio, jamón y tocino");
        Producto pizza4 = new Producto((long) 299.99, "Pizza Hawaina", "Pizza con pina");
        Producto pizza5 = new Producto((long) 269.99, "Pizza Suprema", "Pizza con todo");

        // Crear 5 ventas 
        Venta venta1 = new Venta();
        venta1.setFecha(new Timestamp(System.currentTimeMillis())); // Asignar la fecha actual
        venta1.setTotal((long) 0.0); // Inicializar total

        Venta venta2 = new Venta();
        venta2.setFecha(new Timestamp(System.currentTimeMillis())); // Asignar la fecha actual
        venta2.setTotal((long) 0.0); // Inicializar total

        Venta venta3 = new Venta();
        venta3.setFecha(new Timestamp(System.currentTimeMillis())); // Asignar la fecha actual
        venta3.setTotal((long) 0.0); // Inicializar total

        Venta venta4 = new Venta();
        venta4.setFecha(new Timestamp(System.currentTimeMillis())); // Asignar la fecha actual
        venta4.setTotal((long) 0.0); // Inicializar total

        Venta venta5 = new Venta();
        venta5.setFecha(new Timestamp(System.currentTimeMillis())); // Asignar la fecha actual
        venta5.setTotal((long) 0.0); // Inicializar total

        // Crear productos de venta (relación intermedia) 
        ProductoVenta pv1 = new ProductoVenta();
        pv1.setProducto(pizza1);
        pv1.setVenta(venta1);
        pv1.setCantidad(2);
        pv1.setPrecio(pizza1.getPrecio());
        pv1.setSubtotal(pv1.getPrecio() * pv1.getCantidad()); // Calcular subtotal

        ProductoVenta pv2 = new ProductoVenta();
        pv2.setProducto(pizza2);
        pv2.setVenta(venta2);
        pv2.setCantidad(1);
        pv2.setPrecio(pizza2.getPrecio());
        pv2.setSubtotal(pv2.getPrecio() * pv2.getCantidad()); // Calcular subtotal

        ProductoVenta pv3 = new ProductoVenta();
        pv3.setProducto(pizza3);
        pv3.setVenta(venta3);
        pv3.setCantidad(1);
        pv3.setPrecio(pizza3.getPrecio());
        pv3.setSubtotal(pv3.getPrecio() * pv3.getCantidad()); // Calcular subtotal

        ProductoVenta pv4 = new ProductoVenta();
        pv4.setProducto(pizza4);
        pv4.setVenta(venta4);
        pv4.setCantidad(1);
        pv4.setPrecio(pizza4.getPrecio());
        pv4.setSubtotal(pv4.getPrecio() * pv4.getCantidad()); // Calcular subtotal

        ProductoVenta pv5 = new ProductoVenta();
        pv5.setProducto(pizza5);
        pv5.setVenta(venta5);
        pv5.setCantidad(3);
        pv5.setPrecio(pizza5.getPrecio());
        pv5.setSubtotal(pv5.getPrecio() * pv5.getCantidad()); // Calcular subtotal

        // Asociar cada producto de venta a su respectiva venta
        List<ProductoVenta> productosVenta1 = new ArrayList<>();
        productosVenta1.add(pv1);
        venta1.setProductosVendidos(productosVenta1);
        venta1.setTotal(pv1.getSubtotal()); // Calcular el total para la venta1

        List<ProductoVenta> productosVenta2 = new ArrayList<>();
        productosVenta2.add(pv2);
        venta2.setProductosVendidos(productosVenta2);
        venta2.setTotal(pv2.getSubtotal()); // Calcular el total para la venta2

        List<ProductoVenta> productosVenta3 = new ArrayList<>();
        productosVenta3.add(pv3);
        venta3.setProductosVendidos(productosVenta3);
        venta3.setTotal(pv3.getSubtotal()); // Calcular el total para la venta3

        List<ProductoVenta> productosVenta4 = new ArrayList<>();
        productosVenta4.add(pv4);
        venta4.setProductosVendidos(productosVenta4);
        venta4.setTotal(pv4.getSubtotal()); // Calcular el total para la venta4

        List<ProductoVenta> productosVenta5 = new ArrayList<>();
        productosVenta5.add(pv5);
        venta5.setProductosVendidos(productosVenta5);
        venta5.setTotal(pv5.getSubtotal()); // Calcular el total para la venta5

        // Iniciar la transacción
        em.getTransaction().begin();

        // Persistir los productos
        em.persist(pizza1);
        em.persist(pizza2);
        em.persist(pizza3);
        em.persist(pizza4);
        em.persist(pizza5);

        // Persistir las ventas
        em.persist(venta1);
        em.persist(venta2);
        em.persist(venta3);
        em.persist(venta4);
        em.persist(venta5);

        // Persistir productos de venta
        em.persist(pv1);
        em.persist(pv2);
        em.persist(pv3);
        em.persist(pv4);
        em.persist(pv5);

        // Confirmar la transacción
        em.getTransaction().commit();

        System.out.println("Operación completada con éxito");

        // Cerrar el EntityManager
        em.close();
        emf.close();
    }
}
