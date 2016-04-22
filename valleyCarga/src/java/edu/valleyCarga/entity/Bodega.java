/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marlon
 */
@Entity
@Table(name = "bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b"),
    @NamedQuery(name = "Bodega.findByBodegaID", query = "SELECT b FROM Bodega b WHERE b.bodegaID = :bodegaID"),
    @NamedQuery(name = "Bodega.findByDireccion", query = "SELECT b FROM Bodega b WHERE b.direccion = :direccion"),
    @NamedQuery(name = "Bodega.findByTelefono", query = "SELECT b FROM Bodega b WHERE b.telefono = :telefono"),
    @NamedQuery(name = "Bodega.findByCorreo", query = "SELECT b FROM Bodega b WHERE b.correo = :correo")})
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bodegaID")
    private Integer bodegaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "correo")
    private String correo;
    @JoinColumn(name = "ciudadID", referencedColumnName = "ciudadID")
    @ManyToOne(optional = false)
    private Ciudades ciudadID;

    public Bodega() {
    }

    public Bodega(Integer bodegaID) {
        this.bodegaID = bodegaID;
    }

    public Bodega(Integer bodegaID, String direccion, String telefono, String correo) {
        this.bodegaID = bodegaID;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Integer getBodegaID() {
        return bodegaID;
    }

    public void setBodegaID(Integer bodegaID) {
        this.bodegaID = bodegaID;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Ciudades getCiudadID() {
        return ciudadID;
    }

    public void setCiudadID(Ciudades ciudadID) {
        this.ciudadID = ciudadID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bodegaID != null ? bodegaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.bodegaID == null && other.bodegaID != null) || (this.bodegaID != null && !this.bodegaID.equals(other.bodegaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.entity.Bodega[ bodegaID=" + bodegaID + " ]";
    }
    
}
