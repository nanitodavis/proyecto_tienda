/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_tienda;

import model_spring_rest.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author nanito
 */
@ManagedBean
@SessionScoped
public class TiendaBean {
    private TiendaOnline tienda = new TiendaOnline();
    private String temporal="";
    
    public String totalCarrito(){
        String res=""+tienda.getUsuarioActual().getCarrito().totalPrecioProductos();
        return res;
    }
    
    public void loginBean(){
        cambiarUsuario(temporal);
    }
    
    public void registrarBean(){
        registrarUsuario(temporal);
    }
    
    public String getTemporal(){
        return temporal;
    }               
    
    public void setTemporal(String temp){
        temporal=temp;
    }
            
    public void registrarUsuario(String nombre){
        tienda.registrarUsuario(nombre);
    }
    
    public void cambiarUsuario(String nombre){
        tienda.cambiarUsuarioAtual(nombre);
    }
    
    public String getNombreProducto(int pos){
        return tienda.getNombreProducto(pos);
    }
    
    public void agregarACarrito(int pos){
        tienda.agregarProductoCarrito(tienda.getListaProducto().get(pos));
        //tienda.actualizarUsuario(tienda.getUsuarioActual());
    }
    
    public TiendaOnline getTienda(){
        return tienda;
    }
    
    public void setTienda(TiendaOnline tienda){
        this.tienda = tienda;
    }
}
