package Tema4.POO2;

public class Cuenta {
    private final String numeroCuenta;
    private double saldo;

    public Cuenta(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public double getSaldo() { return saldo; }
    public String getNumeroCuenta() { return numeroCuenta; }

    public void recibirAbonos(double cantidad) {
        this.saldo += cantidad;
    }

    public void pagarRecibos(double cantidad) {
        this.saldo -= cantidad;
    }

    public String toString() {
        return "  -> [Cuenta: " + numeroCuenta + " | Saldo: " + saldo + "]";
    }
}
