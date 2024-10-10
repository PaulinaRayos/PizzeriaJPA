/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Timestamp;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author pauli
 */
@Entity
@Table(name = "ventas")//nombre de la tabla en base de datos
public class Venta implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//cambiamos auto a identity
    
    
    
    @Column(name = "id_venta")//nombre del id en base de datos
    private Long id;


    @Temporal(TemporalType.TIMESTAMP)
     private Date fecha; //columna fecha

    
    private long total; //columna total

    @ManyToOne // Relación Venta N:1 Empleado
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado; //columna id_empleado

    
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)// Relación con ProductoVenta
    private List<ProductoVenta> productosVendidos;

    public Venta() {//constructor vacio
    }

    public Venta(Timestamp fecha, long total, Integer idEmpleado, List<ProductoVenta> productosVendidos) {//constructor sin id
        this.fecha = fecha;
        this.total = total;
        this.empleado = empleado;
        this.productosVendidos = productosVendidos;
    }

    public Venta(Long id, Timestamp fecha, long total, Integer idEmpleado, List<ProductoVenta> productosVendidos) {//constructor con todos los atributos
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.empleado = empleado;
        this.productosVendidos = productosVendidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Empleado getIdEmpleado() {
        return empleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.empleado = idEmpleado;
    }

    public List<ProductoVenta> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<ProductoVenta> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fecha=" + fecha + ", total=" + total + ", Empleado=" + empleado + ", productosVendidos=" + productosVendidos + '}';
    }



    
}
