package Tema4.Ejercicio_3_y_4;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Hero {
    public static final int finMaxHp = 390;
    public static final int finLevel = 30;
    public static final int finAtt = 144;
    public static final int finDef = 144;
    private final int baseHp = 110, baseAtt = 5, baseDef = 5, baseXp = 1, baseLvl = 1, baseMaxExp = 50;
    public String name;
    private int hp, attack, defense, exp, level, maxHp, maxExp;

    public Hero(String name, int hp, int att, int def, int lvl) {
        setName(name);
        this.hp = hp;
        this.maxHp = hp;
        this.attack = att;
        this.defense = def;
        this.level = lvl;
    }
    public Hero(String name) {
        setName(name);
        this.hp = baseHp;
        this.maxHp = baseHp;
        this.attack = baseAtt;
        this.defense = baseDef;
        this.exp = baseXp;
        this.maxExp = baseMaxExp;
        this.level = baseLvl;
    }

    public void status(){ //porque llamarlo "toString" suena CUTRE
        System.out.println("Estado de "+ getName()+":");
        System.out.println("---------------------------------------------");
        System.out.println("Vida: " + getHp()+"/"+getMaxHp());
        System.out.println("Nivel: " + getLevel());
        System.out.println("P. Exp: " + getExp()+"/"+getMaxExp());
        System.out.println("Ataque: " + getAtt());
        System.out.println("Defensa: " + getDef());
    }
    public void drinkWater(int hp){
        System.out.println("De los enemigos, encontraste una botella de agua pura.");
        System.out.println("Te la bebiste toda de un trago antes de ir a por más enemigos.");
        if (hp >= maxHp){
            setHp(maxHp);
            System.out.println("Recuperaste toda tu vida. ("+getHp()+"/"+getMaxHp()+")");
        }else{
            setHp((getHp() + 10));
            System.out.println("Recuperaste 10 de vida. ("+getHp()+"/"+getMaxHp()+")");
        }
    }
    public void rest(int hp){
        System.out.println("No hay más enemigos visibles al horizonte.");
        System.out.println("Te tomaste un descanso.");
        if (hp >= maxHp){
            setHp(maxHp);
            System.out.println("Recuperaste toda tu vida. ("+getHp()+"/"+getMaxHp()+")");
        }else{
            setHp((hp + 50));
            System.out.println("Recuperaste 50 de vida. ("+getHp()+"/"+getMaxHp()+")");
        }
    }
    public void peril(Hero one){
        one.hp = 1;
        System.out.println("ay");
    }
    public void squabble(Hero one, Hero two) {
        Random r = new Random();
        String hpleft1 = "-", hplost1 = "X";
        two.hp = two.getHp() - Math.max((one.getAtt() - two.getDef()), 1);
        System.out.println("Hiciste " + Math.max(one.getAtt()- two.getDef(), 1)+" de daño.");
        if (two.getHp() > 0) {
            System.out.println("PV de "+two.getName()+": " + two.getHp() + "/" + two.getMaxHp() + " " + hpleft1.repeat(two.getHp()/2)+hplost1.repeat((two.getMaxHp()-two.getHp())/2));
        }
        one.exp = one.getExp() + (r.nextInt(50) + 10);
    }
    public void fite(Hero one, Hero two) throws InterruptedException {
        String hpleft1 = "-", hplost1 = "X";
        System.out.println("¡"+one.getName() + " ataca!");
        sleep(100);
        two.hp = two.getHp() - Math.max((one.getAtt() - two.getDef()), 1);
        System.out.println("Hizo " + Math.max(one.getAtt()- two.getDef(), 1)+" de daño.");
        System.out.println("PV de "+ two.getName()+": " + two.getHp() + "/" + two.getMaxHp() + " " + hpleft1.repeat(two.getHp()/2)+hplost1.repeat((two.getMaxHp()-two.getHp())/2));
        sleep(250);
    }
    public void levelUp (int attack, int defense, int maxHp, int level, int exp, int maxExp){
        System.out.println("FELICIDADES! HAS SUBIDO DE NIVEL!");
        if(attack+3 >= finAtt){
            attack = finAtt;
            System.out.println("Ya estás muy fuerte.");
            this.attack = attack;
        }else{
            System.out.println("Tu ataque ha subido de " + attack + " a " + (attack+3)+".");
            this.attack = attack + 3;
        }
        if (defense+3 >= finDef){
            defense = finDef;
            System.out.println("Ya eres muy resistente.");
            this.defense = defense;
        }else {
            this.defense = defense + 3;
            System.out.println("Tu defensa ha subido de " + defense + " a " + (defense+3)+".");
        }
        if (maxHp+10 >= finMaxHp){
            maxHp = finMaxHp;
            System.out.println("Ya tienes demasiada vida.");
            this.maxHp = maxHp;
        }else{
            System.out.println("Tu vida máxima ha subido de " + maxHp + " a " + (maxHp+10)+".");
            this.maxHp = maxHp + 10;
        }
        if (level+1 >= finLevel){
            level = finLevel;
            System.out.println("Estas en el máximo nivel.");
            this.level = level;
        }else{
            System.out.println("Tu nivel ha subido de " + level + " a " + (level+1)+".");
            this.level = level + 1;
        }
        System.out.println("Tu vida ha sido completamente recuperada.");
        setHp(getMaxHp());
        this.exp = Math.abs(exp - maxExp);
        this.maxExp = baseMaxExp * getLevel();
    }
    public int getMaxExp() {
        return maxExp;
    }
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getAtt() {
        return attack;
    }
    public int getDef() {
        return defense;
    }
    public int getExp() {
        return exp;
    }
    public int getLevel() {
        return level;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
}
