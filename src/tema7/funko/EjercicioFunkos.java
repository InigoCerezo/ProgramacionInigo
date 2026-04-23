package tema7.funko;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class EjercicioFunkos {
    static String fileName = "/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/funko/funkos.csv";
    static ArrayList<Funko> chunko = new ArrayList<>();
    static ArrayList<Funko> marvel = new ArrayList<>();
    static ArrayList<Funko> disney = new ArrayList<>();
    static ArrayList<Funko> anime = new ArrayList<>();
    static ArrayList<Funko> otros = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException, InterruptedException {

        addall();
        char chosed;
        boolean morgan = true;
        while (morgan) {
            funkomenu();
            chosed = sc.next().charAt(0);
            switch (chosed) {
                case '1':
                    masFunkos();
                    break;
                case '2':
                    fueraFunkos();
                    break;
                case '3':
                    System.out.println("Cargando...");
                    sleep(1500);
                    mostrarFunkos();
                    break;
                case '4':
                    funkomenuModelo();
                    int mojuro = sc.nextInt();
                    mostrarFunkosPorModelo(mojuro);
                    break;
                case '5':
                    System.out.println("Cargando...");
                    sleep(1500);
                    funkoMasCaro();
                    break;
                case '6':
                    System.out.println("Cargando...");
                    sleep(1500);
                    mediaPrecioFunkos();
                    break;
                case '7':
                    System.out.println("Cargando...");
                    sleep(500);
                    funkos2023();
                    break;
                case '0':
                    System.out.println("Saliendo....");
                    morgan = false;
            }
        }
    }
    public static void funkomenu(){
        System.out.println("Menu Funkos");
        System.out.println("---------------------------------");
        System.out.println("1. Añadir funko");
        System.out.println("2. Borrar funko");
        System.out.println("3. Mostrar TODOS los funkos");
        System.out.println("4. Mostrar funkos por modelo");
        System.out.println("5. Mostrar funko más caro");
        System.out.println("6. Mostrar media de precio de funkos");
        System.out.println("7. Mostrar funkos de 2023");
        System.out.println("0. Salir");
    }
    public static void funkomenuModelo(){
        System.out.println("¿Cual modelo quieres ver?");
        System.out.println("1. Marvel");
        System.out.println("2. Disney");
        System.out.println("3. Anime");
        System.out.println("4. Otros");
        System.out.println("0. Salir");
    }
    public static void masFunkos(){
        String code;
        String nome;
        String modele;
        double price;
        LocalDate fechaLanzamiento;
        try{
            sc.nextLine(); //oh i lOVE BUFFERING1!!!!!!1
            System.out.println("Nombre del funko: ");
            nome = sc.nextLine();
            System.out.println("Modelo del funko: ");
            modele = sc.nextLine().toUpperCase();
            System.out.println("Fecha lanzamiento (formato yyyy-mm-dd): ");
            fechaLanzamiento = LocalDate.parse(sc.nextLine());
            System.out.println("Codigo del funko: ");
            code = sc.nextLine();
            System.out.println("Precio del funko: ");
            price = Double.parseDouble(sc.nextLine());
            Funko funko = new Funko(code,nome,modele,price,fechaLanzamiento);
            chunko.add(funko);
            switch (funko.getMODELO()) {
                case "MARVEL":
                    marvel.add(funko);
                    break;
                case "DISNEY":
                    disney.add(funko);
                    break;
                case "ANIME":
                    anime.add(funko);
                    break;
                case "OTROS":
                    otros.add(funko);
                    break;
            }
            File archivo = new File(fileName);
            Path path = Paths.get(archivo.getAbsolutePath());
            Files.writeString(path, funko.docWrite(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            OutputFunkos salida = new OutputFunkos();
            try{
                salida.abrirFSerial();
                salida.escribirFSerial(chunko);
                salida.cerrarFSerial();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void fueraFunkos(){
        String code;
        String nome;
        String modele;
        double price;
        LocalDate fechaLanzamiento;
        System.out.println("Por número de funko, a cual quieres quitar? (1 - "+chunko.size()+")");
        int expunge = sc.nextInt();
        if(expunge!=0){
            while(expunge<1 || expunge>chunko.size()){
                System.out.println("Por favor ingrese un numero dentro de los valores validos.");
                expunge = sc.nextInt();
            }
            expunge--;
            String code2 = chunko.get(expunge).getCOD();
            String nome2 = chunko.get(expunge).getNOMBRE();
            String modele2 = chunko.get(expunge).getMODELO();
            double price2 = chunko.get(expunge).getPRECIO();
            LocalDate fechaLanzamiento2 = chunko.get(expunge).getFECHA_LANZAMIENTO();
            //chunko.removeIf(chunk -> chunk.getCOD().equals(code));
            try (BufferedReader b = new BufferedReader(new FileReader(fileName))) {
                String line;
                System.out.println(chunko.get(expunge));
                while ((line = b.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;
                    String[] pops = line.split(",");
                    try {
                        code = pops[0];
                        nome = pops[1];
                        modele = pops[2];
                        price = Double.parseDouble(pops[3]);
                        fechaLanzamiento = LocalDate.parse(pops[4]);
                        if(code2.equals(code)&&nome2.equals(nome)&&modele2.equals(modele)&&price2==price&&fechaLanzamiento2.equals(fechaLanzamiento)){
                            chunko.remove(expunge);
                            adiosArchivo(line);
                            System.out.println("Funko eliminado.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
                OutputFunkos salida = new OutputFunkos();
                try{
                    salida.abrirFSerial();
                    salida.escribirFSerial(chunko);
                    salida.cerrarFSerial();
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void mostrarFunkos() throws InterruptedException {
        ArrayList<Funko> funko;
        InputFunkos entrada = new InputFunkos();
        try{
            entrada.abrirFSerial();
            do{
                funko = entrada.leerFSerial();
                System.out.println(funko);
            }while(funko != null);
            entrada.cerrarFSerial();
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        /*
        for (int i = 0; i < chunko.size(); i++) {
            sleep(70);
            System.out.println("NUM: " + (i+1)+ " "+ chunko.get(i).toString());
        }
        */

    }
    public static void mostrarFunkosPorModelo(int choose) throws InterruptedException {
        switch (choose) {
            case 1:
                System.out.println("Cargando...");
                sleep(750);
                for (int i = 0; i < marvel.size(); i++) {
                    sleep(70);
                    System.out.println("NUM: " + (i+1)+ " "+ marvel.get(i).toString());
                }
                break;
            case 2:
                System.out.println("Cargando...");
                sleep(750);
                for (int i = 0; i < disney.size(); i++) {
                    sleep(70);
                    System.out.println("NUM: " + (i+1)+ " "+ disney.get(i).toString());
                }
                break;
            case 3:
                System.out.println("Cargando...");
                sleep(750);
                for (int i = 0; i < anime.size(); i++) {
                    sleep(70);
                    System.out.println("NUM: " + (i+1)+ " "+ anime.get(i).toString());
                }
                break;
            case 4:
                System.out.println("Cargando...");
                sleep(750);
                for (int i = 0; i < otros.size(); i++) {
                    sleep(70);
                    System.out.println("NUM: " + (i+1)+ " "+ otros.get(i).toString());
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
    public static void funkoMasCaro(){
        Funko caro =  new Funko();
        for (int i = 0; i < chunko.size(); i++) {
            if(caro.getPRECIO() < chunko.get(i).getPRECIO()){
                caro =  chunko.get(i);
            }
        }
        System.out.println("Funko mas caro: "  + caro);
    }
    public static void mediaPrecioFunkos(){
        double precio = 0;
        for (int i = 0; i < chunko.size(); i++) {
            precio += chunko.get(i).getPRECIO();
        }
        precio = precio/chunko.size();
        System.out.println("La media de lo que cuesta un funko: "  + precio);
    }
    public static void funkos2023(){
        int anio = 2023;
        for (int i = 0; i < chunko.size(); i++) {
            if(chunko.get(i).getFECHA_LANZAMIENTO().getYear()==anio){
                System.out.println(chunko.get(i).toString());
            }
        }
    }
    public static void addall(){
        String code;
        String nome;
        String modele;
        double price;
        LocalDate fechaLanzamiento;

        try (BufferedReader b = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = b.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] pops = line.split(",");
                try {
                    code = pops[0];
                    nome = pops[1];
                    modele = pops[2];
                    price = Double.parseDouble(pops[3]);
                    fechaLanzamiento = LocalDate.parse(pops[4]);
                    Funko funko = new Funko(code, nome, modele, price, fechaLanzamiento);
                    chunko.add(funko);

                    switch (funko.getMODELO()) {
                        case "MARVEL":
                            marvel.add(funko);
                            break;
                        case "DISNEY":
                            disney.add(funko);
                            break;
                        case "ANIME":
                            anime.add(funko);
                            break;
                        case "OTROS":
                            otros.add(funko);
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
            OutputFunkos salida = new OutputFunkos();
            try{
                salida.abrirFSerial();
                salida.escribirFSerial(chunko);
                salida.cerrarFSerial();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void adiosArchivo(String nofile) {
        try {
            File file = new File(fileName);
            if (!file.isFile()) {
                System.out.println("no hay file");
                return;
            }
            File tempFile = new File(file.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(nofile)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            if (!file.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            if (!tempFile.renameTo(file)){
                System.out.println("Could not rename file");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
