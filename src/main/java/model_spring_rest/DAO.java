/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_spring_rest;
import com.mycompany.proyecto_tienda.*;
import com.sun.jndi.ldap.Connection;
import java.sql.Driver;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author nanito
 */
public class DAO {
    @Autowired
    JdbcTemplate jdbc;
    //Class.forName("org.postgresql.Driver");
    String url = "jdbc:postgresql://aretico.com:5432/software2";
    Connection connection = null;
    //connection = DriverManager.getConnection(url, this.usuario, this.pwd);
    public DAO(){ 
        
    }
    
    public ArrayList<Usuario> cargarUsuarios(){
        ArrayList<Usuario> lista = new ArrayList();
        return lista;
    }   
    
    public ArrayList<Producto> cargarProductos(){
        ArrayList<Producto> lista = new ArrayList();
        return lista;
    }
    
}
