package Tema4.POO2;

import java.text.DecimalFormat;
import java.util.Random;

public class Cuenta {

    private int numeroCuenta;
    private float saldo;

    public Cuenta() {
        Random rand = new Random();
        this.saldo = 0;
        this.numeroCuenta = rand.nextInt(1000000);
    }

    public Cuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return numeroCuenta + " - " + df.format(saldo);
    }
    public int getNumeroCuenta() {
        return numeroCuenta;
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
