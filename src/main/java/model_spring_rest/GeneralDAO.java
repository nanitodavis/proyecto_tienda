/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_spring_rest;
import com.mycompany.proyecto_tienda.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author nanito
 */
@Component
public class GeneralDAO /*implements GeneralDaoInterface*/{
    private JdbcTemplate jdbc;
    private Connection connection=null;
    @Autowired
    private DataSource dataSource;
    
    public GeneralDAO(){ 
        
    }

    //@Override
    public ArrayList<Producto> getListaProducto() {
        ArrayList<Producto> lista=new ArrayList<Producto>();
        try {
            connection=dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM usuario");
            Producto producto=null;
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                producto = new Producto(rs.getString("nom_Producto"), rs.getInt(1), rs.getInt(3));
                System.out.println(producto.toString());
                lista.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GeneralDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //@Override
    public void incertarProducto(int cod, String nombre, int precio) {
        jdbc.execute("INSERT INTO producto(cod_producto, nom_producto, precio) VALUES('"+cod+"', '"+nombre+"', '"+precio+"');");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public ArrayList<Usuario> getListaUsuario() {
        Usuario usuario;
        Carrito carrito;
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void incertarUsuario(String nombre) {
        String sqlusu = "INSERT INTO USUARIO(nom_usuario) values(?);";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void incertarProductoCarrito(int codCarrito, int codProduto) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
