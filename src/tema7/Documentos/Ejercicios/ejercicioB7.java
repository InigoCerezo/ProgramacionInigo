package tema7.Documentos.Ejercicios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ejercicioB7 {
    public static void main(String[] args) {
        String archivo = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/Documentos/Libros/lazarillo.txt";
        Map<String,Integer> mapa = new HashMap<>();
        int countline = 0;
        int countchar = 0;
        int countword = 0;
        List<Map.Entry<String,Integer>> lista = new ArrayList(mapa.entrySet());
        System.out.println("Iniciando...");
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String line = "";
            while ((line = br.readLine()) != null){
                countline++;
                countchar += line.length();
                String[] palabras = line.toLowerCase().split("[^a-záéíóúñü0-9]+");
                for (String palabra : palabras){
                    if (!palabra.isEmpty()){
                        countword++;
                        mapa.put(palabra,mapa.getOrDefault(palabra,0)+1);
                    }
                }
            }
            lista.addAll(mapa.entrySet());
            lista.sort((a,b) -> b.getValue().compareTo(a.getValue()));
            System.out.println("Lineas leídas : " + countline);
            System.out.println("Palabras contadas : " + countword);
            System.out.println("Palabras únicas : " + lista.size());
            System.out.println("Caracteres contados (sin saltos de linea): " + countchar);
            Thread.sleep(1000);
            System.out.println("Top 10 palabras más comunes");
            int des = 10;
            for (int i = 0; i < des; i++){
                System.out.println((i +1)+". '" +  lista.get(i).getKey()+ "' con " +  lista.get(i).getValue() + " apariciones.");
            }
        }catch(IOException | InterruptedException e){
            System.err.println("El archivo no existe. ¿Estas seguro de que esa es la ruta que seguir?");
            System.out.println("Error: "+e.getMessage());
        }
    }
}
