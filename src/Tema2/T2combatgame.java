package Tema2;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Thread.sleep;

public class T2combatgame {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("este es mi juego"); //titulo
        //Creación y inicialización de variables
        Scanner a = new Scanner(System.in);
        int pat1, pvd1, pdf1, vel1, mpvd1, mpdf1, mvel1;
        int pat2, pvd2, pdf2, vel2, mpvd2, mpdf2, mvel2;
        int turncounter, turnpriority, crit, tiebreak;
        String hpleft1, hpleft2, hplost1, hplost2;
        boolean KO = false;
        /*
        pat1, pvd1 y demás → estadísticas del jugador 1. se introducen a mano por consola
        mpvd1, mpdf1 y mvel1 → estadísticas finales del jugador 1 que no deben cambiar
        pat2, pvd2 y demás → estadísticas del jugador 2. se introducen a mano por consola
        mpvd2, mpdf2 y mvel2 → estadísticas finales del jugador 2 que no deben cambiar
        turncounter → Contador de turnos
        turnpriority == 1 → turno de jugador 1, turnpriority ==2 → turno de jugador 2, turnpriority tiene otro valor → que dios nos ayude
        crit → critico (no se ve por co nsola
        tiebreak → moneda de cara o cruz para romper empates
        variables string → barras de vida (harapos)
        FIN DE INICIALIZACION DE VARIABLES (lo necesita si no el programa no tira bien)
         */
        System.out.println("JUGADOR 1:");
        do{
            System.out.println("Introduce los puntos de vida.");
            pvd1 = a.nextInt();
            while (pvd1 > 200 || pvd1 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pvd1 = a.nextInt();
            }
            System.out.println("Introduce los puntos de ataque.");
            pat1 = a.nextInt();
            while (pat1 > 200 || pat1 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pat1 = a.nextInt();
            }
            System.out.println("Introduce los puntos de defensa.");
            pdf1 = a.nextInt();
            while (pdf1 > 200 || pdf1 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pdf1 = a.nextInt();
            }
            System.out.println("Introduce los puntos de velocidad.");
            vel1 = a.nextInt();
            while (vel1 > 200 || vel1 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                vel1 = a.nextInt();
            }
            if (pat1 + pvd1 + pdf1 + vel1 > 500){
                System.out.println("La suma de todo no puede ser más de 500.");
            }

        }while (pat1 + pvd1 + pdf1 + vel1 > 500);
        sleep(1000);

        //Añade una pequeña pausa entre jugadores

        System.out.println("JUGADOR 2:");
        do{
            System.out.println("Introduce los puntos de vida.");
            pvd2 = a.nextInt();
            while (pvd2 > 200|| pvd2 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pvd2 = a.nextInt();
            }
            System.out.println("Introduce los puntos de ataque.");
            pat2 = a.nextInt();
            while (pat2 > 200|| pat2 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pat2 = a.nextInt();
            }
            System.out.println("Introduce los puntos de defensa.");
            pdf2 = a.nextInt();
            while (pdf2 > 200|| pdf2 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pdf2 = a.nextInt();
            }
            System.out.println("Introduce los puntos de velocidad.");
            vel2 = a.nextInt();
            while (vel2 > 200|| vel2 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                vel2 = a.nextInt();
            }
            if (pat1 + pvd1 + pdf1 + vel1 > 500){
                System.out.println("La suma de todo no puede ser más de 500.");
            }
        }while (pat2 + pvd2 + pdf2 + vel2 > 500);

