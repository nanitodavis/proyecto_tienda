/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_tienda;

/**
 *
 * @author nanito
 */
public class Usuario {
    private String nombre;
    private Carrito carrito;
    
    public Usuario(String nom){
        nombre=nom;
    }
    
    public void setNombre(String nom){
        nombre= nom;
    }
    
    public String getNombre(){
        return nombre;
    }
    
}
