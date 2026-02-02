package Tema4.POO2;

import java.util.Scanner;

public class PruebaCuentas {
    public static void menu(){
        //bread
        System.out.println("Menu principal");
        System.out.println("-------------------------------------");
        System.out.println("a. Crear nueva persona");
        System.out.println("b. Crear Cuenta y asociarla a una persona");
    }
    public static void main(String[] args) {
        Persona[] persona = new Persona[3];
        Cuenta[] cuenta = new Cuenta[9];
        String nombre, dni;
        int pos, numc;
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        while(loop){
            menu();
            char doodad;
            doodad = sc.next().charAt(0);
            doodad = Character.toUpperCase(doodad);
            switch(doodad){
                case 'A':
                    System.out.println("Ingrese el nombre de la persona");
                    nombre = sc.next();
                    System.out.println("Ingrese el dni de la persona");
                    dni = sc.next();
                    System.out.println("Elige posicion de la persona (1-3)");
                    pos = sc.nextInt() - 1;
                    if(pos >= 0 && pos <= 2){
                        persona[pos] = new Persona(nombre,dni);
                    }else{
                        System.out.println("Posición invalida, persona no creada.");
                    }
                    break;
                case 'B':
                    boolean check = false;
                    System.out.println("¿A quien le va a pertenecer la cuenta (1-3)?");
                    pos = sc.nextInt() - 1;
                    if(pos >= 0 && pos <= 2&&persona[pos] != null){
                        System.out.println("Introduce un número de cuenta");
                        numc = sc.nextInt();
                        for(int i = 0; i < cuenta.length; i++){
                            if(cuenta[i] == null&&!check){
                                cuenta[i] = new Cuenta(numc);
                                persona[pos].setCuenta(i,cuenta);
                                check = true;
                            }
                        }
                    }else{
                        if(persona[pos] == null){
                            System.out.println("No hay nada ahi.");
                        }
                        System.out.println("Posición invalida, cuenta no creada.");
                    }
                    break;
                case 'C':
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