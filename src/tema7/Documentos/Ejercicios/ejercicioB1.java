package tema7.Documentos.Ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ejercicioB1 {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        //está en un disco exterior pero te aseguro que funciona
        String fileName = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/Documentos/numeros.txt";
        String kek;
        int major = 0;
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        while((kek = b.readLine()) != null){
            int num = Integer.parseInt(kek);
            if (major < num){
                major = num;
            }
        }
        System.out.println(major);

    }
}
