/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author PRACTICAS
 */
@Named(value = "sucursalesControlador")
@SessionScoped
public class sucursalesControlador implements Serializable {

    
    /**
     * Creates a new instance of sucursalesControlador
     */
    public sucursalesControlador() {
    }
    
}
