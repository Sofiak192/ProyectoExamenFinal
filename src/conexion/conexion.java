
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class conexion {
    //conexion local
    public static Connection conectar (){
       
    try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdferretería?zeroDateTimeBehavior=CONVERT_TO_NULL","root","sofia123");
        System.out.println("Conexión exitosa a la base de datos");
        return con;
                
    } catch (SQLException e){
        System.out.println(e.toString());
       System.out.println("Error en la conexion local " );
    
    }return null;
            

    }//fin conectar;

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}