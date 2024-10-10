/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import dao.VentaDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.Venta;

/**
 *
 * @author pauli
 */
public class VentaDAOTest {
    public static void main(String[] args) {
        // Inicializar EntityManagerFactory y EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pizzeria");
        EntityManager em = emf.createEntityManager();
        VentaDAO ventaDAO = new VentaDAO(em);

        // Definir las fechas de inicio y fin
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaInicio = sdf.parse("2024-10-01");
            Date fechaFin = sdf.parse("2024-10-30");

            // Llama al método a probar
            List<Venta> ventas = ventaDAO.obtenerVentasEntreFechas(fechaInicio, fechaFin);

            // Comprobaciones
            // Imprimir la lista de ventas
            System.out.println("Ventas realizadas entre agosto y septiembre de 2024:");
            for (Venta venta : ventas) {
                System.out.println(venta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar EntityManager
            em.close();
            emf.close();
        }
    }
}
