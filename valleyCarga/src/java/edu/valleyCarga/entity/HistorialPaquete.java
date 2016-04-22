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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marlon
 */
@Entity
@Table(name = "historial_paquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialPaquete.findAll", query = "SELECT h FROM HistorialPaquete h"),
    @NamedQuery(name = "HistorialPaquete.findByHistorialPID", query = "SELECT h FROM HistorialPaquete h WHERE h.historialPID = :historialPID"),
    @NamedQuery(name = "HistorialPaquete.findByFecha", query = "SELECT h FROM HistorialPaquete h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "HistorialPaquete.findByHora", query = "SELECT h FROM HistorialPaquete h WHERE h.hora = :hora"),
    @NamedQuery(name = "HistorialPaquete.findByAccion", query = "SELECT h FROM HistorialPaquete h WHERE h.accion = :accion"),
    @NamedQuery(name = "HistorialPaquete.findByEstadoNuevo", query = "SELECT h FROM HistorialPaquete h WHERE h.estadoNuevo = :estadoNuevo")})
public class HistorialPaquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "historial_PID")
    private Integer historialPID;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "accion")
    private String accion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estado_nuevo")
    private String estadoNuevo;
    @JoinColumn(name = "paqueteID", referencedColumnName = "paqueteID")
    @ManyToOne(optional = false)
    private Paquetes paqueteID;
    @JoinColumn(name = "usuario_a", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuarios usuarioA;

    public HistorialPaquete() {
    }

    public HistorialPaquete(Integer historialPID) {
        this.historialPID = historialPID;
    }

    public HistorialPaquete(Integer historialPID, Date fecha, Date hora, String accion, String estadoNuevo) {
        this.historialPID = historialPID;
        this.fecha = fecha;
        this.hora = hora;
        this.accion = accion;
        this.estadoNuevo = estadoNuevo;
    }

    public Integer getHistorialPID() {
        return historialPID;
    }

    public void setHistorialPID(Integer historialPID) {
        this.historialPID = historialPID;
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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(String estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public Paquetes getPaqueteID() {
        return paqueteID;
    }

    public void setPaqueteID(Paquetes paqueteID) {
        this.paqueteID = paqueteID;
    }

    public Usuarios getUsuarioA() {
        return usuarioA;
    }

    public void setUsuarioA(Usuarios usuarioA) {
        this.usuarioA = usuarioA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historialPID != null ? historialPID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialPaquete)) {
            return false;
        }
        HistorialPaquete other = (HistorialPaquete) object;
        if ((this.historialPID == null && other.historialPID != null) || (this.historialPID != null && !this.historialPID.equals(other.historialPID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.entity.HistorialPaquete[ historialPID=" + historialPID + " ]";
    }
    
}
