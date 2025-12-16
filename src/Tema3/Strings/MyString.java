package Tema3.Strings;

import java.util.Scanner;

public class MyString {
    public static void otroMenu (){
        System.out.println("Menu global.");//menu global
        System.out.println("--------------------------------------");
        System.out.println("a - Devolver frase invertida y en mayúsculas");
        System.out.println("b - Devolver el número de vocales de una frase");
        System.out.println("c - Devolver la palabra de mayor longitud de una frase");
        System.out.println("d - Buscar cuantas veces aparece una palabra de una frase");
        System.out.println("e - Contador de palabras de una frase");
        System.out.println("f - Formateador de números de teléfonos");
        System.out.println("g - Histograma de vocales de una frase");
        System.out.println("Otra opción - Salir");
    }
    public static boolean nope(String input){
        return input.isEmpty();
    }
    public static String inversor(String input){
        if (nope(input)){
            return "";
        }
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString();
    }
    public static String upper(String input){
        return input.toUpperCase();
    }
    //esos dos son uno
    public static int vocales(String input){
        if (nope(input)){
            return 0;
        }else {
            int tally = 0;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u'){
                    tally++;
                }
            }
            return tally;
        }
    }
    public static String longestWord(String input){
        if (nope(input)){
            return "";
        }else {
            String[] palabras = input.split(" ");
            String palabraLarga = "";
            for (String word : palabras) {
                if (word.length() > palabraLarga.length()){
                    palabraLarga = word
                    ;
                }
            }
            return palabraLarga;
        }
    }
    public static int snipe(String input, String target){
        int tally = 0;
        int index = 0;
        while((index = input.indexOf(target, index)) != -1){
            tally++;
            index +=target.length();
        }
        return tally;
    }
    public static int conteo(String input) {
        if (nope(input)){
            return 0;
        }else {
            String cleanInput = input.trim();
            if (cleanInput.isEmpty()) {
                return 0;
            }
            //aquí tenía que pedirle ayuda a la IA porque no tenia ni idea de esto
            String[] palabras = cleanInput.split("\\s+");
            return palabras.length;
        }
    }
    public static String telefono(String numero) {
        if (nope(numero)){
            return "";
        }else{
            String pais = numero.substring(0, 2);        // Primeros 2 caracteres
            String prefijo = numero.substring(2, 5);     // Siguientes 3 caracteres
            String resto = numero.substring(5);// El resto de la cadena
            return String.format("(+%s)-%s-%s", pais, prefijo, resto);
        }
    }
    public static void vocalesHistograma(String input) {
        if (nope(input)){
            System.out.println("¡No hay nada!");
            return;
        }
        // convertimos a minúsculas para contar 'A' y 'a' como iguales
        String textoBajo = input.toLowerCase();

        // mapeamos vocales y sus contadores
        // no tengo idea de como hacer que soporte tildes
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        int[] contadores = new int[5]; // Inicializados en 0 por defecto
        //inicializamos valores también
        char letra;

        // recorremos el texto carácter por carácter
        for (int i = 0; i < textoBajo.length(); i++) {
            letra = textoBajo.charAt(i);
            // verificamos si la letra coincide con alguna vocal
            for (int j = 0; j < vocales.length; j++) {
                if (letra == vocales[j]) {
                    contadores[j]++;
                    break; // salimos del bucle interno si encontramos coincidencia
                }
            }
        }
        // dibujamos el histograma
        for (int i = 0; i < vocales.length; i++) {
            System.out.print(vocales[i] + ": ");

            // bucle para dibujar la barra
            for (int k = 0; k < contadores[i]; k++) {
                System.out.print("*");
            }

            // mostramos el número al final para mayor claridad
            System.out.println(" (" + contadores[i] + ")");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String cad1, cad2;
        char choose, exit = 'n';
        while (exit == 'n' || exit == 'N'){
            otroMenu();
            System.out.println("Elige una opción: ");
            choose = sc.next().charAt(0);
            switch(choose){
                case 'a':
                    System.out.println("Introduce un texto: ");
                    sc.nextLine();
                    cad1 = sc.nextLine();
                    System.out.println("Input: " + cad1 + "\nEn mayúsculas: " + upper(cad1) + "\nInvertido: " + inversor(cad1) + "\nAmbas: " + upper(inversor(cad1)));
                    break;
                case 'b':
                    System.out.println("Introduce un texto: ");
                    sc.nextLine();
                    cad1 = sc.nextLine();;
                    System.out.println("Hay " + vocales(cad1) + " vocales.");
                    break;
                case 'c':
                    System.out.print("Introduce un texto: ");
                    sc.nextLine();
                    cad1 = sc.nextLine();
                    cad2 = longestWord(cad1);
                    System.out.println("La palabra mas larga es: " + cad2);
                    break;
                case 'd':
                    System.out.print("Introduce un texto: ");
                    sc.nextLine();
                    cad1 = sc.nextLine();
                    System.out.print("Introduce la palabra a buscar: ");
                    cad2 = sc.next();
                    System.out.println("Veces que se ha encontrado " + cad2 + " en el texto: " + snipe(cad1, cad2));
                    break;
                case 'e':
                    System.out.println("Introduce un texto: ");
                    sc.nextLine();
                    cad1 = sc.nextLine();
                    System.out.println("El texto introducido tiene " + conteo(cad1) + " palabras.");
                    break;
                case 'f':
                    System.out.println("Introduce un número de teléfono (en este formato: 34111222333): ");
                    cad1 = sc.next();
                    if(cad1.length()>6) {
                        System.out.println("Número introducido correctamente formateado: " + telefono(cad1));
                    }else{
                        System.out.println("Error. Numero mal introducido.");
                    }
                    break;
                case 'g':
                    System.out.println("Introduce un texto, pero no uses tildes: ");
                    sc.nextLine();
                    cad1 = sc.nextLine();
                    System.out.println("En '" + cad1 + "' hay: \n");
                    vocalesHistograma(cad1);
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            System.out.println("¿Quieres salir? (Y/N)"); //linea encargada de salir
            exit = sc.next().charAt(0);// otro caracter hace lo mismo que y, salir
        }
    }
}
