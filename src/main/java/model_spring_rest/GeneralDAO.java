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
    private JdbcTemplate jdbc=new JdbcTemplate();
    private Connection connection=null;
    @Autowired
    private DataSource dataSource;
    
    public GeneralDAO(){ 
        
    }

    //@Override
    public ArrayList<Producto> getListaProducto() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArrayList<Producto> lista=new ArrayList<Producto>();
        try {
            //connection=dataSource.getConnection();
            String driver = "org.postgres.Driver";
            Class.forName(driver);
            String url = "jdbc:postgresql://aretico.com:5432/software_2";
            connection = DriverManager.getConnection(url, "df_qsWM_UW", "grupo8_5");
            //connection=
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM usuario");
            Producto producto=null;
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                producto = new Producto(rs.getString("nom_producto"), rs.getInt(1), rs.getInt(3));
                System.out.println(producto.toString());
                lista.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GeneralDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int getTotalProductos() throws SQLException{
        String sql = "SELECT COUNT(*) FROM PRODUCTO";
        PreparedStatement s;
        s = connection.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        int count = 0;
        for(;rs.next();){
            count++;
        }
        //jdbc.setDataSource(dataSource);
        return count;
    }
    
    public int getTotalCarritos() throws SQLException{
        String sql = "SELECT COUNT(*) FROM CARRITO";
        PreparedStatement s;
        s = connection.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        int count = 0;
        for(;rs.next();){
            count++;
        }
        return count;
        
    }
    
    public int getTotalUsuarios() throws SQLException{
        String sql = "SELECT COUNT(*) FROM USUARIO";
        PreparedStatement s;
        s = connection.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        int count = 0;
        for(;rs.next();){
            count++;
        }
        return count;
        
    }
    //@Override
    public void incertarProducto(int cod, String nombre, int precio) throws SQLException {
        String sql ="INSERT INTO producto(cod_producto, nom_producto, precio) VALUES('"+cod+"', '"+nombre+"', '"+precio+"')";
        PreparedStatement s;
        s = connection.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        //jdbc.execute("INSERT INTO producto(cod_producto, nom_producto, precio) VALUES('"+cod+"', '"+nombre+"', '"+precio+"');");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public ArrayList<Usuario> getListaUsuario() throws ClassNotFoundException {
        Usuario usuario=null;
        Carrito carrito=null;
        ArrayList<Usuario> lista=new ArrayList<Usuario>();
        try {
            //connection=dataSource.getConnection();
            String driver = "org.postgres.Driver";
            Class.forName(driver);
            String url = "jdbc:postgresql://aretico.com:5432/software_2";
            connection = DriverManager.getConnection(url, "df_qsWM_UW", "grupo8_5");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM usuario");
            PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM carrito");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario = new Usuario(rs.getString("nom_usuario"));
                System.out.println(usuario.toString());
                lista.add(usuario);
            }
            ResultSet rs2 = ps2.executeQuery();
            int cont=0;
            if(rs.next()){
                lista.get(cont).setCarrito(rs.getInt(1));
                cont++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GeneralDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void incertarUsuario(String nombre) throws SQLException {
        String sql = "INSERT INTO USUARIO(nom_usuario) values('"+nombre+"');";
        PreparedStatement s;
        s = connection.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
    }

    //@Override
    public void incertarProductoCarrito(int codCarrito, int codProducto) throws SQLException {
        String sql = "INSERT INTO PRODUCTOSCARRITO(nom_carrito, cod_producto) values('"+codCarrito+"', '"+codProducto+"');";
        PreparedStatement s;
        s = connection.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
