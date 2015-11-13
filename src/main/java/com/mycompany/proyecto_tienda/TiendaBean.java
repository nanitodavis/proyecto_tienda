/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_tienda;

import spring_rest.TiendaOnline;
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
    
    public String totalCarrito(){
        String res=""+tienda.getUsuarioActual().getCarrito().totalPrecioProductos();
        return res;
    }
    
    public TiendaOnline getTienda(){
        return tienda;
    }
    
    public void setTienda(TiendaOnline tienda){
        this.tienda = tienda;
    }
}
