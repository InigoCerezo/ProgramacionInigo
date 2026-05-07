package Tema8.Formula1;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class AADDMain {
    public static final String ENDPOINT = "hogwarts.cvecwqk8iktz.us-east-1.rds.amazonaws.com";
    public static final String PUERTO = "5432";
    public static final String NOMBRE_BD = "f12006";
    public static final String URL = "jdbc:postgresql://" + ENDPOINT + ":" + PUERTO + "/" + NOMBRE_BD;
    public static final String USER = "postgres";
    public static final String PASSWD = "1234567890";
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        int e = 9;
        int guidance, constructorid;
        String nombre, apellido, nacionalidad, code, url;
        LocalDate dob;
        while(e != 0){
            menu();
            e = sc.nextInt();
            switch (e) {
                case 1:
                    System.out.println("nombre");
                    nombre = sc.next();
                    System.out.println("apellido");
                    apellido = sc.next();
                    System.out.println("nacionalidad");
                    nacionalidad = sc.next();
                    System.out.println("codigo (de tres letras, por ejemplo: DIS)");
                    code = sc.next();
                    System.out.println("url");
                    url = sc.next();
                    System.out.println("fecha nacimiento");
                    dob  = LocalDate.parse(sc.next());
                    System.out.println("id consructor");
                    constructorid = sc.nextInt();
                    Piloto chudling = new Piloto(nombre, apellido, nacionalidad, code, url, dob, constructorid);
                    pilotoCHUD.createPilot(chudling);
                    break;
                case 2:
                    System.out.println("introduce id");
                    guidance = sc.nextInt();
                    pilotoCHUD.readPilot(guidance);
                    sleep(1000);
                    break;
                case 3:
                    pilotoCHUD.readAllPilots();
                    sleep(2000);
                    break;
                case 4:
                    System.out.println("nombre");
                    nombre = sc.next();
                    System.out.println("apellido");
                    apellido = sc.next();
                    System.out.println("nacionalidad");
                    nacionalidad = sc.next();
                    System.out.println("codigo (de tres letras, por ejemplo: DIS)");
                    code = sc.next();
                    System.out.println("url");
                    url = sc.next();
                    System.out.println("fecha nacimiento");
                    dob  = LocalDate.parse(sc.next());
                    System.out.println("id consructor");
                    constructorid = sc.nextInt();
                    Piloto update = new Piloto(nombre, apellido, nacionalidad, code, url, dob, constructorid);
                    System.out.println("introduce id");
                    guidance = sc.nextInt();
                    pilotoCHUD.updatePilot(update, guidance);
                    break;
                case 5:
                    System.out.println("introduce id");
                    guidance = sc.nextInt();
                    pilotoCHUD.deletePilot(guidance);
                    break;
                case 6:
                    pilotoCHUD.showPilotClassification();
                    sleep(2000);
                    break;
                case 7:
                    pilotoCHUD.showBuildersClassification();
                    sleep(2000);
                    break;
                case 0:
                    System.out.println("ok");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
    public static void menu(){
        System.out.println("Menu");
        System.out.println("1. Agregar Piloto");
        System.out.println("2. Consultar Piloto");
        System.out.println("3. Ver Todos Los Pilotos");
        System.out.println("4. Actualizar Piloto");
        System.out.println("5. Eliminar Piloto");
        System.out.println("6. Mostrar Puntos de Pilotos");
        System.out.println("7. Mostrar Puntos de Constructores");
        System.out.println("0. Salir");
    }
}
