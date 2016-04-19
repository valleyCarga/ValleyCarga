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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v"),
    @NamedQuery(name = "Vehiculos.findByVehiculoID", query = "SELECT v FROM Vehiculos v WHERE v.vehiculoID = :vehiculoID"),
    @NamedQuery(name = "Vehiculos.findByPlaca", query = "SELECT v FROM Vehiculos v WHERE v.placa = :placa"),
    @NamedQuery(name = "Vehiculos.findByMarca", query = "SELECT v FROM Vehiculos v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculos.findByModelo", query = "SELECT v FROM Vehiculos v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculos.findByEstado", query = "SELECT v FROM Vehiculos v WHERE v.estado = :estado")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vehiculoID")
    private Integer vehiculoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estado")
    private String estado;
    @JoinTable(name = "vehiculos_usuarios", joinColumns = {
        @JoinColumn(name = "vehiculoID", referencedColumnName = "vehiculoID")}, inverseJoinColumns = {
        @JoinColumn(name = "cedulaID", referencedColumnName = "cedula")})
    @ManyToMany
    private Collection<Usuarios> usuariosCollection;
    @ManyToMany(mappedBy = "vehiculosCollection")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoID")
    private Collection<Paquetes> paquetesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoID")
    private Collection<HistorialVehiculos> historialVehiculosCollection;

    public Vehiculos() {
    }

    public Vehiculos(Integer vehiculoID) {
        this.vehiculoID = vehiculoID;
    }

    public Vehiculos(Integer vehiculoID, String placa, String marca, String modelo, String estado) {
        this.vehiculoID = vehiculoID;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
    }

    public Integer getVehiculoID() {
        return vehiculoID;
    }

    public void setVehiculoID(Integer vehiculoID) {
        this.vehiculoID = vehiculoID;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @XmlTransient
    public Collection<Paquetes> getPaquetesCollection() {
        return paquetesCollection;
    }

    public void setPaquetesCollection(Collection<Paquetes> paquetesCollection) {
        this.paquetesCollection = paquetesCollection;
    }

    @XmlTransient
    public Collection<HistorialVehiculos> getHistorialVehiculosCollection() {
        return historialVehiculosCollection;
    }

    public void setHistorialVehiculosCollection(Collection<HistorialVehiculos> historialVehiculosCollection) {
        this.historialVehiculosCollection = historialVehiculosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehiculoID != null ? vehiculoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.vehiculoID == null && other.vehiculoID != null) || (this.vehiculoID != null && !this.vehiculoID.equals(other.vehiculoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.entity.Vehiculos[ vehiculoID=" + vehiculoID + " ]";
    }
    
}
