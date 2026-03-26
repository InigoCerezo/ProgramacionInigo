package tema7.Documentos.Ejercicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ejercicioB5 {
    public static void main(String[] args) throws IOException {
        try {
            File archivo;
            String diconaro = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/Documentos/diccionario.txt";
            List<String> diccionario = Files.readAllLines(Paths.get(diconaro));
            sage();
            for (String line : diccionario) {
                try {
                    if (line.charAt(0) == '-') {
                        archivo = new File("Diccionari/"+line.charAt(1)+".txt");
                    }else{
                        archivo = new File("Diccionari/"+line.charAt(0)+".txt");
                    }
                    Path path = Paths.get(archivo.getAbsolutePath());
                    if(path == null){
                        archivo.createNewFile();
                    }
                    Files.writeString(path, line + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            }
            System.out.println("Diccionario ordenado.");
        }catch(Exception e){
            System.err.println("Error al ejecutar: " + e.getMessage());
        }
    }
    public static void sage(){
        //me resultó facil hacer esto no se
        String letras = "abcdefghijklmnñopqrstuvwxyz";
        for(int i = 0; i < letras.length(); i++){
            String s = letras.charAt(0) + "";
            File archivo = new File("Diccionari/"+s+".txt");
            File carpeta = archivo.getParentFile();
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }
        }
    }
}
