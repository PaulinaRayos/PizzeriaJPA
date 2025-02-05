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
@Table(name="tipos")//mapeamos la tabla
public class TipoIngrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id_tipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String descripcion;
    @OneToMany(cascade=CascadeType.PERSIST,mappedBy="tipo")
    
    private List <Ingrediente> ingredientes;

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public TipoIngrediente() {
       
    }

    public TipoIngrediente(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public TipoIngrediente(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof TipoIngrediente)) {
            return false;
        }
        TipoIngrediente other = (TipoIngrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TipoIngrediente[ id=" + id + " ]";
    }
    
}
