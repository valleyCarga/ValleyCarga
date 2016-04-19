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
 * @author PRACTICAS
 */
@Entity
@Table(name = "rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r"),
    @NamedQuery(name = "Rutas.findByRutaID", query = "SELECT r FROM Rutas r WHERE r.rutaID = :rutaID"),
    @NamedQuery(name = "Rutas.findByTiempo", query = "SELECT r FROM Rutas r WHERE r.tiempo = :tiempo")})
public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rutaID")
    private Integer rutaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "Tiempo")
    private String tiempo;
    @JoinColumn(name = "ciudad_destino", referencedColumnName = "ciudadID")
    @ManyToOne(optional = false)
    private Ciudades ciudadDestino;
    @JoinColumn(name = "ciudad_origen", referencedColumnName = "ciudadID")
    @ManyToOne(optional = false)
    private Ciudades ciudadOrigen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutaID")
    private Collection<Tarifas> tarifasCollection;

    public Rutas() {
    }

    public Rutas(Integer rutaID) {
        this.rutaID = rutaID;
    }

    public Rutas(Integer rutaID, String tiempo) {
        this.rutaID = rutaID;
        this.tiempo = tiempo;
    }

    public Integer getRutaID() {
        return rutaID;
    }

    public void setRutaID(Integer rutaID) {
        this.rutaID = rutaID;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public Ciudades getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudades ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Ciudades getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudades ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    @XmlTransient
    public Collection<Tarifas> getTarifasCollection() {
        return tarifasCollection;
    }

    public void setTarifasCollection(Collection<Tarifas> tarifasCollection) {
        this.tarifasCollection = tarifasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutaID != null ? rutaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.rutaID == null && other.rutaID != null) || (this.rutaID != null && !this.rutaID.equals(other.rutaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.entity.Rutas[ rutaID=" + rutaID + " ]";
    }
    
}
