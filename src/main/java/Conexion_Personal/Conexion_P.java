
package Conexion_Personal;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion_P {
        Connection conectar = null;
                
        String usuario = "root"; 
        String contrasenia = "12345"; 
        String bd = "hospital"; 
        String ip = "localhost"; 
        String puerto = "1472" ; 
        
        String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
        
        public Connection establecerconexion(){
            try {
               Class.forName("com.mysql.cj.jdbc.Driver");
                conectar= DriverManager.getConnection(cadena,usuario,contrasenia);
                JOptionPane.showMessageDialog(null, "se conecto a la base de datos: ");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se conecto a la base de datos, error: "+e.toString());
            }
            return conectar;
        }
}
