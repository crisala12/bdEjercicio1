
package bdejercicio1;

import java.sql.Connection;
import java.sql.Statement;


public class personabd {
   public boolean crearPersona(persnoa persona) {
        boolean reguistrar = false;
        Connection con = null;
        Statement stm = null;

        String sql = "INSERT INTO ferreteria.`persona` (cedula, nombres, apellido, direccion, correo, telefono) VALUES ('" + persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getDireccion() + "', '" + persona.getCorreo() + "', '" + persona.getTelefono() + "')";

        try {
            conexion conex = new conexion();
            con = conex.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            reguistrar = true;
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error : " + e);
            e.printStackTrace();
        }
        return reguistrar;
    } 
   public boolean actualizarPersona(persnoa persona,int valor){
      boolean reguistrar = false;
        Connection con = null;
        Statement stm = null;

        String sql = "UPDATE persona SET cedula = '" + persona.getCedula() + "', nombres = '" + persona.getNombre() +"', apellido = '" + persona.getApellido() + "', direccion = '" + persona.getDireccion() +"', correo = '" + persona.getCorreo() +"', telefono = '" + persona.getTelefono() +"' WHERE idpersnona = '" + valor +"'";
        try {
            conexion conex = new conexion();
            con = conex.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            reguistrar = true;
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error : " + e);
            e.printStackTrace();
        }
        return reguistrar; 
       
   }
   public boolean eliminarpersona(int valor){
        boolean reguistrar = false;
        Connection con = null;
        Statement stm = null;

        String sql = "DELETE FROM persona WHERE idpersnona='"+valor+"'";
        try {
            conexion conex = new conexion();
            con = conex.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            reguistrar = true;
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error : " + e);
            e.printStackTrace();
        }
        return reguistrar;
   }
}
