/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pizzeriajpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.Ingrediente;
import persistencia.Producto;
import persistencia.TipoIngrediente;
import persistencia.Venta;
import persistencia.ProductoVenta;
import java.sql.Timestamp;

/**
 *
 * @author pauli
 */
public class PizzeriaJPA {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pizzeria");
        EntityManager em = emf.createEntityManager();
        Producto pizza = em.find(Producto.class, 31L);
        Ingrediente i1 = em.find(Ingrediente.class, 32L);
        Ingrediente i2 = em.find(Ingrediente.class, 31L);

        //List<Producto>productos =new ArrayList();
        
        //productos.add(pizza);
        
        List<Ingrediente> ingredientes = new ArrayList();

        ingredientes.add(i1);
        ingredientes.add(i2);

        pizza.setIngredientes(ingredientes);
        em.getTransaction().begin();
        em.persist(pizza);
        em.getTransaction().commit();
        System.out.println("Operacion terminada");

        /*
        Producto pizza = em.find(Producto.class, 2L);
        if (pizza != null) {
            em.getTransaction().begin();//empieza transaccion
            em.remove(pizza);

            em.getTransaction().commit();
            System.out.println("Pizza eliminada");
        }
        //em.getTransaction().begin();//empieza transaccion
        //Producto pizzaPepperoni = new Producto((float) 99.9, "Pizza de anchoas", "pizza de miedo");
        //em.persist(pizzaPepperoni);//se guarda
        //em.getTransaction().commit();//se le da commit a la transaccion
        //System.out.println("Pizza guardada");


//07 de octubre:
        /*
          TipoIngrediente tipo = new TipoIngrediente("Refrigerados");
          List<Ingrediente> ingredientes = new ArrayList();
         
          ingredientes.add(new Ingrediente("Salami", 10, tipo));
         ingredientes.add(new Ingrediente("Queso mozzarella", 50, tipo));
         
          tipo.setIngredientes(ingredientes);
         
          em.getTransaction().begin(); em.persist(tipo);
          em.getTransaction().commit(); System.out.println("Operacion terminada"); 
         
        */

    }
}
