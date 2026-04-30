package Tema8.Hogwarts;

import java.sql.*;

public class BundlesOfFun {
    public static void main(String[] args) {
        final String ENDPOINT = "hogwarts.cvecwqk8iktz.us-east-1.rds.amazonaws.com";
        final String PUERTO = "5432";
        final String NOMBRE_BD = "hogwarts";
        final String URL = "jdbc:postgresql://" + ENDPOINT + ":" + PUERTO + "/" + NOMBRE_BD;
        final String USER = "postgres";
        final String PASSWD = "1234567890";
        try(Connection con2 = DriverManager.getConnection(URL, USER, PASSWD)){
            //CONSULTA BÁSICA CON SELECT
            String sentenciaSQL1 = "SELECT nombre, apellido FROM Profesor";
            PreparedStatement sentencia1 = con2.prepareStatement(sentenciaSQL1);
            ResultSet resultados = sentencia1.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Profesor: " + apellido + ", " + nombre);
            }

            //FILTRADO DE DATOS CON WHERE
            String sentenciaSQL2 = "SELECT nombre, apellido FROM Estudiante WHERE fecha_nacimiento >'1980-01-01';";
            PreparedStatement sentencia2 = con2.prepareStatement(sentenciaSQL2);
            resultados = sentencia2.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }

