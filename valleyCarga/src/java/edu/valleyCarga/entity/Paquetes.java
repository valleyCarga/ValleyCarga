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
@Table(name = "paquetes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquetes.findAll", query = "SELECT p FROM Paquetes p"),
    @NamedQuery(name = "Paquetes.findByPaqueteID", query = "SELECT p FROM Paquetes p WHERE p.paqueteID = :paqueteID"),
    @NamedQuery(name = "Paquetes.findByPeso", query = "SELECT p FROM Paquetes p WHERE p.peso = :peso"),
    @NamedQuery(name = "Paquetes.findByVolumen", query = "SELECT p FROM Paquetes p WHERE p.volumen = :volumen"),
    @NamedQuery(name = "Paquetes.findByEmbalaje", query = "SELECT p FROM Paquetes p WHERE p.embalaje = :embalaje"),
    @NamedQuery(name = "Paquetes.findByDetalle", query = "SELECT p FROM Paquetes p WHERE p.detalle = :detalle"),
    @NamedQuery(name = "Paquetes.findByTipoPaquete", query = "SELECT p FROM Paquetes p WHERE p.tipoPaquete = :tipoPaquete"),
    @NamedQuery(name = "Paquetes.findByEstado", query = "SELECT p FROM Paquetes p WHERE p.estado = :estado")})
public class Paquetes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paqueteID")
    private Integer paqueteID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private int peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumen")
    private int volumen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "embalaje")
    private String embalaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipo_paquete")
    private String tipoPaquete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paqueteID")
    private Collection<Factura> facturaCollection;
    @JoinColumn(name = "vehiculoID", referencedColumnName = "vehiculoID")
    @ManyToOne(optional = false)
    private Vehiculos vehiculoID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paqueteID")
    private Collection<HistorialPaquete> historialPaqueteCollection;

    public Paquetes() {
    }

    public Paquetes(Integer paqueteID) {
        this.paqueteID = paqueteID;
    }

    public Paquetes(Integer paqueteID, int peso, int volumen, String embalaje, String detalle, String tipoPaquete, String estado) {
        this.paqueteID = paqueteID;
        this.peso = peso;
        this.volumen = volumen;
        this.embalaje = embalaje;
        this.detalle = detalle;
        this.tipoPaquete = tipoPaquete;
        this.estado = estado;
    }

    public Integer getPaqueteID() {
        return paqueteID;
    }

    public void setPaqueteID(Integer paqueteID) {
        this.paqueteID = paqueteID;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(String embalaje) {
        this.embalaje = embalaje;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipoPaquete() {
        return tipoPaquete;
    }

    public void setTipoPaquete(String tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    public Vehiculos getVehiculoID() {
        return vehiculoID;
    }

    public void setVehiculoID(Vehiculos vehiculoID) {
        this.vehiculoID = vehiculoID;
    }

    @XmlTransient
    public Collection<HistorialPaquete> getHistorialPaqueteCollection() {
        return historialPaqueteCollection;
    }

    public void setHistorialPaqueteCollection(Collection<HistorialPaquete> historialPaqueteCollection) {
        this.historialPaqueteCollection = historialPaqueteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paqueteID != null ? paqueteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquetes)) {
            return false;
        }
        Paquetes other = (Paquetes) object;
        if ((this.paqueteID == null && other.paqueteID != null) || (this.paqueteID != null && !this.paqueteID.equals(other.paqueteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.controlador.Paquetes[ paqueteID=" + paqueteID + " ]";
    }
    
}
