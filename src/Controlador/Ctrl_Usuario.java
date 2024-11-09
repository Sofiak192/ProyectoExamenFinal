package Controlador;

import Modelo.Usuario;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import conexion.conexion;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class Ctrl_Usuario {

    //metodo para iniciar sesion
    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection cn = conexion.conectar();
        String sql = "select  usuario, contraseña from usuario where usuario = '" + objeto.getUsuario() + "' and contraseña = '" + objeto.getcontraseña() + "'";
        Statement st;

        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al Iniciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
        }

        return respuesta;

    }
}
