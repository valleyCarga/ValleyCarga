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

    private int cedula;
    private String tipoDocumento;
    private String apellido;
    private String direccion;
    private String celular;
    private Date fechaNacimiento;
    private String clave;
    private String frCiudad;

    private String fcNombre;
    private String fcCorreo;
    private String fcEmpresa;
    private String fcTelefono;
    private String fcMensaje;
    private int estado = 0;

    public usuarioControlador() {
    }

    public String getFcNombre() {
        return fcNombre;
    }

    public void setFcNombre(String fcNombre) {
        this.fcNombre = fcNombre;
    }

    public String getFcCorreo() {
        return fcCorreo;
    }

    public void setFcCorreo(String fcCorreo) {
        this.fcCorreo = fcCorreo;
    }

    public String getFcEmpresa() {
        return fcEmpresa;
    }

    public void setFcEmpresa(String fcEmpresa) {
        this.fcEmpresa = fcEmpresa;
    }

    public String getFcTelefono() {
        return fcTelefono;
    }

    public void setFcTelefono(String fcTelefono) {
        this.fcTelefono = fcTelefono;
    }

    public String getFcMensaje() {
        return fcMensaje;
    }

    public void setFcMensaje(String fcMensaje) {
        this.fcMensaje = fcMensaje;
    }

    public int getEstado() {
        return estado;
    }

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

    public void borrarEstado() {
        estado = 0;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public edu.valleyCarga.facade.UsuariosFacade getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(edu.valleyCarga.facade.UsuariosFacade usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public String registrarUsuario() {
        //Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento);
        Usuarios objUsuario = new Usuarios();

        try {
            objUsuario.setTipoDocumento(tipoDocumento);
            objUsuario.setNombre(fcNombre);
            objUsuario.setApellido(apellido);
            objUsuario.setDireccion(direccion);
            objUsuario.setTelefono(fcTelefono);
            objUsuario.setCelular(celular);
            objUsuario.setFechaNacimiento(fechaNacimiento);
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

    public String getFrCiudad() {
        return frCiudad;
    }

    public void setFrCiudad(String frCiudad) {
        this.frCiudad = frCiudad;
    }
    public String iniciarsesion(){
        List<Usuarios> logueado = usuariosFacade.validarUsuario(cedula, clave);  
        if (logueado.isEmpty()) {
            FacesContext facesContexs = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContexs.getExternalContext();
            HttpServletRequest miSession = (HttpServletRequest) facesContexs.getExternalContext().getRequest();
            miSession.setAttribute("usuarioL", logueado);
            estado=3;
        }else{
            estado=4;
        }
        return "envios";
    }
}
