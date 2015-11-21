/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_spring_rest;

/**
 *
 * @author nanito
 */
public class Usuario {
    private String nombre;
    private Carrito carrito;
    
    public Usuario(String nom){
        nombre=nom;
        carrito = new Carrito();
    }
    
    public void agregarAlCarrito(Producto producto){
        carrito.agregarProducto(producto);
    }
    
    public void quitarProducto(int codigo){
        carrito.retirarProducto(codigo);
    }
    
    public void setNombre(String nom){
        nombre= nom;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Carrito getCarrito(){
        return carrito;
    }
    
    public void setCarrito(int cod){
        this.carrito=new Carrito(cod);
    }
    
}
