package Tema4.POO2;

import java.util.Scanner;
//no se lo que pasa, tiene errores pero el código corre y funciona como le digo, no se que es esto, tengo miedo
public class PruebaCuentas {

    static final int MAX_PERSONAS = 5;
    static Persona[] listaPersonas = new Persona[MAX_PERSONAS];
    static int contadorPersonas = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN BANCARIA ---");
            System.out.println("1. Instanciar Persona");
            System.out.println("2. Instanciar Cuenta a una Persona");
            System.out.println("3. Mostrar datos de una persona");
            System.out.println("4. Recibir nómina");
            System.out.println("5. Realizar pago");
            System.out.println("6. Transferencia");
            System.out.println("7. Imprimir morosos");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); //limpiar buffer

            switch (opcion) {
                case 1:
                    crearPersona();
                    break;
                case 2:
                    crearCuenta();
                    break;
                case 3:
                    mostrarPersona();
                    break;
                case 4:
                    realizarAbono();
                    break;
                case 5:
                    realizarPago();
                    break;
                case 6:
                    realizarTransferencia();
                    break;
                case 7:
                    mostrarMorosos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
    //formula 1
    public static void crearPersona() {
        if (contadorPersonas >= MAX_PERSONAS) {
            System.out.println("Error: Base de datos llena. No caben más personas.");
            return;
        }

        System.out.print("Introduce el DNI: ");
        String dni = sc.nextLine();

        if (buscarPersona(dni) == null) {
            listaPersonas[contadorPersonas] = new Persona(dni);
            contadorPersonas++;
            System.out.println("Persona creada correctamente. Total personas: " + contadorPersonas);
        } else {
            System.out.println("Error: Ya existe una persona con ese DNI.");
        }
    }

    //formula 2
    public static void crearCuenta() {
        Persona p = solicitarPersona();
        if (p != null) {
            System.out.print("Número de nueva cuenta: ");
            String num = sc.nextLine();
            System.out.print("Saldo inicial: ");
            double saldo = sc.nextDouble();
            p.anadirCuenta(new Cuenta(num, saldo));
        }
    }

    //formula 3
    public static void mostrarPersona() {
        Persona p = solicitarPersona();
        if (p != null) p.mostrarDatos();
    }

    //formula 4
    public static void realizarAbono() {
        Persona p = solicitarPersona();
        if (p != null) {
            System.out.print("Cuenta destino: ");
            String num = sc.nextLine();
            Cuenta c = p.getCuentaByNum(num);
            if (c != null) {
                System.out.print("Cantidad nómina: ");
                c.recibirAbonos(sc.nextDouble());
            } else {
                System.out.println("Cuenta no encontrada.");
            }
        }
    }

    //formula 5
    public static void realizarPago() {
        Persona p = solicitarPersona();
        if (p != null) {
            System.out.print("Cuenta origen pago: ");
            String num = sc.nextLine();
            Cuenta c = p.getCuentaByNum(num);
            if (c != null) {
                System.out.print("Cantidad a pagar: ");
                c.pagarRecibos(sc.nextDouble());
            } else {
                System.out.println("Cuenta no encontrada.");
            }
        }
    }

    //formula 6
    public static void realizarTransferencia() {
        System.out.println("> DATOS ORIGEN:");
        Persona pOrigen = solicitarPersona();
        if (pOrigen == null) return;
        System.out.print("Cuenta origen: ");
        Cuenta cOrigen = pOrigen.getCuentaByNum(sc.nextLine());
        if (cOrigen == null) { System.out.println("Cuenta no existe."); return; }

        System.out.println("> DATOS DESTINO:");
        Persona pDestino = solicitarPersona();
        if (pDestino == null) return;
        System.out.print("Cuenta destino: ");
        Cuenta cDestino = pDestino.getCuentaByNum(sc.nextLine());
        if (cDestino == null) { System.out.println("Cuenta no existe."); return; }

        System.out.print("Cantidad a transferir: ");
        double cant = sc.nextDouble();

        cOrigen.pagarRecibos(cant);
        cDestino.recibirAbonos(cant);
        System.out.println("Transferencia realizada.");
    }
    //formula 7
    public static void mostrarMorosos() {
        System.out.println("--- MOROSOS ---");
        boolean hay = false;
        for (int i = 0; i < contadorPersonas; i++) {
            if (listaPersonas[i].esMorosa()) {
                System.out.println("-> DNI Moroso: " + listaPersonas[i].getDni());
                listaPersonas[i].mostrarDatos();
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay morosos.");
    }

    //para no tener que escribir el código de abajo en cada formula
    public static Persona buscarPersona(String dni) {
        for (int i = 0; i < contadorPersonas; i++) {
            if (listaPersonas[i].getDni().equalsIgnoreCase(dni)) {
                return listaPersonas[i];
            }
        }
        return null;
    }
    public static Persona solicitarPersona() {
        System.out.print("Introduce DNI del titular: ");
        String dni = sc.nextLine();
        Persona p = buscarPersona(dni);
        if (p == null) System.out.println("Cliente no encontrado.");
        return p;
    }
}