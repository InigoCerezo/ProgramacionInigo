package Tema8.Formula1;

import java.time.LocalDate;

public class Piloto {
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private String code;
    private String url;
    private LocalDate dob;
    private int constructorid;

    public Piloto(String nombre, String apellido, String nacionalidad, String code,  String url, LocalDate dob, int constructorid) {
        setNombre(nombre);
        setApellido(apellido);
        setNacionalidad(nacionalidad);
        setCode(code);
        setUrl(url);
        setDob(dob);
        setConstructorid(constructorid);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getConstructorid() {
        return constructorid;
    }

    public void setConstructorid(int constructorid) {
        this.constructorid = constructorid;
    }
}
