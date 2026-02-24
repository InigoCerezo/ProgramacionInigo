package tema6.Ej1;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String matricula;

    public Vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public Vehiculo() {
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    //el toString lo ponemos aqui?
    public String toString() {
        return marca + " " + modelo + " (Matrícula: " + matricula + ")";
    }
}
