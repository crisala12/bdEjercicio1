/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdejercicio1;


public class BdEjercicio1 {

   
    public static void main(String[] args) {
       conexion cn = new conexion();
        if (cn.conectar()!= null ) {
            System.out.println("Conexion Existosa");
            
            
        }else{
            System.out.println("Conexio Fallida");
        }
    }
    
}
