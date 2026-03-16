package tema7.Documentos.Ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ejercicioB2 {
    static class Alumno {
        String nombre;
        int notaMedia;

        public Alumno(String nombre, int notaMedia) {
            this.nombre = nombre;
            this.notaMedia = notaMedia;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/Documentos/alumnos_notas.txt";
        List<Alumno> alumnos = new ArrayList<>();
        try (BufferedReader b = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = b.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] lineArray = line.split("\\s+");
                StringBuilder builder = new StringBuilder();
                int sumaNota = 0;
                int contadorNota = 0;
                for (String s : lineArray) {
                    try {
                        int nota = Integer.parseInt(s);
                        sumaNota += nota;
                        contadorNota++;
                    } catch (NumberFormatException e) {
                        if(builder.length()>0){
                            builder.append(' ');
                        }
                        builder.append(s);
                    }
                }
                if (contadorNota > 0) {
                    int media = sumaNota /contadorNota;
                    alumnos.add(new Alumno(builder.toString(),media));
                }
            }
            alumnos.sort((wan,too)-> Integer.compare(too.notaMedia, wan.notaMedia));
            for (Alumno alumno : alumnos) {
                System.out.println(alumno.nombre + ": " + alumno.notaMedia);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: "+e.getMessage());
        }
    }
}
