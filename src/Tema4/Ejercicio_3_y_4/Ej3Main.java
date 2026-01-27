package Tema4.Ejercicio_3_y_4;

public class Ej3Main {
    public static void main(String[] args) {
        Hero hiro = new Hero ("Heroe");
        Hero vilan = new Hero ("Villano");
        hiro.peril(hiro);
        hiro.status();
        hiro.rest(hiro.getHp());
        hiro.drinkWater(hiro.getHp());
        hiro.squabble(hiro,vilan);
        hiro.levelUp(hiro.getAtt(),hiro.getDef(),hiro.getMaxHp(),hiro.getLevel(),hiro.getExp(),hiro.getMaxExp());
        hiro.status();
    }
}
