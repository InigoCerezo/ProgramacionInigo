package tema7.serisals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio2 {
    public static void main(String[] args) {
        String fileName = "usuario.txt";
        Path filePath = Paths.get(fileName);
        try {
            String content = Files.readString(filePath);
            System.out.println(content);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
