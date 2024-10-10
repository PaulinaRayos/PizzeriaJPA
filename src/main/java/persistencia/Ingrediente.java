/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package persistencia;

import java.io.Serializable;
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
@Table(name="ingredientes")
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_ingrediente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //columnas nombre, cantidad y tipo
    String nombre;
    Integer cantidad;
    
    //relacion manytomany productos-ingredientes
    @ManyToMany(mappedBy="ingredientes", cascade = CascadeType.PERSIST)
    List<Producto> productos;

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    ////////////////////////
    
    
    @ManyToOne
    @JoinColumn(name="id_tipo", nullable=false)
    TipoIngrediente tipo;
    

    public Ingrediente() {//constructor vacio
    }

    public Ingrediente(String nombre, Integer cantidad, TipoIngrediente tipo) {//constructor sin id
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }
    
    public Ingrediente(Long id, String nombre, Integer cantidad, TipoIngrediente tipo) {//cnstructor con todos los atributos
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public TipoIngrediente getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngrediente tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Ingrediente[ id=" + id + " ]";
    }

}