/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_tienda;

import java.util.ArrayList;

/**
 *
 * @author nanito
 */
public class Carrito {
    private ArrayList<Producto> listaProductos;
    
    public Carrito(){
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
    
    public void vaciarCarrito(){
        listaProductos.clear();
    }
}
