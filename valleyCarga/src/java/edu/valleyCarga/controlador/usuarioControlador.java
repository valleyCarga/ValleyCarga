/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.controlador;

import com.sun.net.httpserver.HttpServer;
import edu.valleyCarga.entity.Usuarios;
import edu.valleyCarga.entity.Ciudades;
import edu.valleyCarga.modelo.Mailer;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Marlon
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class usuarioControlador implements Serializable {

    @EJB
    private edu.valleyCarga.facade.UsuariosFacade usuariosFacade;

    private long cedula;
    private String tipoDocumento;
    private String apellido;
    private String direccion;
    private String celular;
    private String fechaNacimiento;
    private String clave;
    private String frCiudad;
    private Usuarios logueado;
    private String fcNombre;
    private String fcCorreo;
    private String fcEmpresa;
    private String fcTelefono;
    private String fcMensaje;
    private int estado = 0;

    public usuarioControlador() {
    }

    /**
     * @return the cedula
     */
    public long getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the frCiudad
     */
    public String getFrCiudad() {
        return frCiudad;
    }

    /**
     * @param frCiudad the frCiudad to set
     */
    public void setFrCiudad(String frCiudad) {
        this.frCiudad = frCiudad;
    }

    /**
     * @return the logueado
     */
    public Usuarios getLogueado() {
        return logueado;
    }

    /**
     * @param logueado the logueado to set
     */
    public void setLogueado(Usuarios logueado) {
        this.logueado = logueado;
    }

    /**
     * @return the fcNombre
     */
    public String getFcNombre() {
        return fcNombre;
    }

    /**
     * @param fcNombre the fcNombre to set
     */
    public void setFcNombre(String fcNombre) {
        this.fcNombre = fcNombre;
    }

    /**
     * @return the fcCorreo
     */
    public String getFcCorreo() {
        return fcCorreo;
    }

    /**
     * @param fcCorreo the fcCorreo to set
     */
    public void setFcCorreo(String fcCorreo) {
        this.fcCorreo = fcCorreo;
    }

    /**
     * @return the fcEmpresa
     */
    public String getFcEmpresa() {
        return fcEmpresa;
    }

    /**
     * @param fcEmpresa the fcEmpresa to set
     */
    public void setFcEmpresa(String fcEmpresa) {
        this.fcEmpresa = fcEmpresa;
    }

    /**
     * @return the fcTelefono
     */
    public String getFcTelefono() {
        return fcTelefono;
    }

    /**
     * @param fcTelefono the fcTelefono to set
     */
    public void setFcTelefono(String fcTelefono) {
        this.fcTelefono = fcTelefono;
    }

    /**
     * @return the fcMensaje
     */
    public String getFcMensaje() {
        return fcMensaje;
    }

    /**
     * @param fcMensaje the fcMensaje to set
     */
    public void setFcMensaje(String fcMensaje) {
        this.fcMensaje = fcMensaje;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String enviarMensajeContacto() {
        String mensaje = "Nombre: " + fcNombre + " Correo: " + fcCorreo + " Nombre de la empresa: " + fcEmpresa
                + " Telefono de contacto: " + fcTelefono + " Mensaje: " + fcMensaje;

        try {
            Mailer.send("mctrite1110@gmail.com", "Mensaje de contactos", mensaje);
            estado = 1;
        } catch (Exception e) {
            estado = 2;
        }

        fcNombre = "";
        fcCorreo = "";
        fcEmpresa = "";
        fcTelefono = "";
        fcMensaje = "";

        return "index";
    }

    public String registrarUsuario() {
        Usuarios objUsuario = new Usuarios();

        try {
            objUsuario.setCedula(cedula);
            objUsuario.setTipoDocumento(tipoDocumento);
            objUsuario.setNombre(fcNombre);
            objUsuario.setApellido(apellido);
            objUsuario.setDireccion(direccion);
            objUsuario.setTelefono(fcTelefono);
            objUsuario.setCelular(celular);

            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento);
            objUsuario.setFechaNacimiento(date);
            objUsuario.setCorreo(fcCorreo);

            Ciudades miCiudad = new Ciudades();
            miCiudad.setCiudadID(Integer.parseInt(frCiudad));
            objUsuario.setClave(clave);

            usuariosFacade.create(objUsuario);

            estado = 1;
        } catch (Exception e) {
            estado = 2;
        }

        return "aaa";
    }

    public void validarSesion() throws IOException {
        FacesContext facesContexs = FacesContext.getCurrentInstance();

        if (logueado != null) {

        } else {
            facesContexs.getExternalContext().redirect("../index.xhtml");
        }
    }

    public void borrarEstado() {
        estado = 0;
    } 

    public String iniciarsesion() {
        List<Usuarios> loguea = usuariosFacade.validarUsuario(cedula, clave);

        if (loguea.isEmpty()) {
            estado = 3;
            return "index";
        } else {
            logueado = loguea.get(0);
            estado = 4;
            return "/Bodega/envios";
        }

    }

}
