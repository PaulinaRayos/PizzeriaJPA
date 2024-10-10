/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import dao.IngredienteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.Ingrediente;

/**
 *
 * @author pauli
 */
public class IngredienteDAOTest {
     public static void main(String[] args) {
        // Inicializar EntityManagerFactory y EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pizzeria");
        EntityManager em = emf.createEntityManager();
        IngredienteDAO ingredienteDAO;

        // Inicializar IngredienteDAO
        ingredienteDAO = new IngredienteDAO(emf);

        // Llama al método a probar
        List<Ingrediente> ingredientes = ingredienteDAO.obtenerIngredientesPorNombreConLetraA();

        // Comprobaciones
        // Imprimir la lista de ingredientes
        System.out.println("Ingredientes cuyo nombre inicia o termina con 'A':");
        for (Ingrediente ingrediente : ingredientes) {
            System.out.println(ingrediente);
        }

        // Cerrar EntityManager
        em.close();
        emf.close();
    }
}
