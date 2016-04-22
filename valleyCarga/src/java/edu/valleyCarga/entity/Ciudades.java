/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marlon
 */
@Entity
@Table(name = "ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudades.findAll", query = "SELECT c FROM Ciudades c"),
    @NamedQuery(name = "Ciudades.findByCiudadID", query = "SELECT c FROM Ciudades c WHERE c.ciudadID = :ciudadID"),
    @NamedQuery(name = "Ciudades.findByNombre", query = "SELECT c FROM Ciudades c WHERE c.nombre = :nombre")})
public class Ciudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ciudadID")
    private Integer ciudadID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadID")
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadID")
    private Collection<Bodega> bodegaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadID")
    private Collection<Sucursales> sucursalesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadOrigen")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadDestino")
    private Collection<Factura> facturaCollection1;
    @JoinColumn(name = "departamentoID", referencedColumnName = "departamentoID")
    @ManyToOne(optional = false)
    private Departamentos departamentoID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadOrigen")
    private Collection<Rutas> rutasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadDestino")
    private Collection<Rutas> rutasCollection1;

    public Ciudades() {
    }

    public Ciudades(Integer ciudadID) {
        this.ciudadID = ciudadID;
    }

    public Ciudades(Integer ciudadID, String nombre) {
        this.ciudadID = ciudadID;
        this.nombre = nombre;
    }

    public Integer getCiudadID() {
        return ciudadID;
    }

    public void setCiudadID(Integer ciudadID) {
        this.ciudadID = ciudadID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @XmlTransient
    public Collection<Bodega> getBodegaCollection() {
        return bodegaCollection;
    }

    public void setBodegaCollection(Collection<Bodega> bodegaCollection) {
        this.bodegaCollection = bodegaCollection;
    }

    @XmlTransient
    public Collection<Sucursales> getSucursalesCollection() {
        return sucursalesCollection;
    }

    public void setSucursalesCollection(Collection<Sucursales> sucursalesCollection) {
        this.sucursalesCollection = sucursalesCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection1() {
        return facturaCollection1;
    }

    public void setFacturaCollection1(Collection<Factura> facturaCollection1) {
        this.facturaCollection1 = facturaCollection1;
    }

    public Departamentos getDepartamentoID() {
        return departamentoID;
    }

    public void setDepartamentoID(Departamentos departamentoID) {
        this.departamentoID = departamentoID;
    }

    @XmlTransient
    public Collection<Rutas> getRutasCollection() {
        return rutasCollection;
    }

    public void setRutasCollection(Collection<Rutas> rutasCollection) {
        this.rutasCollection = rutasCollection;
    }

    @XmlTransient
    public Collection<Rutas> getRutasCollection1() {
        return rutasCollection1;
    }

    public void setRutasCollection1(Collection<Rutas> rutasCollection1) {
        this.rutasCollection1 = rutasCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadID != null ? ciudadID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.ciudadID == null && other.ciudadID != null) || (this.ciudadID != null && !this.ciudadID.equals(other.ciudadID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.entity.Ciudades[ ciudadID=" + ciudadID + " ]";
    }
    
}
