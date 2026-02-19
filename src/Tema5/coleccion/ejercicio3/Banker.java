package Tema5.coleccion.ejercicio3;

import java.util.LinkedList;
import java.util.List;

public class Banker {
    // Listas paralelas para guardar los datos de los usuarios
    private List<String> nombres;
    private List<Integer> edades;
    private List<String> dnis;

    public Banker() {
        this.nombres = new LinkedList<>();
        this.edades = new LinkedList<>();
        this.dnis = new LinkedList<>();
    }

    // Ahora pasamos los datos sueltos en lugar de un objeto Usuario
    public void anadirACola(String nombre, int edad, String dni) {
        nombres.add(nombre);
        edades.add(edad);
        dnis.add(dni);
        System.out.println(nombre + " se ha unido al final de la cola.");
    }

    public void atenderPrimero() {
        if (nombres.isEmpty()) {
            System.out.println("La cola está vacía. No hay nadie esperando.");
        }else{
            String frontman = nombres.remove(0);
            edades.remove(0);
            String dnid = dnis.remove(0);
            System.out.println("Atendiendo en ventanilla a: " + frontman + " (DNI: " + dnid + ")...");
        }
    }

    public void abandonarCola(String dni) {
        int indice = dnis.indexOf(dni);

        if (indice != -1) {
            String goner = nombres.remove(indice);
            edades.remove(indice);
            dnis.remove(indice);
            System.out.println(goner + " se ha cansado de esperar y se ha ido.");
        } else {
            System.out.println("No se ha encontrado a nadie con el DNI " + dni + " en la cola.");
        }
    }

    public void mostrarEstado() {
        System.out.println("\n--- Estado actual de la cola ---");
        if (nombres.isEmpty()) {
            System.out.println("La cola está totalmente vacía.");
        } else {
            for (int i = 0; i < nombres.size(); i++) {
                System.out.println((i + 1) + ". " + nombres.get(i) + " (DNI: " + dnis.get(i) + ", " + edades.get(i) + " años)");
            }
        }
        System.out.println("--------------------------------\n");
    }
}

