/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring_rest;

import java.util.ArrayList;
import spring_rest.*;

/**
 *
 * @author nanito
 */
public class TiendaOnline {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Producto> listaProductos;
    private DAO dao;
    private Usuario usuarioActual;
    
    public TiendaOnline(){
        //cargarListaUsuarios();
        //cargarListaProductos();
        usuarioActual=new Usuario("gisell");
    }
    
    public void cargarListaUsuarios(){
        listaUsuarios=dao.cargarUsuarios();
    }
    
    public void cargarListaProductos(){
        listaProductos=dao.cargarProductos();
    }
    
    public void agregarProductoCarrito(String usuario, Producto producto){
        for(int cont=0;cont>listaUsuarios.size();cont++){
            if(usuario.equals(listaUsuarios.get(cont).getNombre())){
                listaUsuarios.get(cont).agregarAlCarrito(producto);
            }
        }
    }
    public void setUsuarioActual(Usuario usuario){
        usuarioActual = usuario;
    }
    
    public Usuario getUsuarioActual(){
        return usuarioActual;
    }
}
