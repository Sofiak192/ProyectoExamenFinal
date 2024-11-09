
package Modelo;

import java.sql.PreparedStatement;
import conexion.conexion;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productosDao {
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProductod(productos pro){
        String sql  = "INSERT INTO producto(codigoProducto, nombreProducto, precioUnitario, cantidadProducto) VALUES(?,?,?,?)";
        try{
            con = conexion.conectar();
            ps =  con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidadProducto());
            ps.execute();
            return true;
        
        }catch(SQLException e){
            System.out.println(e.toString());
            
        return false;
        }
    }
  
       

    
        public List<productos> listar() {
        List<productos> listaProductos = new ArrayList<>();
        String sql = "SELECT codigoProducto, nombreProducto, precioUnitario, cantidadProducto FROM producto";

        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                productos producto = new productos();
                producto.setCodigo(rs.getString("codigoProducto"));
                producto.setNombre(rs.getString("nombreProducto"));
                producto.setPrecio(rs.getDouble("precioUnitario"));
                producto.setCantidadProducto(rs.getInt("cantidadProducto"));

                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        return listaProductos;
}   
    
    public boolean actualizarProducto(productos pro) {
    String sql = "UPDATE producto SET nombreProducto = ?, precioUnitario = ?, cantidadProducto = ? WHERE codigoProducto = ?";
    try {
        con = conexion.conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, pro.getNombre());
        ps.setDouble(2, pro.getPrecio());  // Asegúrate de que el precio esté en formato double
        ps.setInt(3, pro.getCantidadProducto());
        ps.setString(4, pro.getCodigo());
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
    }
}

  
    
    public boolean EliminarProductos(String codigo) {
    String sql = "DELETE FROM producto WHERE codigoProducto = ?";
    try {
        con = conexion.conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, codigo); 
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
    } finally {
        // Asegúrate de cerrar la conexión si es necesario
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    }
    
    
    

    // Método para buscar producto por código
    public productos buscarPorCodigo(String codigo) {
        productos producto = null;
        String sql = "SELECT * FROM producto WHERE codigoProducto = ?";
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto = new productos(rs.getString("codigoProducto"), 
                                         rs.getString("nombreProducto"), 
                                         rs.getDouble("precioUnitario"), 
                                         rs.getInt("cantidadProducto"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }

    
    
    // Método para buscar productos por nombre (lista de resultados)
    public productos buscarProductoPorNombre(String nombre) {
    productos producto = null;
    String sql = "SELECT * FROM producto WHERE nombreProducto = ?";
    try {
        con = conexion.conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        if (rs.next()) {
            producto = new productos(rs.getString("codigoProducto"), 
                                     rs.getString("nombreProducto"), 
                                     rs.getDouble("precioUnitario"), 
                                     rs.getInt("cantidadProducto"));
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    return producto;
}

}

    

 

 





