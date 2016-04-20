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
@Table(name = "departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByDepartamentoID", query = "SELECT d FROM Departamentos d WHERE d.departamentoID = :departamentoID"),
    @NamedQuery(name = "Departamentos.findByNombre", query = "SELECT d FROM Departamentos d WHERE d.nombre = :nombre")})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "departamentoID")
    private Integer departamentoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoID")
    private Collection<Ciudades> ciudadesCollection;

    public Departamentos() {
    }

    public Departamentos(Integer departamentoID) {
        this.departamentoID = departamentoID;
    }

    public Departamentos(Integer departamentoID, String nombre) {
        this.departamentoID = departamentoID;
        this.nombre = nombre;
    }

    public Integer getDepartamentoID() {
        return departamentoID;
    }

    public void setDepartamentoID(Integer departamentoID) {
        this.departamentoID = departamentoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Ciudades> getCiudadesCollection() {
        return ciudadesCollection;
    }

    public void setCiudadesCollection(Collection<Ciudades> ciudadesCollection) {
        this.ciudadesCollection = ciudadesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departamentoID != null ? departamentoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.departamentoID == null && other.departamentoID != null) || (this.departamentoID != null && !this.departamentoID.equals(other.departamentoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.controlador.Departamentos[ departamentoID=" + departamentoID + " ]";
    }
    
}
