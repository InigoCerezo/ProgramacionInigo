package tema7.Documentos.Ejercicios;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ejercicioB3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        // 1. Pedir los nombres de los archivos al usuario
        System.out.print("Introduce el nombre del archivo de lectura: ");
        String origen = sc.nextLine();
        System.out.print("Introduce el nombre del archivo de escritura: ");
        String destino = sc.nextLine();
       try {
            //six seven
            File a = new File(origen);
            File b = new File(destino);
            //System.out.println(a.getAbsolutePath());
            //System.out.println(b.getAbsolutePath());
            Path origenPath = Paths.get(a.getAbsolutePath());
            List<String> lines = Files.readAllLines(origenPath);
            //Files.readString()
            Collections.sort(lines);
            Path destinoPath = Paths.get(b.getAbsolutePath());
            Files.write(destinoPath,lines);
        } catch (IOException e) {
            System.err.println("Error al procesar un archivo. Asegurate de que existe. "+e.getMessage());
        }
        /*
        String trial = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/Documentos/usa_personas.txt";
        String error = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/Documentos/usa_personas_sorted.txt";
        try {
            //six seven
            File a = new File(trial);
            File b = new File(error);
            //System.out.println(a.getAbsolutePath());
            //System.out.println(b.getAbsolutePath());
            Path origenPath = Paths.get(a.getAbsolutePath());
            List<String> lines = Files.readAllLines(origenPath);
            //Files.readString()
            Collections.sort(lines);
            Path destinoPath = Paths.get(b.getAbsolutePath());
            Files.write(destinoPath,lines);
        } catch (IOException e) {
            System.err.println("Error al procesar un archivo. Asegurate de que existe. "+e.getMessage());
        }
        */
        sc.close();
    }
}
