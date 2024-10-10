/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author pauli
 */
@Entity
@Table(name = "productos")//mapeamos la tabla
public class Producto implements Serializable {

   

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//cambiamos el AUTO por IDENTETY por lo de autoincrementar
    private Long id;

    //columnas:
    long precio;
    String nombre;
    String descripcion;
    
    //Relacion manytomany de productos-ingredientes
    @ManyToMany()
    @JoinTable(name="productos_ingredientes",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name ="id_ingrediente")
    )
    private List<Ingrediente> ingredientes;

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    ///////////////////////////////////////////////////////////////
    
    
    
    // Relación con ProductoVenta*****************************************************
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductoVenta> ventasProductos;

    
    
    
    
    public Producto() {//constructor vacio
    }

    public Producto(Long id) {
        this.id = id;
    }

    public Producto(long precio, String nombre, String descripcion) { //constructor sin id
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Producto(Long id, long precio, String nombre, String descripcion) {//constructor con todos los atributos
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //constructor sin id con lista ProductoVenta
    public Producto(long precio, String nombre, String descripcion, List<ProductoVenta> ventasProductos) {
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ventasProductos = ventasProductos;
    }

    //constructor con todos los atributos incluyendo lista ProductoVenta
    public Producto(Long id, long precio, String nombre, String descripcion, List<ProductoVenta> ventasProductos) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ventasProductos = ventasProductos;
    }

    public List<ProductoVenta> getVentasProductos() {
        return ventasProductos;
    }

    public void setVentasProductos(List<ProductoVenta> ventasProductos) {
        this.ventasProductos = ventasProductos;
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

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    return "Producto{" +
            "id=" + id +
            ", precio=" + precio +
            ", nombre='" + nombre + '\'' +
            ", descripcion='" + descripcion + '\'' +
            // Puedes imprimir ventasProductos de forma resumida o con solo su tamaño
            ", ventasProductosCount=" + (ventasProductos != null ? ventasProductos.size() : 0) +
            '}';
}

   

    
}
