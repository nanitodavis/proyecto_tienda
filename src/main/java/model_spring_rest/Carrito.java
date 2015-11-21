/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_spring_rest;

import java.util.ArrayList;

/**
 *
 * @author nanito
 */
public class Carrito {
    private int codigo;
    private ArrayList<Producto> listaProductos;
    
    public Carrito(int cod){
        codigo=cod;
        listaProductos = new ArrayList<Producto>();
    }
    public Carrito(){
        codigo=0;
        listaProductos = new ArrayList<Producto>();
        
    }
    
    public int totalPrecioProductos(){
        int total=0;
        for(int cont=0;cont<listaProductos.size();cont++){
            total+=listaProductos.get(cont).getPrecio();
        }
        return total;
    }
    
    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
    }
    
    public void retirarProducto(int codigo){
        for(int cont=0;cont<listaProductos.size();cont++){
            if (codigo==listaProductos.get(cont).getCodigo()){
                listaProductos.remove(listaProductos.get(cont));
                cont+=listaProductos.size();
            }
        }
    }
    
    public void setCodigo(int cod){
        codigo=cod;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void vaciarCarrito(){
        listaProductos.clear();
    }
}
