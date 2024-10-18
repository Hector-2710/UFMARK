package org.example;

public class Estudiante {
    private String correo;
    private String nombre;
    private String clave;
    private Tarjeta tarjeta;

    public Estudiante(String correo, String nombre, String clave, Tarjeta tarjeta) {
        this.correo = correo;
        this.nombre = nombre;
        this.clave = clave;
        this.tarjeta = tarjeta;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", tarjeta=" + tarjeta +
                '}';
    }
}
