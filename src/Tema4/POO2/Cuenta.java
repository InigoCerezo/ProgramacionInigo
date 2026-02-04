package Tema4.POO2;

import java.text.DecimalFormat;
import java.util.Random;

public class Cuenta {

    private int numCuenta;
    private float saldo;

    public Cuenta() {
        Random rand = new Random();
        this.saldo = 0;
        this.numCuenta = rand.nextInt(1000000);
    }

    public Cuenta(int numeroCuenta) {
        this.numCuenta = numeroCuenta;
        this.saldo = 0;
    }
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return numCuenta + " - " + df.format(saldo);
    }
    public int getNumCuenta() {
        return numCuenta;
    }
    public String getSaldo() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(saldo);
    }
    public void abonos(int abono){
        this.saldo =  this.saldo + abono;
    }
    public void recibos(int recibo){
        this.saldo =  this.saldo - recibo;
    }
}
