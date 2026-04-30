package Tema8.Hogwarts;

import java.sql.*;
import java.util.Scanner;

public class ejercicioHogwart {
    private static final String ENDPOINT = "hogwarts.cvecwqk8iktz.us-east-1.rds.amazonaws.com";
    private static final String PUERTO = "5432";
    private static final String NOMBRE_BD = "hogwarts";
    private static final String URL = "jdbc:postgresql://" + ENDPOINT + ":" + PUERTO + "/" + NOMBRE_BD;
    private static final String USER = "postgres";
    private static final String PASSWD = "1234567890";
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean bread = true;
        int whirl;
        String icy;
        String aula;
        boolean wrong = false;
        while(bread) {
            icy = null;
            men();
            whirl = sc.nextInt();
            switch (whirl){
                case 1:
                    System.out.println("Introduce una de las casas disponibles: ");
                    System.out.println("(Gryffindor, Slytherin, Ravenclaw, Hufflepuff)");
                    icy = sc.next();
                    consultaEstudianteporCasa(icy);
                    break;
                case 2:
                    System.out.println("Introduce un nombre. NO INTRODUZCAS APELLIDO: ");
                    icy = sc.next();
                    obtenerMascotadeEstudiante(icy);
                    break;
                case 3:
                    numEstudiantesporCasa();
                    break;
                case 4:
                    System.out.println("Introduce la asignatura");
                    icy = sc.next();
                    System.out.println("Introduce el aula");
                    sc.nextLine();
                    aula = sc.nextLine();
                    System.out.println("¿Es obligatoria? (Y/N)");
                    boolean cata;
                    do{
                        if (sc.next().equals("Y")){
                            wrong = true;
                            cata = false;
                        } else if (sc.next().equals("N")) {
                            wrong = false;
                            cata = false;
                        } else {
                            cata = true;
                        }
                    }while(cata);
                    insertarAsignatura(icy, aula, wrong);
                    break;
                case 5:
                    System.out.println("Introduce la asignatura");
                    icy = sc.next();
                    System.out.println("Introduce el aula nueva");
                    sc.nextLine();
                    aula = sc.nextLine();
                    modificarAsignatura(icy, aula);
                    break;
                case 6:
                    System.out.println("Escribe el nombre de la asignatura a eliminar.");
                    icy = sc.next();
                    eliminarAsignatura(icy);
                    break;
                case 0:
                    bread = false;
                    break;
                default:
                    break;
            }
        }

    }
    //CONSULTA DE ESTUDIANTES POR CASA
    public static void consultaEstudianteporCasa(String select){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String hogwarConsulta1 = "SELECT e.nombre estudiante, e.apellido, c.nombre casa FROM Estudiante e INNER JOIN Casa c ON e.id_casa = c.id_casa WHERE c.nombre = '"+select+"';";
            PreparedStatement consulta1 = con2.prepareStatement(hogwarConsulta1);
            ResultSet resultados = consulta1.executeQuery();
            while (resultados.next()) {
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("estudiante");
                String casa = resultados.getString("casa");
                System.out.println("Estudiante: " + nombre + " " + apellido + ". Casa: " + casa);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //MASCOTA DE UN ESTUDIANTE ESPECÍFICO
    public static void obtenerMascotadeEstudiante(String selectable){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String hogwarConsulta2 = "SELECT e.nombre estudiante, e.apellido, m.nombre mascota FROM Estudiante e INNER JOIN Mascota m ON e.id_estudiante = m.id_mascota WHERE e.nombre = '"+selectable+"';";
            PreparedStatement consulta2 = con2.prepareStatement(hogwarConsulta2);
            ResultSet resultados = consulta2.executeQuery();
            while (resultados.next()) {
                String nombre = resultados.getString("estudiante");
                String apellido = resultados.getString("apellido");
                String mascota = resultados.getString("mascota");
                System.out.println("Estudiante: " + nombre + " " + apellido+ ". Mascota: " + mascota);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Nº ESTUDIAQNTES POR CASA
    public static void numEstudiantesporCasa(){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String hogwarConsulta3 = "SELECT c.nombre, COUNT(e.id_estudiante) FROM Casa c INNER JOIN Estudiante e ON c.id_casa = e.id_casa GROUP BY c.nombre;";
            PreparedStatement consulta3 = con2.prepareStatement(hogwarConsulta3);
            ResultSet resultados = consulta3.executeQuery();
            while(resultados.next()){
                String nombre_casa = resultados.getString("nombre");
                String numEstudiantes = resultados.getString("count");
                System.out.println("Casa: " + nombre_casa + ". Estudiantes: " + numEstudiantes);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //INSERTAR UNA NUEVA ASIGNATURA
    public static void insertarAsignatura(String nom, String aula, boolean real){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String hogwarConsulta4 = "INSERT INTO Asignatura (nombre,aula,obligatoria) VALUES ('"+nom+"','"+aula+"',"+real+")";
            PreparedStatement consulta4 = con2.prepareStatement(hogwarConsulta4);
            if(consulta4.executeUpdate()==1){
                System.out.println("Se ha podido insertar la nueva asignatura.");
            }else{
                System.err.println("No se ha podido insertar la nueva asignatura. ¿Seguro de que has puesto bien todos los valores?");
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //MODIFICAR AULA DE ASIGNATURA
    public static void modificarAsignatura(String nom, String aula){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String hogwarConsulta5 = "UPDATE Asignatura SET aula = '"+aula+"' WHERE nombre = '"+nom+"'";
            PreparedStatement consulta5 = con2.prepareStatement(hogwarConsulta5);
            if(consulta5.executeUpdate()==1){
                System.out.println("Se ha podido actualizar la asignatura seleccionada.");
            }else{
                System.err.println("No se ha podido actualizar la asignatura seleccionada. ¿Seguro de que has puesto bien todos los valores?");
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //ELIMINAR ASIGNATURA
    public static void eliminarAsignatura(String seleccion){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String hogwarConsulta6 = "DELETE FROM Asignatura WHERE nombre = '"+seleccion+"';";
            PreparedStatement consulta6 = con2.prepareStatement(hogwarConsulta6);
            if(consulta6.executeUpdate()==1){
                System.out.println("Se ha podido borrar la asignatura seleccionada.");
            }else{
                System.err.println("No se ha podido borrar la nueva asignatura seleccionada. ¿Seguro de que existe?");
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void men(){
        System.out.println("Menu");
        System.out.println("1. Consulta de estudiantes por casa");
        System.out.println("2. Obtener la mascota de un estudiante específico");
        System.out.println("3. Número de estudiantes por casa");
        System.out.println("4. Insertar una nueva asignatura");
        System.out.println("5. Modificar el aula de una asignatura");
        System.out.println("6. Eliminar una asignatura");

    }
}
