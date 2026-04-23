package tema7.funko;

import java.io.Serializable;
import java.time.LocalDate;

public class Funko implements Serializable {
    private final String COD;
    private final String NOMBRE;
    private final String MODELO;
    private final double PRECIO;
    private final LocalDate FECHA_LANZAMIENTO;
    public Funko(){
        this.COD = "Funko";
        this.NOMBRE = "Funko";
        this.MODELO = "Funko";
        this.PRECIO = 0;
        this.FECHA_LANZAMIENTO = LocalDate.now();
    }
    public Funko(String COD, String NOMBRE, String MODELO, double PRECIO, LocalDate FECHA_LANZAMIENTO){
        this.COD = COD;
        this.NOMBRE = NOMBRE;
        this.MODELO = MODELO;
        this.PRECIO = PRECIO;
        this.FECHA_LANZAMIENTO = FECHA_LANZAMIENTO;
    }
    public String toString() {
        return "COD: "+ COD
                + ", NOMBRE: "+ NOMBRE
                + ", MODELO: "+ MODELO
                + ", PRECIO: "+ PRECIO
                + ", FECHA: "+ FECHA_LANZAMIENTO
                + "\n";
    }
    public String docWrite(){
        return getCOD()+","+getNOMBRE()+","+getMODELO()+","+getPRECIO()+","+getFECHA_LANZAMIENTO();
    }

    public String getCOD() {
        return COD;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getMODELO() {
        return MODELO;
    }

    public double getPRECIO() {
        return PRECIO;
    }

    public LocalDate getFECHA_LANZAMIENTO() {
        return FECHA_LANZAMIENTO;
    }
}
