package tema7.Documentos.Ejercicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicioB6 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        int pos = 0;
        String pi = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/Documentos/pi-million.txt";
        Path path = Paths.get(pi);
        String contenido = Files.readString(path);
        System.out.println("Introduce un número para ver si aparece en pi");
        int num = sc.nextInt();
        String search = String.valueOf(num);
        char[] pees = contenido.toCharArray();
        char[] tgt = search.toCharArray();
        for (int i = 0; i <= pees.length - tgt.length; i++) {
            boolean b = true;
            for (int j = 0; j < tgt.length; j++) {
                if (pees[i + j] != tgt[j]) {
                    b = false;
                    break;
                }
            }
            if (b) {
                check = true;
                pos = i;
                break;
            }
        }
        if (check) {
            System.out.println("La secuencia '"+num+"' aparece en la posición '"+pos+"' de pi.");
        }else{
            System.out.println("La secuencia '"+num+"' no aparece en pi.");
        }
        sc.close();
    }
}
