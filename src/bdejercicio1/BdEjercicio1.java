/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdejercicio1;


public class BdEjercicio1 {

   
    public static void main(String[] args) {
    //persnoa ps = new persnoa();
    personabd bd= new personabd();
        
//       ps.setCedula("11060874");
//       ps.setNombre("Soraya Veronica");
//       ps.setApellido("Montaño Cabezas");
//       ps.setDireccion("San Jose");
//       ps.setCorreo("soyaracabe12@gmail.com");
//       ps.setTelefono("098765554");
//      
//        if (bd.crearPersona(ps)) {
//            System.out.println("Sus datos se guardo exitosamente"); 
//        }else{
//            System.out.println("NO se guardo sus datos");
//        }
        if (bd.eliminarpersona(2)) {
            System.out.println("El Dato se elimino correctamente");
            
        }else{
            System.out.println("El dato no se elimino");
        }
//  if (bd.actualizarPersona(ps, 2)) {
//            System.out.println("El dato se actualizo correctamente");
//            
//        }else{
//            System.out.println("El dato no se actualizo");
//        }
//    }
//    
    }
    
    }
