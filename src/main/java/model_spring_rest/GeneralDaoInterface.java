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
public interface GeneralDaoInterface {
    public ArrayList<Producto> getListaProducto();
    public void incertarProducto(int cod, String nombre, int precio);
    public ArrayList<Usuario> getListaUsuario();
    public void incertarUsuario(String nombre);
    public void incertarProductoCarrito(int codCarrito, int codProduto);
}
