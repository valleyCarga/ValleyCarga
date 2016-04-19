/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PRACTICAS
 */
@Entity
@Table(name = "historial_vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialVehiculos.findAll", query = "SELECT h FROM HistorialVehiculos h"),
    @NamedQuery(name = "HistorialVehiculos.findByHistorialvID", query = "SELECT h FROM HistorialVehiculos h WHERE h.historialvID = :historialvID"),
    @NamedQuery(name = "HistorialVehiculos.findByUsuarioA", query = "SELECT h FROM HistorialVehiculos h WHERE h.usuarioA = :usuarioA"),
    @NamedQuery(name = "HistorialVehiculos.findByFecha", query = "SELECT h FROM HistorialVehiculos h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "HistorialVehiculos.findByHora", query = "SELECT h FROM HistorialVehiculos h WHERE h.hora = :hora")})
public class HistorialVehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "historial_vID")
    private Integer historialvID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_a")
    private long usuarioA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuarios cedula;
    @JoinColumn(name = "vehiculoID", referencedColumnName = "vehiculoID")
    @ManyToOne(optional = false)
    private Vehiculos vehiculoID;

    public HistorialVehiculos() {
    }

    public HistorialVehiculos(Integer historialvID) {
        this.historialvID = historialvID;
    }

    public HistorialVehiculos(Integer historialvID, long usuarioA, Date fecha, Date hora) {
        this.historialvID = historialvID;
        this.usuarioA = usuarioA;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Integer getHistorialvID() {
        return historialvID;
    }

    public void setHistorialvID(Integer historialvID) {
        this.historialvID = historialvID;
    }

    public long getUsuarioA() {
        return usuarioA;
    }

    public void setUsuarioA(long usuarioA) {
        this.usuarioA = usuarioA;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Usuarios getCedula() {
        return cedula;
    }

    public void setCedula(Usuarios cedula) {
        this.cedula = cedula;
    }

    public Vehiculos getVehiculoID() {
        return vehiculoID;
    }

    public void setVehiculoID(Vehiculos vehiculoID) {
        this.vehiculoID = vehiculoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historialvID != null ? historialvID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialVehiculos)) {
            return false;
        }
        HistorialVehiculos other = (HistorialVehiculos) object;
        if ((this.historialvID == null && other.historialvID != null) || (this.historialvID != null && !this.historialvID.equals(other.historialvID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.entity.HistorialVehiculos[ historialvID=" + historialvID + " ]";
    }
    
}
