package Tema8.Formula1;
import java.sql.*;

import static Tema8.Formula1.AADDMain.URL;
import static Tema8.Formula1.AADDMain.PASSWD;
import static Tema8.Formula1.AADDMain.USER;

public class pilotoCHUD {
    public static void createPilot(Piloto pilot){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String consul = "INSERT INTO drivers (code, forename, surname, dob, nationality, constructorid, url) VALUES ('"+pilot.getCode()+"','"+pilot.getNombre()+"','"+pilot.getApellido()+"','"+pilot.getDob()+"','"+pilot.getNacionalidad()+"',"+pilot.getConstructorid()+",'"+pilot.getUrl()+"')";
            PreparedStatement wassa = con2.prepareStatement(consul);
            if(wassa.executeUpdate()==1){
                System.out.println("Se ha podido insertar el nuevo conductor.");
            }else{
                System.err.println("No se ha podido insertar el nuevo conductor. ¿Seguro de que has puesto bien todos los valores?");
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readPilot(int guidance){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String consul = "SELECT * FROM drivers WHERE driverid="+guidance+";";
            PreparedStatement wassa = con2.prepareStatement(consul);
            ResultSet resultados = wassa.executeQuery();
            System.out.println("Pilotos Seleccionados:");
            while (resultados.next()) {
                int id = resultados.getInt("driverid");
                String cod = resultados.getString("code");
                String nombre = resultados.getString("forename");
                String apellido = resultados.getString("surname");
                String dob = resultados.getString("dob");
                String nationality = resultados.getString("nationality");
                int constructorid = resultados.getInt("constructorid");
                String url = resultados.getString("url");
                System.out.println("ID: "+id+" | Código: "+cod+" | Conductor: " + nombre + " " + apellido+ " | Nacido en: " + dob + " | Nacionalidad: "+nationality+" | ID Constructor: "+constructorid +" | URL: "+url);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readAllPilots(){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String consul = "SELECT * FROM drivers;";
            PreparedStatement wassa = con2.prepareStatement(consul);
            ResultSet resultados = wassa.executeQuery();
            while (resultados.next()) {
                int id = resultados.getInt("driverid");
                String cod = resultados.getString("code");
                String nombre = resultados.getString("forename");
                String apellido = resultados.getString("surname");
                String dob = resultados.getString("dob");
                String nationality = resultados.getString("nationality");
                int constructorid = resultados.getInt("constructorid");
                String url = resultados.getString("url");
                System.out.println("ID: "+id+" | Código: "+cod+" | Conductor: " + nombre + " " + apellido+ " | Nacido en: " + dob + " | Nacionalidad: "+nationality+" | ID Constructor: "+constructorid +" | URL: "+url);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updatePilot(Piloto pilot, int guidance){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String consul = "UPDATE drivers " +
                    "SET code = '"+pilot.getCode()+"', forename = '"+pilot.getNombre()+"', surname = '"+pilot.getApellido()+"', dob = '"+pilot.getDob()+"', nationality = '"+pilot.getNacionalidad()+"', constructorid = "+pilot.getConstructorid()+", url = '"+pilot.getUrl()+"' " +
                    "WHERE driverid = "+guidance+";";
            PreparedStatement wassa = con2.prepareStatement(consul);
            if(wassa.executeUpdate()==1){
                System.out.println("Se ha podido actualizar el conductor.");
            }else{
                System.err.println("No se ha podido actualizar el conductor. ¿Seguro de que has puesto bien todos los valores?");
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deletePilot(int id){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String hogwarConsulta6 = "DELETE FROM drivers WHERE driverid = '"+id+"';";
            PreparedStatement consulta6 = con2.prepareStatement(hogwarConsulta6);
            if(consulta6.executeUpdate()==1){
                System.out.println("Se ha podido borrar el piloto seleccionada.");
            }else{
                System.err.println("No se ha podido borrar el piloto seleccionado. ¿Seguro de que existe?");
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void showPilotClassification(){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String consul = "SELECT d.forename, d.surname, COUNT(r.points) poitn, r.position FROM drivers d JOIN results r ON d.driverid = r.driverid GROUP BY d.forename, d.surname, r.position ORDER BY poitn DESC;";
            PreparedStatement wassa = con2.prepareStatement(consul);
            ResultSet resultados = wassa.executeQuery();
            while (resultados.next()) {
                String nombre = resultados.getString("forename");
                String dob = resultados.getString("poitn");
                String poe = resultados.getString("position");
                String apellido = resultados.getString("surname");
                System.out.println("Conductor: " + nombre + " " + apellido+" | Puntos: " + dob+ " | Posicion: "+poe);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void showBuildersClassification(){
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            String consul = "SELECT c.name, r.position, COUNT(r.points) poitn FROM constructors c JOIN drivers d ON c.constructorid = d.constructorid JOIN results r ON d.driverid = r.driverid GROUP BY c.name, r.position ORDER BY poitn DESC;";
            PreparedStatement wassa = con2.prepareStatement(consul);
            ResultSet resultados = wassa.executeQuery();
            while (resultados.next()) {
                String nombre = resultados.getString("name");
                String dob = resultados.getString("poitn");
                String poe = resultados.getString("position");
                System.out.println("Conductor: " + nombre + " | Puntos: " + dob+ " | Posición: "+poe);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
