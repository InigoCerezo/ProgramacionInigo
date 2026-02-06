package Tema4.POO2;

public class Persona {
    private String dni;
    private Cuenta[] cuentas;
    private int contadorCuentas;

    public Persona(String dni) {
        this.dni = dni;
        this.cuentas = new Cuenta[3];
        this.contadorCuentas = 0;
    }

    public String getDni() {
        return dni;
    }

    public void anadirCuenta(Cuenta nuevaCuenta) {
        if (contadorCuentas < 3) {
            cuentas[contadorCuentas] = nuevaCuenta;
            contadorCuentas++;
            System.out.println("Cuenta agregada con éxito.");
        } else {
            System.out.println("Error: Máximo de cuentas alcanzado para este usuario.");
        }
    }

    public boolean esMorosa() {
        for (int i = 0; i < contadorCuentas; i++) {
            if (cuentas[i].getSaldo() < 0) return true;
        }
        return false;
    }

    public Cuenta getCuentaByNum(String numero) {
        for (int i = 0; i < contadorCuentas; i++) {
            if (cuentas[i].getNumeroCuenta().equals(numero)) {
                return cuentas[i];
            }
        }
        return null;
    }

    public void mostrarDatos() {
        System.out.println("DNI: " + dni);
        if (contadorCuentas == 0) {
            System.out.println("  Sin cuentas asociadas.");
        } else {
            for (int i = 0; i < contadorCuentas; i++) {
                System.out.println(cuentas[i].toString());
            }
        }
    }
}