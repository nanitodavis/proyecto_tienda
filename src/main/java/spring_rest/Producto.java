/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring_rest;

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
    
    public int getPrecio(){
        return precio;
    }
    
    public void setPrecio(int precio){
        this.precio=precio;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo=codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
}
