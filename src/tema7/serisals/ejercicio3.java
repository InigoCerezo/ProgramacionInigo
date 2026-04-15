package tema7.serisals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio3 {
    public static void main(String[] args) throws IOException {
        String fileName = "usuario.txt";
        Path filePath = Paths.get(fileName);
        int countword = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("bufferedReader");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
