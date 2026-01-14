package Tema4.Ejercicio_3_y_4;

import java.util.Random;

public class Hero {
    public static final int finMaxHp = 390;
    public static final int finLevel = 30;
    public static final int finAtt = 144;
    public static final int finDef = 144;
    private final int baseHp = 110, baseAtt = 5, baseDef = 5, baseXp = 1, baseLvl = 1, baseMaxExp = 50;
    public String name;
    private int health, attack, defense, exp, level, maxHp, maxExp;

    public Hero(String name) {
        setName(name);
        this.health = baseHp;
        this.maxHp = baseHp;
        this.attack = baseAtt;
        this.defense = baseDef;
        this.exp = baseXp;
        this.level = baseLvl;
    }

    public void status(){ //toString
        System.out.println("Estado de "+ getName()+":");
        System.out.println("---------------------------------------------");
        System.out.println("Vida: " + getHealth()+"/"+getMaxHp());
        System.out.println("Nivel: " + getLevel());
        System.out.println("P. Exp: " + getExp()+"/"+getMaxExp());
        System.out.println("Ataque: " + getAttack());
        System.out.println("Defensa: " + getDefense());
    }
    public void drinkPotion(int health){
        if (health >= maxHp){
            setHealth(maxHp);
        }else{
            setHealth((health + 10));
        }
    }
    public void rest(int health){
        if (health >= maxHp){
            setHealth(maxHp);
        }else{
            setHealth((health + 50));
        }
    }
    public void squabble(Hero one, Hero two){
        Random r = new Random();
        two.health = two.getHealth() - Math.max((one.getAttack() - two.getDefense()), 50);
        one.exp = one.getExp() + (r.nextInt(50) + 10);
    }
    public void levelUp (int attack, int defense, int maxHp, int level, int exp, int maxExp){
        if(attack+3 >= finAtt){
            attack = finAtt;
            System.out.println("Ya estás muy fuerte.");
            setAttack((attack));
        }else{
            setAttack((attack + 3));
        }
        if (defense+3 >= finDef){
            defense = finDef;
            System.out.println("Ya eres muy resistente.");
            setDefense((defense));
        }else {
            setDefense((defense + 3));
        }
        if (maxHp+10 >= finMaxHp){
            maxHp = finMaxHp;
            System.out.println("Ya tienes demasiada vida.");
            setMaxHp(maxHp);
        }else{
            setMaxHp((maxHp+10));
        }
        if (level >= finLevel){
            level = finLevel;
            System.out.println("Estas en el máximo nivel.");
            setLevel((level));
        }else{
            setLevel((level+1));
        }
        setHealth(maxHp);
        setExp((exp-maxExp));
        setMaxExp(level);
    }
    public int getMaxExp() {
        return maxExp;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
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
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public void setMaxExp(int level) {
        this.maxExp = baseMaxExp * (level/2);
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
}
