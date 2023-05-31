/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author Ariana
 */
public class Utils {
    public static Boolean intToBool(boolean estado){
        if(estado == false){
            return false;
        }else{
            return true;
        }
    }
    
    public static Integer boolToInt(boolean estado){
        if (estado) {
            return 1;
        }else{
            return 0;
        }
    } 
}
