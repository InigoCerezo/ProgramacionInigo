package tema7.serisals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ejercicio1 {
    public static void main(String[] args) {
        String fileName = "datos.txt";
        //String fileName = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/datos.txt";
        Path filePath = Paths.get("datos.txt");


        //Files.writeString
        try {
            //Escribe contenido al fichero, borrando todo lo que haya
            Files.writeString(filePath, "Aquí escribo borrando todo el contendio anterior\n");
            //Escribe contenido al fichero, añadiendolo al final del mismo
            Files.writeString(filePath, "Aquí escribo añadiendo al final", StandardOpenOption.APPEND);

            //Verify file content
            String content = Files.readString(filePath);

            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
