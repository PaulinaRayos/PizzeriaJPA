/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author pauli
 */
@Entity
@Table(name = "productos_ventas")//nombre de la tabla en la base de datos
public class ProductoVenta implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// cambiamos auto a identity

    @Column(name = "id_producto_venta")//nombre del id en la base de datos
    private Long id;

    @Column(nullable = false)
    private Integer cantidad;//columna cantidad

    @Column(nullable = false)
    private long precio;//columna precio

    @Column(nullable = false)
    private long subtotal;//columna subtotal
    
    
    @ManyToOne//relacion ProductoVenta N:1 Producto
    @JoinColumn(name = "id_producto", nullable = false)//nombre del id en base de datos
    private Producto producto;
    
    
    @ManyToOne//relacion ProductoVenta N:1 Venta
    @JoinColumn(name = "id_venta", nullable = false)//nombre del id en base de datos
    private Venta venta;

    public ProductoVenta() {//constructor vacio
    }

    public ProductoVenta(Integer cantidad, long precio, long subtotal, Producto producto, Venta venta) {//constructor sin id
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.producto = producto;
        this.venta = venta;
    }

    public ProductoVenta(Long id, Integer cantidad, long precio, long subtotal, Producto producto, Venta venta) {//constructor con todos los atributos
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.producto = producto;
        this.venta = venta;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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
        if (!(object instanceof ProductoVenta)) {
            return false;
        }
        ProductoVenta other = (ProductoVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    return "ProductoVenta{" +
            "id=" + id +
            ", cantidad=" + cantidad +
            ", precio=" + precio +
            ", subtotal=" + subtotal +
            ", productoNombre='" + (producto != null ? producto.getNombre() : "N/A") + '\'' + // Solo el nombre
            ", ventaId=" + (venta != null ? venta.getId() : "N/A") + // O el ID de la venta
            '}';
}



}
