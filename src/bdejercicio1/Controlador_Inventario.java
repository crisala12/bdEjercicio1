
package bdejercicio1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class Controlador_Inventario {
     
     private conexion conex = new conexion();
    private Connection con = conex.conectar();
   public boolean ingresarinventario(Inventario inventario) {
        boolean reguistrar = false;
        Connection con = null;
        Statement stm = null;

        String sql = "INSERT INTO ferreteria.`inventario` (codigo_pro,descripcion , precios_compra,precio_venta ,can_productos) VALUES ('" + inventario.getCodigo_pro() + "', '" +inventario.getDescripcion()  + "', '" +inventario.getPrecios_compra() + "', '" + inventario.getPrecio_venta() + "', '" + inventario.getCan_productos() + "')";

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
    public DefaultTableModel mostrarInventariopordato(String nombre, String id) {
     String columnas[] = {"idinventario", "codigo_pro", "descripcion", "precios_compra", "precio_venta", "can_productos"}; 
      DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);
        
        String lista[] = new String[8];
        String sql = "SELECT * FROM inventario WHERE " + nombre + " LIKE '%" + id + "%'"; 
        // SELECT * FROM persona WHERE id LIKE '%"buscar"%' OR nombre '%"buscar"%'";
        Statement datos;
        try {
            datos = con.createStatement();
            ResultSet res = datos.executeQuery(sql);

            while (res.next()) {
                lista[0] = res.getString(1);
                lista[1] = res.getString(2);
                lista[2] = res.getString(3);
                lista[3] = res.getString(4);
                lista[4] = res.getString(5);
                lista[5] = res.getString(6);
                modeloTabla.addRow(lista);
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return modeloTabla;
    } 
   public boolean actualizarInventario(Inventario inventario){
      boolean reguistrar = false;
        Connection con = null;
        Statement stm = null;

        String sql = "UPDATE inventario SET codigo_pro = '" + inventario.getCodigo_pro() + "', descripcion = '" + inventario.getDescripcion() +"', precios_compra = '" + inventario.getPrecios_compra() + "', precio_venta = '" + inventario.getPrecio_venta() +"', can_productos= '" + inventario.getCan_productos() +"' WHERE idinventario = '" + inventario.getIdinventario() +"'";
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
    public boolean eliminarinventario(int valor){
        boolean reguistrar = false;
        Connection con = null;
        Statement stm = null;

        String sql = "DELETE FROM inventario WHERE idInventario='"+valor+"'";
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
    

