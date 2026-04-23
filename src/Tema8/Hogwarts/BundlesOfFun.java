package Tema8.Hogwarts;

import java.sql.*;

public class BundlesOfFun {
    public static void main(String[] args) {
        try(Connection con2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hogwarts", "postgres", "1234567890");){
            //CONSULTA BÁSICA CON SELECT
            String sentenciaSQL1 = "SELECT nombre, apellido FROM Profesor";
            PreparedStatement sentencia1 = con2.prepareStatement(sentenciaSQL1);
            ResultSet resultados = sentencia1.executeQuery();
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Profesor: " + apellido + ", " + nombre);
            }

            //FILTRADO DE DATOS CON WHERE
            String sentenciaSQL2 = "SELECT nombre, apellido FROM Estudiante WHERE fecha_nacimiento >1980-01-01;";
            PreparedStatement sentencia2 = con2.prepareStatement(sentenciaSQL2);
            resultados = sentencia2.executeQuery();
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }

            //ORDEN DE RESULTADOS CON ORDER BY
            String sentenciaSQL3 = "SELECT nombre, apellido FROM Estudiante ORDER BY fecha_nacimiento ASC;";
            PreparedStatement sentencia3 = con2.prepareStatement(sentenciaSQL3);
            resultados = sentencia3.executeQuery();
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }

            String sentenciaSQL4 = "SELECT c.nombre_casa, COUNT(e.id_estudiante) AS 'NumEstudiantes' FROM Casa c INNER JOIN Estudiante e ON c.id_casa = e.id_casa GROUP BY c.nombre_casa;";
            PreparedStatement sentencia4 = con2.prepareStatement(sentenciaSQL4);
            resultados = sentencia4.executeQuery();
            while(resultados.next()){
                String nombre_casa = resultados.getString("nombre_casa");
                String numEstudiantes = resultados.getString("NumEstudiantes");
                System.out.println("Casa: " + nombre_casa + ", " + numEstudiantes);
            }

            String sentenciaSQL5 = "SELECT a.nombre_asignatura, AVG(ea.calificacion) AS 'NotaMedia' FROM Asignatura a INNER JOIN Estudiante_Asignatura ea ON a.id_asignatura = ea.id_asignatura WHERE a.nombre_asignatura == 'Pociones' GROUP BY a.nombre_asignatura;";
            PreparedStatement sentencia5 = con2.prepareStatement(sentenciaSQL5);
            resultados = sentencia5.executeQuery();
            while(resultados.next()){
                String nomAsig = resultados.getString("nombre_asignatura");
                String media = resultados.getString("NotaMedia");
                System.out.println("Asignatura: " + nomAsig + ", " + media);
            }

            String sentenciaSQL6 = "SELECT DISTINCT anyo_curso FROM Estudiante;";
            PreparedStatement sentencia6 = con2.prepareStatement(sentenciaSQL6);
            resultados = sentencia6.executeQuery();
            while(resultados.next()){
                String anyo_curso = resultados.getString("anyo_curso");
                System.out.println("Año: " + anyo_curso);
            }

            String sentenciaSQL7 = "SELECT nombre FROM Estudiante WHERE apellido LIKE 'P%';";
            PreparedStatement sentencia7 = con2.prepareStatement(sentenciaSQL7);
            resultados = sentencia7.executeQuery();
            while(resultados.next()){
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + nombre);
            }


            String sentenciaSQL8 = "SELECT nombre, apellido FROM Estudiante WHERE apellido IN(4,5);";
            PreparedStatement sentencia8 = con2.prepareStatement(sentenciaSQL8);
            resultados = sentencia8.executeQuery();
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }

            String sentenciaSQL9 = "SELECT e.nombre, e.apellido, c.nombre_casa FROM Estudiante e INNER JOIN Casa c ON e.id_casa = c.id_casa WHERE c.nombre_casa = 'Gryffindor' OR 'Slytherin';";
            PreparedStatement sentencia9 = con2.prepareStatement(sentenciaSQL9);
            resultados = sentencia9.executeQuery();
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                String casa = resultados.getString("nombre_casa");
                System.out.println("Estudiante: " + apellido + ", " + nombre +  ", " + casa);
            }

            String sentenciaSQL10 = "SELECT nombre, apellido FROM Estudiante ORDER BY fecha_nacimiento ASC LIMIT 5;";
            PreparedStatement sentencia10 = con2.prepareStatement(sentenciaSQL10);
            resultados = sentencia10.executeQuery();
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }

            String sentenciaSQL11 = "SELECT e.nombre FROM Estudiante e INNER JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante INNER JOIN Asignatura a ON ea.id.asignatura = a. id_asignatura WHERE a.nombre_asignatura = 'Vuelo' AND ea.calificacion >= 8;";
            PreparedStatement sentencia11 = con2.prepareStatement(sentenciaSQL11);
            resultados = sentencia11.executeQuery();
            while(resultados.next()){
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + nombre);
            }

            String sentenciaSQL12 = "INSERT INTO Estudiante (nombre,apellido,id_casa,anyo_curso,fecha_nacimiento) VALUES ('Nymphadora','Tonks',4,7,1973-11-25);";
            PreparedStatement sentencia12 = con2.prepareStatement(sentenciaSQL12);
            resultados = sentencia12.executeQuery();
            resultados.next();
            /*
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }
             */


            String sentenciaSQL13 = "UPDATE Profesor SET nombre = 'Pomona Sprout' WHERE id_profesor IN(SELECT id_jefe FROM Casa WHERE nombre_casa = 'Hufflepuff');";
            PreparedStatement sentencia13 = con2.prepareStatement(sentenciaSQL13);
            resultados = sentencia13.executeQuery();
            resultados.next();
            /*
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }
             */

            String sentenciaSQL14 = "DELETE FROM Estudiante WHERE nombre = 'Tom Riddle';";
            PreparedStatement sentencia14 = con2.prepareStatement(sentenciaSQL14);
            resultados = sentencia14.executeQuery();
            resultados.next();
            /*
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }
             */

            String sentenciaSQL15 = "SELECT e.nombre, e.apellido, c.nombre_casa FROM Estudiante e JOIN Casa c ON e.id_casa = c.id_casa;";
            PreparedStatement sentencia15 = con2.prepareStatement(sentenciaSQL15);
            resultados = sentencia15.executeQuery();
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                String nombre_casa = resultados.getString("nombre_casa");
                System.out.println("Estudiante: " + apellido + ", " + nombre + ", " + nombre_casa);
            }

            String sentenciaSQL16 = "SELECT e.nombre, e.apellido, m.nombre_mascota, a.nombre_asignatura FROM Estudiante e LEFT JOIN Mascota m ON e.id_estudiante = m.id_estudiante LEFT JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante LEFT JOIN Asignatura a ON ea.id_asignatura = a.id_asignatura;";
            PreparedStatement sentencia16 = con2.prepareStatement(sentenciaSQL16);
            resultados = sentencia16.executeQuery();
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                String nombre_mascota = resultados.getString("nombre_mascota");
                String nombre_asignatura = resultados.getString("nombre_asignatura");
                System.out.println("Estudiante: " + apellido + ", " + nombre + ", " + nombre_mascota + ", " + nombre_asignatura);
            }

            String sentenciaSQL17 = "SELECT e.nombre FROM Estudiante e WHERE e.id_estudiante IN(SELECT ea.estudiante FROM Estudiante_Asignatura WHERE ea.calificacion > AVG(ea.calificacion) AND ea.id_asignatura IN(SELECT a.id_asignatura FROM Asignatura a));";
            PreparedStatement sentencia17 = con2.prepareStatement(sentenciaSQL17);
            resultados = sentencia17.executeQuery();
            while(resultados.next()){
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + nombre);
            }

            String sentenciaSQL18 = "SELECT c.nombre_casa FROM Casa c INNER JOIN Estudiante e ON c.id_casa = e.id_casa INNER JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante GROUP BY c.nombre_casa HAVING AVG(ea.calificacion)>7;";
            PreparedStatement sentencia18 = con2.prepareStatement(sentenciaSQL18);
            resultados = sentencia18.executeQuery();
            while(resultados.next()){
                String apellido = resultados.getString("apellido");
                String nombre = resultados.getString("nombre");
                System.out.println("Estudiante: " + apellido + ", " + nombre);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
