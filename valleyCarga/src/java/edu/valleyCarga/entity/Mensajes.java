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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PRACTICAS
 */
@Entity
@Table(name = "mensajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m"),
    @NamedQuery(name = "Mensajes.findByMensajeID", query = "SELECT m FROM Mensajes m WHERE m.mensajeID = :mensajeID"),
    @NamedQuery(name = "Mensajes.findByEstadoMensaje", query = "SELECT m FROM Mensajes m WHERE m.estadoMensaje = :estadoMensaje")})
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mensajeID")
    private Integer mensajeID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "estado_mensaje")
    private String estadoMensaje;
    @JoinColumn(name = "destinatario", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuarios destinatario;
    @JoinColumn(name = "remitente", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuarios remitente;

    public Mensajes() {
    }

    public Mensajes(Integer mensajeID) {
        this.mensajeID = mensajeID;
    }

    public Mensajes(Integer mensajeID, String mensaje, String estadoMensaje) {
        this.mensajeID = mensajeID;
        this.mensaje = mensaje;
        this.estadoMensaje = estadoMensaje;
    }

    public Integer getMensajeID() {
        return mensajeID;
    }

    public void setMensajeID(Integer mensajeID) {
        this.mensajeID = mensajeID;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstadoMensaje() {
        return estadoMensaje;
    }

    public void setEstadoMensaje(String estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
    }

    public Usuarios getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuarios destinatario) {
        this.destinatario = destinatario;
    }

    public Usuarios getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuarios remitente) {
        this.remitente = remitente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mensajeID != null ? mensajeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.mensajeID == null && other.mensajeID != null) || (this.mensajeID != null && !this.mensajeID.equals(other.mensajeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.controlador.Mensajes[ mensajeID=" + mensajeID + " ]";
    }
    
}
