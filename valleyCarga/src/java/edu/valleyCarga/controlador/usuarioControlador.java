/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.controlador;

import edu.valleyCarga.modelo.Mailer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Marlon
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class usuarioControlador implements Serializable {

    /**
     * Creates a new instance of usuarioControlador
     */
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

}
