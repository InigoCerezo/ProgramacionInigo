package Tema4.Ejercicio_3_y_4;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Ej4Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int oleada = 0, enemycounter, turncount = 0, rest, drink, retreat1, retreat2, retreat3;
        char elec;
        String nombre;
        boolean check = false, fight, attack, retire1, retire2 = true, retire3 = true;
        System.out.println("Introduce el nombre de tu personaje:");
        nombre = sc.nextLine();
        Hero hero = new Hero(nombre);
        while(!check){
            sleep(1000);
            Hero villain1 = new Hero("Villano",(hero.getHp()- rand.nextInt(55)),(hero.getAtt()/2),(hero.getDef()/2),hero.getLevel());
            Hero villain2 = new Hero("Secuaz",(hero.getHp() - (rand.nextInt(35)+10)),(hero.getAtt()/2),(hero.getDef()/2),hero.getLevel());
            Hero villain3 = new Hero("Acólito",(hero.getHp() - (rand.nextInt(20)+40)),(hero.getAtt()/2),(hero.getDef()/2),hero.getLevel());
            fight = true;
            oleada++;
            enemycounter = (rand.nextInt(3)+1);
            switch (enemycounter){
                case 3:
                    System.out.println("¡"+villain1.getName() + " aparece para liquidarte!");
                    System.out.println("¡"+villain2.getName() + " aparece detras de " + villain1.getName() + "!");
                    System.out.println("¡"+villain3.getName() + " aparece para ayudar a " + villain1.getName() + " y "+villain2.getName() + "!");
                    retire3 = false;
                    retire2 = false;
                    retire1 = false;
                    break;
                case 2:
                    System.out.println("¡"+villain1.getName() + " aparece para liquidarte!");
                    System.out.println("¡"+villain2.getName() + " aparece detras de " + villain1.getName() + "!");
                    retire2 = false;
                    retire1 = false;
                    break;
                default:
                    System.out.println("¡"+villain1.getName() + " aparece para liquidarte!");
                    retire1 = false;
                    break;
            }
            retreat1 = rand.nextInt(9);
            retreat2 = rand.nextInt(9);
            retreat3 = rand.nextInt(9);
            if(!retire1&&retreat1 == 3){
                System.out.println(villain1.getName() + " decide retirarse.");
                retire1 = true;
                enemycounter--;
            }
            if (!retire2&&retreat2 == 7) {
                System.out.println(villain2.getName() + " decide retirarse.");
                retire2 = true;
                enemycounter--;
            }
            if (!retire3&&retreat3 == 5) {
                System.out.println(villain3.getName() + " decide retirarse.");
                retire3 = true;
                enemycounter--;
            }
            while(fight){
                turncount++;
                attack = false;
                while (!attack) {
                    System.out.println("TURNO Nº"+turncount);
                    System.out.println("¿Que vas a hacer? (A. Pelear / B. Ver estado)");
                    elec = sc.next().charAt(0);
                    elec = Character.toUpperCase(elec);
                    switch (elec) {
                        case 'A':
                            attack = true;
                            System.out.println("¿A quién vas a atacar?");
                            switch (enemycounter) {
                                case 3:
                                    System.out.println("Opciones: " + villain1.getName() + ", " + villain2.getName() + ", " + villain3.getName());
                                    sleep(100);
                                    System.out.println("Elige con A, B o C");
                                    break;
                                case 2:
                                    if (retire1) {
                                        System.out.println("Opciones: " + villain2.getName() + ", " + villain3.getName());
                                        sleep(100);
                                        System.out.println("Elige con B o C");
                                    } else if (retire2) {
                                        System.out.println("Opciones: " + villain1.getName() + ", " + villain3.getName());
                                        sleep(100);
                                        System.out.println("Elige con A o C");
                                    } else {
                                        System.out.println("Opciones: " + villain1.getName() + ", " + villain2.getName());
                                        sleep(100);
                                        System.out.println("Elige con A o B");
                                    }
                                    break;
                                default:
                                    if (retire1 && retire2) {
                                        System.out.println("Opciones: " + villain3.getName());
                                        sleep(100);
                                        System.out.println("No hay mucha elección aquí. Escoge C.");
                                    } else if (retire2 && retire3) {
                                        System.out.println("Opciones: " + villain1.getName());
                                        sleep(100);
                                        System.out.println("No hay mucha elección aquí. Escoge A.");
                                    } else {
                                        System.out.println("Opciones: " + villain2.getName());
                                        sleep(100);
                                        System.out.println("No hay mucha elección aquí. Escoge B.");
                                    }
                                    break;
                            }
                            elec = sc.next().charAt(0);
                            elec = Character.toUpperCase(elec);
                            switch (elec) {
                                case 'A':
                                    System.out.println("Decidiste attacar a " + villain1.getName() + "...");
                                    sleep(250);
                                    if (retire1) {
                                        System.out.println("...pero ya se había retirado.");
                                    } else {
                                        hero.squabble(hero, villain1);
                                        if (villain1.getHp() <= 0) {
                                            System.out.println(villain1.getName() + " se retira!");
                                            retire1 = true;
                                            enemycounter--;
                                        }
                                    }
                                    break;
                                case 'B':
                                    System.out.println("Decidiste attacar a " + villain2.getName() + "...");
                                    sleep(250);
                                    if (retire2) {
                                        System.out.println("...pero ya se había retirado.");
                                    } else {
                                        hero.squabble(hero, villain2);
                                        if (villain2.getHp() <= 0) {
                                            System.out.println(villain2.getName() + " se retira!");
                                            retire2 = true;
                                            enemycounter--;
                                        }
                                    }
                                    break;
                                case 'C':
                                    System.out.println("Decidiste attacar a " + villain3.getName() + "...");
                                    sleep(250);
                                    if (retire3) {
                                        System.out.println("...pero ya se había retirado.");
                                    } else {
                                        hero.squabble(hero, villain3);
                                        if (villain3.getHp() <= 0) {
                                            System.out.println(villain3.getName() + " se retira!");
                                            retire3 = true;
                                            enemycounter--;
                                        }
                                    }
                                    break;
                                case 'D':
                                    hero.peril(hero);
                                default:
                                    System.out.println("Turno saltado.\n");
                                    break;
                            }
                            break;
                        case 'B':
                            hero.status();
                            sleep(1000);
                            break;
                        default:
                            System.out.println("Opción invalida.");
                            break;
                    }
                }
                if (hero.getExp() >= hero.getMaxExp()) {
                    hero.levelUp(hero.getAtt(),hero.getDef(),hero.getMaxHp(),hero.getLevel(),hero.getExp(),hero.getMaxExp());
                }
                sleep(750);
                if(retire1&&retire2&&retire3) {
                    System.out.println(hero.getName() + " ha ganado!");
                    fight = false;
                }else {
                    System.out.println("Turno de los enemigos.");
                    if(!retire1){
                        villain1.fite(villain1, hero);
                    }
                    if(!retire2){
                        villain2.fite(villain2, hero);
                    }
                    if(!retire3){
                        villain3.fite(villain3, hero);
                    }
                    if (hero.getHp() <= 0) {
                        System.out.println(hero.getName() + " ha caido en combate!");
                        fight = false;
                        check = true;
                        sleep(1500);
                    }
                }
            }
            System.out.println("Turnos del último combate: "+ turncount);
            turncount = 0;
            drink = rand.nextInt(9);
            rest = rand.nextInt(99);
            if (drink == 5){
                hero.drinkWater(hero.getHp());
            }
            if (rest == 50){
                hero.rest(hero.getHp());
            }
        }
        System.out.println("Oleadas ganadas " + (oleada - 1));
    }
}