        System.out.println("Que empiece el combate.\n");
        sleep(1000);
        mpvd1 = pvd1; mpdf1 = pdf1; mvel1 = vel1; mpvd2 = pvd2; mpdf2 = pdf2; mvel2 = vel2;
        hpleft1 = "-";
        hplost1 = "X";
        hpleft2 = "-";
        hplost2 = "X";
        //puntos normales sin variación, como el ataque no tiene forma de incrementar no está incluido
        turncounter = 0;
        while(!KO){
            turncounter++;
            System.out.println("Turno Nº"+turncounter);
            System.out.println("JUGADOR 1: " + pvd1 + "/" + mpvd1 + " " + hpleft1.repeat(pvd1/2)+hplost1.repeat((mpvd1-pvd1)/2));
            System.out.println("JUGADOR 2: " + pvd2 + "/" + mpvd2 + " " + hpleft2.repeat(pvd2/2)+hplost2.repeat((mpvd2-pvd2)/2));
            System.out.println("Turno de...");
            sleep(1000);
            Random breacher = new Random();
            crit = breacher.nextInt(20)+1;//el 0 no existe
            if (vel1 == vel2) {
                Random breaker = new Random();
                tiebreak = breaker.nextInt(2) +1;//Tiro de moneda para ver quien tiene el turno si las velocidades son iguales
                if (tiebreak == 1) {
                    System.out.println("JUGADOR 1!");
                    turnpriority=1;
                } else {
                    System.out.println("JUGADOR 2!");
                    turnpriority=2;
                }
            }else if (vel1 > vel2){
                System.out.println("JUGADOR 1!");
                turnpriority=1;
                pdf1= mpdf1;
            }else {
                System.out.println("JUGADOR 2!");
                turnpriority=2;
                pdf2= mpdf2;
            }
            System.out.println("¿Cual va a ser tu acción?");
            System.out.println("A. Atacar / B. Defender / C. Regenerar. / D. Focus / Cualquier otra tecla: Saltar turno");
            Scanner c = new Scanner(System.in);
            char act = c.next().charAt(0);
            switch (act) {
                case 'a':
                case 'A':
                    if (turnpriority==1){
                        if (crit ==20){
                            pvd2 = pvd2 - ((pat1-(pdf2/4))+25);
                            System.out.println("Jugador uno ataca a jugador dos.");
                            sleep(350);
                            System.out.println("CRITICO!!!");
                            sleep(150);
                            System.out.println("Hiciste "+ ((pat1-(pdf2/4))+25) + " de daño.\n");
                            sleep(450);
                        }else {
                            if (pat1-pdf2/2<=0){
                                pvd2 = pvd2-1;
                                System.out.println("Jugador uno ataca a jugador dos.");
                                sleep(350);
                                System.out.println("Poco eficaz...");
                                sleep(150);
                                System.out.println("Hiciste 1 de daño.\n");
                                sleep(450);
                            }else{
                                pvd2 = pvd2 - (pat1-pdf2/2);
                                System.out.println("Jugador uno ataca a jugador dos.");
                                sleep(350);
                                System.out.println("Hiciste "+ (pat1-pdf2/2) + " de daño.\n");
                                sleep(450);
                            }
                        }
                    }else{
                        if (crit ==20){
                            pvd1 = pvd1 - ((pat2-(pdf1/4))+25);
                            System.out.println("Jugador dos ataca a jugador uno.");
                            sleep(350);
                            System.out.println("CRITICO!!!");
                            sleep(150);
                            System.out.println("Hiciste "+ ((pat2-(pdf1/4))+25) + " de daño.\n");
                            sleep(450);
                        }else {
                            if (pat2-pdf1/2<=0){
                                pvd1 = pvd1-1;
                                System.out.println("Jugador dos ataca a jugador uno.");
                                sleep(350);
                                System.out.println("Poco eficaz...");
                                sleep(150);
                                System.out.println("Hiciste 1 de daño.\n");
                                sleep(450);
                            }else{
                                pvd1 = pvd1 - (pat2-pdf1/2);
                                System.out.println("Jugador dos ataca a jugador uno.");
                                sleep(350);
                                System.out.println("Hiciste "+ (pat2-pdf1/2) + " de daño.\n");
                                sleep(450);
                            }
                        }
                    }
                    break;
                case 'b':
                case 'B':
                    if (turnpriority==1){
                        if(crit == 4){
                            pdf1 = pdf1 * 4;
                        }else {
                            pdf1 = pdf1 * 2;
                        }
                        System.out.println("Jugador uno se defiende.\n");
                        sleep(350);
                    }else {
                        if(crit == 4){
                            pdf2 = pdf2 * 4;
                        }else {
                            pdf2 = pdf2 * 2;
                        }
                        System.out.println("Jugador dos se defiende.\n");
                        sleep(350);
                    }
                    break;
                case 'c':
                case 'C':
                    if (turnpriority==1){
                        if(crit == 13){
                            System.out.println("Jugador uno restaura "+ (mpvd1 /2) +" puntos de vida.");
                            sleep(350);
                            pvd1 = pvd1+ mpvd1 /2;
                        }else {
                            System.out.println("Jugador uno restaura "+ (mpvd1 /8) +" puntos de vida.");
                            sleep(350);
                            pvd1 = pvd1+ mpvd1 /8;
                        }
                        if(pvd1 > mpvd1){
                            System.out.println("...Pero no ha ayudado mucho.");
                            pvd1 = mpvd1;
                        }
                    }else {
                        if(crit == 13){
                            System.out.println("Jugador dos restaura "+ (mpvd2 /2) +" puntos de vida.");
                            sleep(350);
                            pvd2 = pvd2+ mpvd2 /2;
                        }else {
                            System.out.println("Jugador dos restaura "+ (mpvd2 /8) +" puntos de vida.");
                            sleep(350);
                            pvd2 = pvd2+ mpvd2 /8;
                        }
                        if(pvd2 > mpvd2){
                            System.out.println("...Pero no ha ayudado mucho.");
                            pvd2 = mpvd2;
                        }
                    }
                    System.out.println(" ");
                    break;
                case 'd':
                case 'D':
                    if (turnpriority==1){
                        vel1 = mvel1 + vel1/10;
                        System.out.println("Jugador uno incrementa su velocidad.\n");
                        sleep(350);
                    }else{
                        vel2 = mvel2 + vel2/10;
                        System.out.println("Jugador dos incrementa su velocidad.\n");
                        sleep(350);
                    }
                    break;
                default:
                    System.out.println("Turno saltado.\n");
                    break;
            }
            Thread.sleep(500);
            if (pvd1<=0){//Check si el juego se termina para salir del bucle antes
                pvd1 = 0;
                System.out.println("JUGADOR 1: " + pvd1 + "/" + mpvd1 + " " + hplost1.repeat((mpvd1-pvd1)/2));
                System.out.println("JUGADOR 2: " + pvd2 + "/" + mpvd2 + " " + hpleft2.repeat(pvd2/2)+hplost2.repeat((mpvd2-pvd2)/2));
                System.out.println("BRAVO JUGADOR 2, HAS GANADO!!!!");
                KO= true;
            } else if (pvd2<=0) {
                pvd2 = 0;
                System.out.println("JUGADOR 1: " + pvd1 + "/" + mpvd1 + " " + hpleft1.repeat(pvd1/2)+hplost1.repeat((mpvd1-pvd1)/2));
                System.out.println("JUGADOR 2: " + pvd2 + "/" + mpvd2 + " " + hplost2.repeat((mpvd2-pvd2)/2));
                System.out.println("BRAVO JUGADOR 1, HAS GANADO!!!!");
                KO = true;
            }
            if (!KO) { //comprobación de KO para salir del bucle antes
                if (turnpriority==1) {
                    turnpriority++;
                    pdf2 = mpdf2;
                    System.out.println("TURNO DE JUGADOR 2");
                } else{
                    pdf1 = mpdf1;
                    turnpriority--;
                    System.out.println("TURNO DE JUGADOR 1");
                }
                crit = breacher.nextInt(20)+1;//el 0 nunca ha existido
                System.out.println("JUGADOR 1: " + pvd1 + "/" + mpvd1 + " " + hpleft1.repeat(pvd1/2) + hplost1.repeat((mpvd1-pvd1)/2));
                System.out.println("JUGADOR 2: " + pvd2 + "/" + mpvd2 + " " + hpleft2.repeat(pvd2/2) + hplost2.repeat((mpvd2-pvd2)/2));
                System.out.println("¿Cual va a ser tu acción?");
                System.out.println("A. Atacar / B. Defender / C. Regenerar. / D. Focus / Cualquier otra tecla: Saltar turno");
                act = c.next().charAt(0);
                switch (act) {
                    case 'a':
                    case 'A':
                        if (turnpriority == 1) {
                            if (crit == 20) {
                                pvd2 = pvd2 - ((pat1 - (pdf2 / 4)) + 25);
                                System.out.println("Jugador uno ataca a jugador 2.");
                                sleep(350);
                                System.out.println("CRITICO!!!");
                                sleep(150);
                                System.out.println("Hiciste " + ((pat1 - (pdf2 / 4)) + 25) + " de daño.\n");
                                sleep(450);
                            } else {
                                if (pat1 - pdf2 / 2 <= 0) {
                                    pvd2 = pvd2 - 1;
                                    System.out.println("Jugador uno ataca a jugador 2.");
                                    sleep(350);
                                    System.out.println("Poco eficaz...");
                                    sleep(150);
                                    System.out.println("Hiciste 1 de daño.\n");
                                    sleep(450);
                                } else {
                                    pvd2 = pvd2 - (pat1 - pdf2 / 2);
                                    System.out.println("Jugador uno ataca a jugador dos.");
                                    sleep(350);
                                    System.out.println("Hiciste " + (pat1 - pdf2 / 2) + " de daño.\n");
                                    sleep(450);
                                }
                            }
                        } else {
                            if (crit == 20) {
                                pvd1 = pvd1 - ((pat2 - (pdf1 / 4)) + 25);
                                System.out.println("Jugador dos ataca a jugador uno.");
                                sleep(350);
                                System.out.println("CRITICO!!!");
                                sleep(150);
                                System.out.println("Hiciste " + ((pat2 - (pdf1 / 4)) + 25) + " de daño.\n");
                                sleep(450);
                            } else {
                                if (pat2 - pdf1 / 2 <= 0) {
                                    pvd1 = pvd1 - 1;
                                    System.out.println("Jugador dos ataca a jugador uno.");
                                    sleep(350);
                                    System.out.println("Poco eficaz...");
                                    sleep(150);
                                    System.out.println("Hiciste 1 de daño.\n");
                                    sleep(450);
                                } else {
                                    pvd1 = pvd1 - (pat2 - pdf1 / 2);
                                    System.out.println("Jugador dos ataca a jugador uno.");
                                    sleep(350);
                                    System.out.println("Hiciste " + (pat2 - pdf1 / 2) + " de daño.\n");
                                    sleep(450);
                                }
                            }
                        }
                        break;
                    case 'b':
                    case 'B':
                        if (turnpriority == 1) {
                            if (crit == 4) {
                                pdf1 = pdf1 * 4;
                            } else {
                                pdf1 = pdf1 * 2;
                            }
                            System.out.println("Jugador uno se defiende.\n");
                            sleep(350);
                        } else {
                            if (crit == 4) {
                                pdf2 = pdf2 * 4;
                            } else {
                                pdf2 = pdf2 * 2;
                            }
                            System.out.println("Jugador dos se defiende.\n");
                            sleep(350);
                        }
                        break;
                    case 'c':
                    case 'C':
                        if (turnpriority == 1) {
                            if (crit == 13) {
                                System.out.println("Jugador uno restaura " + (mpvd1 / 2) + " puntos de vida.");
                                sleep(350);
                                pvd1 = pvd1 + mpvd1 / 2;

                            } else {
                                System.out.println("Jugador uno restaura " + (mpvd1 / 8) + " puntos de vida.");
                                sleep(350);
                                pvd1 = pvd1 + mpvd1 / 8;
                            }
                            if (pvd1 > mpvd1) {
                                System.out.println("...Pero no ha ayudado mucho.");
                                pvd1 = mpvd1;
                            }
                        } else {
                            if (crit == 13) {
                                System.out.println("Jugador dos restaura " + (mpvd2 / 2) + " puntos de vida.");
                                sleep(350);
                                pvd2 = pvd2 + mpvd2 / 2;
                            } else {
                                System.out.println("Jugador dos restaura " + (mpvd2 / 8) + " puntos de vida.");
                                sleep(350);
                                pvd2 = pvd2 + mpvd2 / 8; //cuanta más vida tienes más regeneras
                            }
                            if (pvd2 > mpvd2) {
                                System.out.println("...Pero no ha ayudado mucho.");
                                pvd2 = mpvd2;
                            }
                        }
                        System.out.println(" ");// salto de linea
                        break;
                    case 'd':
                    case 'D':
                        if (turnpriority == 1) {
                            vel1 = mvel1 + vel1 / 10;
                            System.out.println("Jugador uno incrementa su velocidad.\n");
                            sleep(350);
                        } else {
                            vel2 = mvel2 + vel2 / 10;
                            System.out.println("Jugador dos incrementa su velocidad.\n");
                            sleep(350);
                        }
                        break;
                    default:
                        System.out.println("Turno saltado.\n");
                        break;
                }
                Thread.sleep(500);
                if (pvd1 <= 0) {//check si el juego se termina para salir del bucle
                    pvd1 = 0;
                    System.out.println("JUGADOR 1: " + pvd1 + "/" + mpvd1 + " " + hplost1.repeat((mpvd1-pvd1)/2));
                    System.out.println("JUGADOR 2: " + pvd2 + "/" + mpvd2 + " " + hpleft2.repeat(pvd2/2) + hplost2.repeat((mpvd2-pvd2)/2));
                    System.out.println("BRAVO JUGADOR 2, HAS GANADO!!!!");
                    KO = true;
                } else if (pvd2 <= 0) {
                    pvd2 = 0;
                    System.out.println("JUGADOR 1: " + pvd1 + "/" + mpvd1 + " " + hpleft1.repeat(pvd1/2) + hplost1.repeat((mpvd1-pvd1)/2));
                    System.out.println("JUGADOR 2: " + pvd2 + "/" + mpvd2 + " " + hplost2.repeat((mpvd2-pvd2)/2));
                    System.out.println("BRAVO JUGADOR 1, HAS GANADO!!!!");
                    KO = true;
                }
            }
        }
    }
}
//i am shedletski im supposed to miss
//yea
//i am shed let's ski