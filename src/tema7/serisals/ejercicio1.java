package tema7.serisals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "usuario.txt";
        //String fileName = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/datos.txt";
        Path filePath = Paths.get(fileName);
        try {
            System.out.println("Introduce tu nombre:");
            String nombre = sc.nextLine();
            System.out.println("Introduce tu edad:");
            String edad = sc.nextLine();
            System.out.println("Escribiendo en usuario.txt");
            //Files.writeString
            Files.writeString(filePath, ("Nombre: "+nombre + "\nEdad: "+edad), StandardOpenOption.APPEND,StandardOpenOption.CREATE);
            //Verify file content
            String content = Files.readString(filePath);
            System.out.println(content);
            //está todo copiado del escrituralecturatexto
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
