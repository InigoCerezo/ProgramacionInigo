package tema6.Ej2;

public class Perro extends Animal {
    //se me olvidó que era el override
    @Override
    public void comer() {
        System.out.println("El perro está comiendo carne hecha por su dueño.");
    }

    @Override
    public void hacerRuido() {
        System.out.println("¡Guau! ¡Guau!");
    }
    public void playBall() {
        System.out.println("El perro corre felizmente y te trae la pelota.");
    }
}