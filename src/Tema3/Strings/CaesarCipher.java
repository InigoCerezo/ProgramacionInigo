package Tema3.Strings;

import java.util.Scanner;

public class CaesarCipher {
    public static String encrypt(String mensaje) {
        if (mensaje == null) return "";
        StringBuilder resultado = new StringBuilder();
        char caracter;
        for (int i = 0; i < mensaje.length(); i++) {
            caracter = mensaje.charAt(i);
            if (caracter >= 'A' && caracter <= 'Z') {
                if (caracter == 'Z') {
                    resultado.append('A');
                } else {
                    resultado.append((char)(caracter + 1));
                }
            }
            else if (caracter >= '0' && caracter <= '9') {
                if (caracter == '9') {
                    resultado.append('0');
                } else {
                    resultado.append((char)(caracter + 1));
                }
            }
            else {
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }

    public static String decrypt(String mensajeCifrado) {
        if (mensajeCifrado == null) return "";
        char caracter;
        StringBuilder resultado = new StringBuilder();
        // Asumimos que el mensaje cifrado ya viene en mayúsculas del proceso anterior
        for (int i = 0; i < mensajeCifrado.length(); i++) {
            caracter = mensajeCifrado.charAt(i);
            // Invertir letras
            if (caracter >= 'A' && caracter <= 'Z') {
                if (caracter == 'A') {
                    resultado.append('Z');
                } else {
                    resultado.append((char)(caracter - 1));
                }
            }
            // Invertir dígitos
            else if (caracter >= '0' && caracter <= '9') {
                if (caracter == '0') {
                    resultado.append('9');
                } else {
                    resultado.append((char)(caracter - 1));
                }
            }
            // Otros caracteres
            else {
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String original, mayus, cipher, decipher;
        char point;
        System.out.println("Introduce un texto (cifrado o no): ");
        original = sc.nextLine();
        mayus = original.toUpperCase();
        menuCeasar();
        point = sc.next().charAt(0);
        switch (point){
            case 'a':
                cipher = encrypt(mayus);
                System.out.println("Cifrado:    " + cipher);
                break;
            case 'b':
                decipher = decrypt(mayus);
                System.out.println("Descifrado: " + decipher);
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }
    public static void menuCeasar (){
        System.out.println("Menu Caesar.");//menu global
        System.out.println("--------------------------------------");
        System.out.println("a - Cifrar");
        System.out.println("b - Descifrar");
    }
}