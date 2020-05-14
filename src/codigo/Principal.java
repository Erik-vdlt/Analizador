/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author erik
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta = "/home/erik/NetBeansProjects/AnalizadorLexicoFinal/src/codigo/Lexer.flex";
        String ruta1 = "/home/erik/NetBeansProjects/AnalizadorLexicoFinal/src/codigo/LexerCup.flex";
        String rutas[] ={"-parser","Sintax","/home/erik/NetBeansProjects/AnalizadorLexicoFinal/src/codigo/Sintax.cup"};
        generar(ruta,ruta1,rutas);
    }
    
    public static void generar(String ruta, String ruta1, String rutas[]) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta);
        jflex.Main.generate(archivo);
        archivo = new File(ruta1);
        jflex.Main.generate(archivo);
        java_cup.Main.main(rutas);
        
        Path rutaSym = Paths.get("/home/erik/NetBeansProjects/AnalizadorLexicoFinal/src/codigo/sym.java");
        
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        
        Files.move(Paths.get("/home/erik/NetBeansProjects/AnalizadorLexicoFinal/sym.java"),
                Paths.get("/home/erik/NetBeansProjects/AnalizadorLexicoFinal/src/codigo/sym.java"));
        
        Path rutaSin = Paths.get("/home/erik/NetBeansProjects/AnalizadorLexicoFinal/src/codigo/Sintax.java");
        
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        
        Files.move(Paths.get("/home/erik/NetBeansProjects/AnalizadorLexicoFinal/Sintax.java"),
                Paths.get("/home/erik/NetBeansProjects/AnalizadorLexicoFinal/src/codigo/Sintax.java"));
    }
}
