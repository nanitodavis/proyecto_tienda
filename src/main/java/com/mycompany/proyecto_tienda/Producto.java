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
public class Producto {
    private String nombre;
    private int codigo;
    private int precio;
    
    public Producto(String nom, int cod, int pre){
        nombre=nom;
        codigo=cod;
        precio=pre;
    }
}
