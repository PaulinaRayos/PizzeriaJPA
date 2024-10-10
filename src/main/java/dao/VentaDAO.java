/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.Venta;

/**
 *
 * @author pauli
 */
public class VentaDAO {

    private EntityManagerFactory entityManagerFactory;

    public VentaDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager entityManager;

    public VentaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Venta> obtenerVentasEntreFechas(Date fechaInicio, Date fechaFin) {
        // JPQL query to find sales between the specified dates
        String jpql = "SELECT v FROM Venta v WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin";
        TypedQuery<Venta> query = entityManager.createQuery(jpql, Venta.class);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);

        return query.getResultList();
    }
}
