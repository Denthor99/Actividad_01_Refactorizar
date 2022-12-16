/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Daniel Alfonso Rodriguez
 * @version 1.2
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] espacioMemoria = new byte[1000];
    private static String nombreFichero = "fichero.dat";
    private static FileInputStream entradaFlujo = null;
    private static BufferedInputStream entradaMemoria = null;
    /**
     * @throws FileNotFoundException 
     */

    public static void inicializarFicheros() throws FileNotFoundException
    {
        entradaFlujo = new FileInputStream(nombreFichero);
        entradaMemoria = new BufferedInputStream(entradaFlujo);
    }
    
    /**
     * @return total
     * @throws IOException 
     */
    public static int mostrarFicheroTexto() throws IOException
    {
        int total = 0;
        int leer = 0;
        while((leer = entradaFlujo.read(espacioMemoria)) != -1) 
        {
            System.out.println(new String(espacioMemoria));
            total += leer;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarFicheros();
            
            int total = mostrarFicheroTexto();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( entradaMemoria != null && entradaFlujo != null )
                {
                    entradaFlujo.close();
                    entradaMemoria.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
