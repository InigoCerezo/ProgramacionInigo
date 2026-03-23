package tema7.Documentos.Ejercicios;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ejercicioB4 {
    public static void main(String[] args) throws IOException {
        try{
            Scanner sc = new Scanner(System.in);
            int cant = 3;
            String nobrne = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/Documentos/usa_nombres.txt";
            String apleido = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/Documentos/usa_apellidos.txt";
            List<String> nombres = Files.readAllLines(Paths.get(nobrne));
            List<String> apellidos = Files.readAllLines(Paths.get(apleido));
            System.out.println("Introduce el archivo del archivo B4");
            String archivo = sc.next();
            archivo = archivo.trim() +".txt";
            Path path = Paths.get(archivo);
            if(path == null){
                create(archivo);
            }
            System.out.println("Introduce cuantos nombres quieres (1-244)");
            try{
                do {
                    cant = sc.nextInt();
                    if (cant <= 0 || cant > nombres.size()) {
                        System.out.println("Numero fuera de rango, por favor introducalo de nuevo (1-244)");

                    }
                }while (cant <= 0 || cant > nombres.size());
            }catch (InputMismatchException e){
                System.out.println("Entrada no válida" + e.getMessage());
            }
            Collections.shuffle(nombres);
            Collections.shuffle(apellidos);
            List<String> generate = new ArrayList<>();
            for (int i = 0; i < cant; i++) {
                String nombre = nombres.get(i);
                String apellido = apellidos.get(i);
                generate.add(nombre + " " + apellido);
            }
            try{
                Files.write(path, generate, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Archivo guardado correctamente");
            }catch (IOException e){
                System.out.println("Error al guardar el archivo: "  + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.err.println("Formato incorrecto.");
        }
        catch (Exception e){
            System.err.println("Error en ejecucion: " + e.getMessage());
        }
    }
    public static void create(String archivo){
        File fichero = new File(archivo);
        //createNewFile
        try {
            fichero.createNewFile();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
