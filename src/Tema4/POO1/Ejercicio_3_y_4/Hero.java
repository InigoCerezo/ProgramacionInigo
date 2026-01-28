package Tema4.POO1.Ejercicio_3_y_4;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Hero {
    public static final int FIN_MAX_HP = 390;
    public static final int FIN_LEVEL = 30;
    public static final int FIN_ATT = 144;
    public static final int FIN_DEF = 144;
    private final int baseHp = 110, baseAtt = 5, baseDef = 5, baseXp = 1, baseLvl = 1, baseMaxExp = 50;
    public String name;
    private int hp, attack, defense, exp, level, maxHp, maxExp;

    public Hero(){
        this.hp=baseHp;
        this.maxHp=baseHp;
        this.defense=baseDef;
        this.attack=baseAtt;
        this.level=baseLvl;
    }

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

    public String toString(){ //porque llamarlo "toString" suena CUTRE
        return String.format("Estado de %s: \n " +
                        "--------------------------------\n" +
                        "Vida: %d/%d\n" +
                        "Nivel: %d\n" +
                        "P. Exp: %d/%d\n" +
                        "Ataque: %d\n" +
                        "Defensa: %d\n",
                name, hp, maxHp, level, exp, maxExp, attack, defense);
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
        if (hp + 50 >= maxHp){
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
    public void squabble(Hero two) {
        Random r = new Random();
        String hpleft1 = "-", hplost1 = "X";
        two.hp = two.getHp() - Math.max((this.attack - two.getDef()), 1);
        System.out.println("Hiciste " + Math.max(this.attack- two.getDef(), 1)+" de daño.");
        if (two.getHp() > 0) {
            System.out.println("PV de "+two.getName()+": " + two.getHp() + "/" + two.getMaxHp() + " " + hpleft1.repeat(two.getHp()/2)+hplost1.repeat((two.getMaxHp()-two.getHp())/2));
        }
        if (this.level < 30) {
            this.exp = this.exp + (r.nextInt(50) + 10);
        }
    }
    public void fite(Hero two) throws InterruptedException {
        String hpleft1 = "-", hplost1 = "X";
        System.out.println("¡"+this.name + " ataca!");
        sleep(100);
        two.hp = two.getHp() - Math.max((this.attack - two.getDef()), 3);
        System.out.println("Hizo " + Math.max(this.attack- two.getDef(), 3)+" de daño.");
        System.out.println("PV de "+ two.getName()+": " + two.getHp() + "/" + two.getMaxHp() + " " + hpleft1.repeat(two.getHp()/2)+hplost1.repeat((two.getMaxHp()-two.getHp())/2));
        sleep(250);
    }
    public void levelUp (){
        int attack = this.attack;
        int defense = this.defense;
        int maxHp = this.maxHp;
        int level = this.level;

        System.out.println("FELICIDADES! HAS SUBIDO DE NIVEL!");
        if(this.attack+3 >= FIN_ATT){
            this.attack = FIN_ATT;
            System.out.println("Ya estás muy fuerte.");
        }else{
            System.out.println("Tu ataque ha subido de " + attack + " a " + (attack+3)+".");
            this.attack = this.attack + 3;
        }
        if (this.defense+3 >= FIN_DEF){
            this.defense = FIN_DEF;
            System.out.println("Ya eres muy resistente.");
        }else {
            this.defense = this.defense + 3;
            System.out.println("Tu defensa ha subido de " + defense + " a " + (defense+3)+".");
        }
        if (this.maxHp+10 >= FIN_MAX_HP){
            this.maxHp = FIN_MAX_HP;
            System.out.println("Ya tienes demasiada vida.");
        }else{
            System.out.println("Tu vida máxima ha subido de " + maxHp + " a " + (maxHp+10)+".");
            this.maxHp = this.maxHp + 10;
        }
        if (this.level+1 >= FIN_LEVEL){
            this.level = FIN_LEVEL;
            System.out.println("Estas en el máximo nivel.");
            this.level = level;
        }else{
            System.out.println("Tu nivel ha subido de " + level + " a " + (level+1)+".");
            this.level = level + 1;
        }
        System.out.println("Tu vida ha sido completamente recuperada.");
        setHp(getMaxHp());
        this.exp = Math.abs(this.exp - this.maxExp);
        if(this.level == FIN_LEVEL){
            this.exp = 0;
            this.maxExp = 1;
        }else{
            this.maxExp = baseMaxExp * this.level;
        }

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
