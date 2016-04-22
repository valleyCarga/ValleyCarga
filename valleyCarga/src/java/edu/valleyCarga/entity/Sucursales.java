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
import javax.persistence.ManyToMany;
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
@Table(name = "sucursales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursales.findAll", query = "SELECT s FROM Sucursales s"),
    @NamedQuery(name = "Sucursales.findBySucursalID", query = "SELECT s FROM Sucursales s WHERE s.sucursalID = :sucursalID"),
    @NamedQuery(name = "Sucursales.findByDireccion", query = "SELECT s FROM Sucursales s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sucursales.findByTelefono", query = "SELECT s FROM Sucursales s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Sucursales.findByBarrio", query = "SELECT s FROM Sucursales s WHERE s.barrio = :barrio"),
    @NamedQuery(name = "Sucursales.findByCorreo", query = "SELECT s FROM Sucursales s WHERE s.correo = :correo"),
    @NamedQuery(name = "Sucursales.findByNombre", query = "SELECT s FROM Sucursales s WHERE s.nombre = :nombre")})
public class Sucursales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sucursalID")
    private Integer sucursalID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "barrio")
    private String barrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "sucursalesCollection")
    private Collection<Usuarios> usuariosCollection;
    @JoinColumn(name = "ciudadID", referencedColumnName = "ciudadID")
    @ManyToOne(optional = false)
    private Ciudades ciudadID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalOrigen")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalDestino")
    private Collection<Factura> facturaCollection1;

    public Sucursales() {
    }

    public Sucursales(Integer sucursalID) {
        this.sucursalID = sucursalID;
    }

    public Sucursales(Integer sucursalID, String direccion, String telefono, String barrio, String correo, String nombre) {
        this.sucursalID = sucursalID;
        this.direccion = direccion;
        this.telefono = telefono;
        this.barrio = barrio;
        this.correo = correo;
        this.nombre = nombre;
    }

    public Integer getSucursalID() {
        return sucursalID;
    }

    public void setSucursalID(Integer sucursalID) {
        this.sucursalID = sucursalID;
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

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public Ciudades getCiudadID() {
        return ciudadID;
    }

    public void setCiudadID(Ciudades ciudadID) {
        this.ciudadID = ciudadID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sucursalID != null ? sucursalID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursales)) {
            return false;
        }
        Sucursales other = (Sucursales) object;
        if ((this.sucursalID == null && other.sucursalID != null) || (this.sucursalID != null && !this.sucursalID.equals(other.sucursalID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.entity.Sucursales[ sucursalID=" + sucursalID + " ]";
    }
    
}
