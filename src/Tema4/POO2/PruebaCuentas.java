package Tema4.POO2;

import java.util.Scanner;

public class PruebaCuentas {
    public static void menu(){
        //bread
        System.out.println("Menu principal");
        System.out.println("-------------------------------------");
        System.out.println("a. Crear nueva persona");
        System.out.println("b. Crear Cuenta y asociarla a una persona");
        System.out.println("c. Mostrar datos de una persona");

    }
    public static void main(String[] args) {
        Persona[] persona = new Persona[3];
        Cuenta[] cuenta = new Cuenta[9];
        String nombre, dni;
        int numc, cont;
        boolean loop = true, check, check2;
        Scanner sc = new Scanner(System.in);
        while(loop){
            menu();
            char doodad;
            doodad = sc.next().charAt(0);
            doodad = Character.toUpperCase(doodad);
            switch(doodad){
                case 'A':
                    cont = 0;
                    check = true;
                    check2 = false;
                    while(!check2){
                        for(int i = 0; i < persona.length; i++){
                            if(persona[i] == null && check){
                                System.out.println("Ingrese el nombre de la persona");
                                nombre = sc.next();
                                System.out.println("Ingrese el dni de la persona");
                                dni = sc.next();
                                for (Persona value : persona) {
                                    while (value != null && value.getDni().equals(dni)) {
                                        System.out.println("DNI invalido, introduzca otro");
                                        dni = sc.next();
                                    }
                                }
                                persona[i] = new Persona(nombre, dni);
                                check = false;
                                check2 = true;
                            }else{
                                cont++;
                            }
                        }
                        if (cont == 3){
                            System.out.println("Has alcanzado el límite de personas.");
                        }
                    }
                    break;
                case 'B':
                    cont = 0;
                    check = false;
                    check2 = false;
                    while(!check2){
                        System.out.println("¿A quien le va a pertenecer la cuenta (introduce DNI)?");
                        dni = sc.next();
                        for (Persona value : persona) {
                            if (value == null) {
                                cont++;
                                if (cont == 3){
                                    System.out.println("No hay personas registradas.");
                                    check2 = true;
                                }
                            } else if (value.getDni().equals(dni)) {
                                for (int j = 0; j < cuenta.length; j++) {
                                    if (cuenta[j] == null && !check) {
                                        System.out.println("Introduce un número de cuenta");
                                        numc = sc.nextInt();
                                        cuenta[j] = new Cuenta(numc);
                                        value.setCuenta(j, cuenta);
                                        check = true;
                                        check2 = true;
                                    }else{
                                        System.out.println("Ya hay demasiadas cuentas en este ejercicio.");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 'C':
                    check = false;
                    System.out.println("¿A quien quieres ver (introduce DNI)?");
                    dni = sc.next();
                    while(!check){
                        for (Persona value : persona) {
                            if (value.getDni().equals(dni)) {
                                System.out.println(value.toString());
                            }else{
                                System.out.print("");
                            }
                        }
                    }
                    break;
                case 'D':
                    break;
                case 'E':
                    break;
                case 'F':
                    break;
                case 'G':
                    break;
                default:
                    loop = false;
            }
        }
    }
}