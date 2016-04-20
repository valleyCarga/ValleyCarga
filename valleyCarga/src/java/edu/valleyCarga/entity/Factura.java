/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PRACTICAS
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByFacturaID", query = "SELECT f FROM Factura f WHERE f.facturaID = :facturaID"),
    @NamedQuery(name = "Factura.findByValor", query = "SELECT f FROM Factura f WHERE f.valor = :valor"),
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Factura.findByHora", query = "SELECT f FROM Factura f WHERE f.hora = :hora"),
    @NamedQuery(name = "Factura.findByValorDeclarado", query = "SELECT f FROM Factura f WHERE f.valorDeclarado = :valorDeclarado"),
    @NamedQuery(name = "Factura.findByFormaPago", query = "SELECT f FROM Factura f WHERE f.formaPago = :formaPago"),
    @NamedQuery(name = "Factura.findByTiempoEntrega", query = "SELECT f FROM Factura f WHERE f.tiempoEntrega = :tiempoEntrega")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "facturaID")
    private Integer facturaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
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
    @Column(name = "valor_declarado")
    private int valorDeclarado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "forma_pago")
    private String formaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_entrega")
    @Temporal(TemporalType.TIME)
    private Date tiempoEntrega;
    @JoinTable(name = "factura_vehiculos", joinColumns = {
        @JoinColumn(name = "facturaID", referencedColumnName = "facturaID")}, inverseJoinColumns = {
        @JoinColumn(name = "vehiculoID", referencedColumnName = "vehiculoID")})
    @ManyToMany
    private Collection<Vehiculos> vehiculosCollection;
    @JoinColumn(name = "cajero", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuarios cajero;
    @JoinColumn(name = "remitente", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuarios remitente;
    @JoinColumn(name = "destinatario", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuarios destinatario;
    @JoinColumn(name = "sucursal_destino", referencedColumnName = "sucursalID")
    @ManyToOne(optional = false)
    private Sucursales sucursalDestino;
    @JoinColumn(name = "sucursal_origen", referencedColumnName = "sucursalID")
    @ManyToOne(optional = false)
    private Sucursales sucursalOrigen;
    @JoinColumn(name = "tarifaID", referencedColumnName = "tarifaID")
    @ManyToOne(optional = false)
    private Tarifas tarifaID;
    @JoinColumn(name = "ciudad_destino", referencedColumnName = "ciudadID")
    @ManyToOne(optional = false)
    private Ciudades ciudadDestino;
    @JoinColumn(name = "ciudad_origen", referencedColumnName = "ciudadID")
    @ManyToOne(optional = false)
    private Ciudades ciudadOrigen;
    @JoinColumn(name = "paqueteID", referencedColumnName = "paqueteID")
    @ManyToOne(optional = false)
    private Paquetes paqueteID;

    public Factura() {
    }

    public Factura(Integer facturaID) {
        this.facturaID = facturaID;
    }

    public Factura(Integer facturaID, int valor, Date fecha, Date hora, int valorDeclarado, String formaPago, Date tiempoEntrega) {
        this.facturaID = facturaID;
        this.valor = valor;
        this.fecha = fecha;
        this.hora = hora;
        this.valorDeclarado = valorDeclarado;
        this.formaPago = formaPago;
        this.tiempoEntrega = tiempoEntrega;
    }

    public Integer getFacturaID() {
        return facturaID;
    }

    public void setFacturaID(Integer facturaID) {
        this.facturaID = facturaID;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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

    public int getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(int valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Date getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(Date tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    @XmlTransient
    public Collection<Vehiculos> getVehiculosCollection() {
        return vehiculosCollection;
    }

    public void setVehiculosCollection(Collection<Vehiculos> vehiculosCollection) {
        this.vehiculosCollection = vehiculosCollection;
    }

    public Usuarios getCajero() {
        return cajero;
    }

    public void setCajero(Usuarios cajero) {
        this.cajero = cajero;
    }

    public Usuarios getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuarios remitente) {
        this.remitente = remitente;
    }

    public Usuarios getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuarios destinatario) {
        this.destinatario = destinatario;
    }

    public Sucursales getSucursalDestino() {
        return sucursalDestino;
    }

    public void setSucursalDestino(Sucursales sucursalDestino) {
        this.sucursalDestino = sucursalDestino;
    }

    public Sucursales getSucursalOrigen() {
        return sucursalOrigen;
    }

    public void setSucursalOrigen(Sucursales sucursalOrigen) {
        this.sucursalOrigen = sucursalOrigen;
    }

    public Tarifas getTarifaID() {
        return tarifaID;
    }

    public void setTarifaID(Tarifas tarifaID) {
        this.tarifaID = tarifaID;
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

    public Paquetes getPaqueteID() {
        return paqueteID;
    }

    public void setPaqueteID(Paquetes paqueteID) {
        this.paqueteID = paqueteID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaID != null ? facturaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facturaID == null && other.facturaID != null) || (this.facturaID != null && !this.facturaID.equals(other.facturaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.controlador.Factura[ facturaID=" + facturaID + " ]";
    }
    
}
