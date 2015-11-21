/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_spring_rest;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author nanito
 */
public class TiendaOnline {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Producto> listaProductos;
    private ApplicationContext ctx;
    private GeneralDAO dao;
    private Usuario usuarioActual;
    
    public TiendaOnline(){
        listaProductos=new ArrayList<Producto>();
        listaUsuarios=new ArrayList<Usuario>();
        dao = new GeneralDAO();
        try {
            /*try {
            Class.forName("org.postgresql.Driver").newInstance();
            //on classpath
            } catch(ClassNotFoundException e) {
            // not on classpath
            }
            ctx= new ClassPathXmlApplicationContext("jdbc.xml");
            dao = ctx.getBean("generalDAO", GeneralDAO.class);*/
            cargarListaProductos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TiendaOnline.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TiendaOnline.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TiendaOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
        //cargarListaUsuarios();
        usuarioActual=new Usuario("gisell");
        listaUsuarios.add(usuarioActual);
        Producto p1 = new Producto("zapatos", 1, 20000);
        Producto p2 = new Producto("camisa", 2, 10000);
        Producto p3 = new Producto("gorra", 3, 5000);
        Producto p4 = new Producto("jeans", 4, 15000);
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
    }
    
    public ArrayList<Producto> getListaProducto(){
        return listaProductos;
    }
    
    public void cargarListaUsuarios() throws ClassNotFoundException{
        listaUsuarios=dao.getListaUsuario();
    }
    
    public void actualizarUsuario(Usuario usu){
        for(int cont=0;cont<listaUsuarios.size();cont++){
            if(usu.getNombre().equals(listaUsuarios.get(cont).getNombre())){
                listaUsuarios.set(cont, usu);
            }
        }
    }
    
    public void registrarUsuario(String nombre){
        for(int cont=0;cont<listaUsuarios.size();cont++){
            if(nombre.equals(listaUsuarios.get(cont).getNombre())){
                usuarioActual=listaUsuarios.get(cont);
            }
            else{
                Usuario temp = new Usuario(nombre);
                listaUsuarios.add(temp);
                usuarioActual=temp;
            }
        }
    }
    
    public void cambiarUsuarioAtual(String nombre){
        for(int cont=0;cont<listaUsuarios.size();cont++){
            if(nombre.equals(listaUsuarios.get(cont).getNombre())){
                usuarioActual=listaUsuarios.get(cont);
            }
            else{
                System.out.println("error, el usurio no existe");
            }
        }
    }
    
    public void removerProducto(int cod){
        usuarioActual.getCarrito().retirarProducto(cod);
        actualizarUsuario(usuarioActual);
    }
    
    public String getNombreProducto(int pos){
        return listaProductos.get(pos).getNombre();
    }
    
    public int getPrecioProducto(int pos){
        return listaProductos.get(pos).getPrecio();
    }
    
    public int getCantidadProductos(){
        return usuarioActual.getCarrito().getListaProducto().size();
    }
    
    public void cargarListaProductos() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        listaProductos=dao.getListaProducto();
    }
    
    public void agregarProductoCarrito(Producto producto){
        usuarioActual.agregarAlCarrito(producto);
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