            //ORDEN DE RESULTADOS CON ORDER BY
            String sentenciaSQL3 = "SELECT nombre, apellido FROM Estudiante ORDER BY fecha_nacimiento ASC;";
            PreparedStatement sentencia3 = con2.prepareStatement(sentenciaSQL3);
            resultados = sentencia3.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }

            String sentenciaSQL4 = "SELECT c.nombre, COUNT(e.id_estudiante) FROM Casa c INNER JOIN Estudiante e ON c.id_casa = e.id_casa GROUP BY c.nombre;";
            PreparedStatement sentencia4 = con2.prepareStatement(sentenciaSQL4);
            resultados = sentencia4.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String nombre_casa = resultados.getString("nombre");
                String numEstudiantes = resultados.getString("count");
                System.out.println("Casa: " + nombre_casa + ". Estudiantes: " + numEstudiantes);
            }

            String sentenciaSQL5 = "SELECT a.nombre, AVG(ea.calificacion) FROM Asignatura a INNER JOIN Estudiante_Asignatura ea ON a.id_asignatura = ea.id_asignatura WHERE a.nombre = 'Pociones' GROUP BY a.nombre;";
            PreparedStatement sentencia5 = con2.prepareStatement(sentenciaSQL5);
            resultados = sentencia5.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String nomAsig = resultados.getString("nombre");
                String media = resultados.getString("avg");
                System.out.println("Asignatura: " + nomAsig + ", " + media);
            }

            String sentenciaSQL6 = "SELECT DISTINCT anyo_curso FROM Estudiante;";
            PreparedStatement sentencia6 = con2.prepareStatement(sentenciaSQL6);
            resultados = sentencia6.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String anyo_curso = resultados.getString("anyo_curso");
                System.out.println("Año: " + anyo_curso);
            }

            String sentenciaSQL7 = "SELECT nombre, apellido FROM Estudiante WHERE apellido LIKE 'P%';";
            PreparedStatement sentencia7 = con2.prepareStatement(sentenciaSQL7);
            resultados = sentencia7.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }


            String sentenciaSQL8 = "SELECT nombre, apellido, anyo_curso FROM Estudiante WHERE anyo_curso IN(4,5);";
            PreparedStatement sentencia8 = con2.prepareStatement(sentenciaSQL8);
            resultados = sentencia8.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                String anio = resultados.getString("anyo_curso");
                System.out.println("Estudiante: " + apellido + ", " + nombre + ". Año: " + anio);
            }

            String sentenciaSQL9 = "SELECT e.nombre estudiante, e.apellido, c.nombre casa, e.anyo_curso FROM Estudiante e INNER JOIN Casa c ON e.id_casa = c.id_casa WHERE (c.nombre = 'Gryffindor' OR c.nombre = 'Slytherin') AND (e.anyo_curso = 5);";
            PreparedStatement sentencia9 = con2.prepareStatement(sentenciaSQL9);
            resultados = sentencia9.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("estudiante");
                String casa = resultados.getString("casa");
                String anio = resultados.getString("anyo_curso");
                System.out.println("Estudiante: " + apellido + ", " + nombre +  ". Casa: " + casa + ". Año: " + anio);
            }

            String sentenciaSQL10 = "SELECT nombre, apellido FROM Estudiante ORDER BY fecha_nacimiento ASC LIMIT 5;";
            PreparedStatement sentencia10 = con2.prepareStatement(sentenciaSQL10);
            resultados = sentencia10.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }

            String sentenciaSQL11 = "SELECT e.nombre, ea.calificacion FROM Estudiante e INNER JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante INNER JOIN Asignatura a ON ea.id_asignatura = a.id_asignatura WHERE a.nombre = 'Vuelo' AND ea.calificacion >= 8;";
            PreparedStatement sentencia11 = con2.prepareStatement(sentenciaSQL11);
            resultados = sentencia11.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String nombre = resultados.getString("nombre");
                String nota = resultados.getString("calificacion");
                System.out.println("Estudiante: " + nombre + ". Calificación: " + nota);
            }

            String sentenciaSQL12 = "INSERT INTO Estudiante (nombre,apellido,id_casa,anyo_curso,fecha_nacimiento) VALUES ('Nymphadora','Tonks',4,7,'1973-11-25') ON CONFLICT (nombre, apellido) DO NOTHING;";
            PreparedStatement sentencia12 = con2.prepareStatement(sentenciaSQL12);
            if(sentencia12.executeUpdate() == 1){
                System.out.println("Se ha podido insertar el nuevo estudiante.");
            }else{
                System.err.println("No se ha podido insertar el nuevo estudiante. ¿Seguro de que has puesto bien todos los valores?\n¿Hay un estudiante con el mismo nombre?");
            }

            String sentenciaSQL13 = "UPDATE Profesor SET nombre = 'Pomona Sprout' WHERE id_profesor IN(SELECT id_jefe FROM Casa WHERE nombre = 'Hufflepuff');";
            PreparedStatement sentencia13 = con2.prepareStatement(sentenciaSQL13);
            if(sentencia13.executeUpdate() == 1){
                System.out.println("Se ha podido actualizar el profesor seleccionado.");
            }else {
                System.err.println("No se ha podido actualizar el profesor seleccionado. ¿Seguro de que existe?");
            }

            String sentenciaSQL14 = "DELETE FROM Estudiante WHERE nombre = 'Tom Riddle'";
            PreparedStatement sentencia14 = con2.prepareStatement(sentenciaSQL14);
            if(sentencia14.executeUpdate()==1){
                System.out.println("Se ha podido Borrar el estudiante seleccionado.");
            }else{
                System.err.println("No se ha podido borrar el estudiante seleccionado. ¿Seguro de que existe?");
            }
            String sentenciaSQL15 = "SELECT e.nombre estudiante, e.apellido, c.nombre casa FROM Estudiante e JOIN Casa c ON e.id_casa = c.id_casa;";
            PreparedStatement sentencia15 = con2.prepareStatement(sentenciaSQL15);
            resultados = sentencia15.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("estudiante");
                String nombre_casa = resultados.getString("casa");
                System.out.println("Estudiante: " + apellido + ", " + nombre + ". Casa: " + nombre_casa);
            }

            String sentenciaSQL16 = "SELECT e.nombre estudiante, e.apellido, m.nombre mascota, a.nombre asignatura FROM Estudiante e LEFT JOIN Mascota m ON e.id_estudiante = m.id_estudiante LEFT JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante LEFT JOIN Asignatura a ON ea.id_asignatura = a.id_asignatura;";
            PreparedStatement sentencia16 = con2.prepareStatement(sentenciaSQL16);
            resultados = sentencia16.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("estudiante");
                String nombre_mascota = resultados.getString("mascota");
                String nombre_asignatura = resultados.getString("asignatura");
                System.out.println("Estudiante: " + apellido + ", " + nombre + ". Mascota: " + nombre_mascota + ". Asignatura: " + nombre_asignatura);
            }

            String sentenciaSQL17 = "SELECT e.nombre FROM Estudiante e WHERE e.id_estudiante IN(SELECT ea.id_estudiante FROM Estudiante_Asignatura ea WHERE ea.calificacion > (SELECT AVG(ea.calificacion) FROM estudiante_asignatura ea) AND ea.id_asignatura IN(SELECT a.id_asignatura FROM Asignatura a WHERE a.nombre = 'Encantamientos'));";
            PreparedStatement sentencia17 = con2.prepareStatement(sentenciaSQL17);
            resultados = sentencia17.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + nombre);
            }

            String sentenciaSQL18 = "SELECT c.nombre FROM Casa c INNER JOIN Estudiante e ON c.id_casa = e.id_casa INNER JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante GROUP BY c.nombre HAVING AVG(ea.calificacion)>7;";
            PreparedStatement sentencia18 = con2.prepareStatement(sentenciaSQL18);
            resultados = sentencia18.executeQuery();
            System.out.println("--------------------SENTENCIA NUEVA--------------------------");
            while(resultados.next()){
                String nombre = resultados.getString("nombre");
                System.out.println("Casa: " + nombre);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
