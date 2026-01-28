package Tema4.POO1.Ejercicio_3_y_4;

public class Ej3Main {
    public static void main(String[] args) {
        Hero hiro = new Hero ("Heroe");
        Hero vilan = new Hero ("Villano");
        System.out.println(hiro);

        hiro.peril(hiro);

        hiro.rest(hiro.getHp());
        hiro.drinkWater(hiro.getHp());
        hiro.squabble(vilan);
        hiro.levelUp();
        System.out.println(hiro);
    }
}
