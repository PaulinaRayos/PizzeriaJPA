/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.Ingrediente;

/**
 *
 * @author pauli
 */
public class IngredienteDAO {

    private EntityManagerFactory entityManagerFactory;

    public IngredienteDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    
    
    public List<Ingrediente> obtenerIngredientesPorNombreConLetraA() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Ingrediente> ingredientes = null;

        try {
            // Consulta para obtener ingredientes cuyo nombre empiece o termine con 'A'
            String jpql = "SELECT i FROM Ingrediente i WHERE i.nombre LIKE :inicial OR i.nombre LIKE :final";
            TypedQuery<Ingrediente> query = em.createQuery(jpql, Ingrediente.class);
            query.setParameter("inicial", "A%"); // Nombre que empieza con 'A'
            query.setParameter("final", "%A"); // Nombre que termina con 'A'

            ingredientes = query.getResultList();
        } finally {
            em.close(); // Asegúrate de cerrar el EntityManager
        }

        return ingredientes;
    }
}
