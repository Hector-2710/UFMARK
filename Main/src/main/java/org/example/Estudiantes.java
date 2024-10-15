package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estudiantes {

    private String correo;
    private String clave;
    private double saldo;

    public Estudiantes(String correo, String clave, double saldo) {
        this.correo = correo;
        this.clave = clave;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getClave() {
        return clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método para imprimir información del estudiante
    @Override
    public String toString() {
        return "Correo: " + correo + ", Clave: " + clave + ", Saldo: " + saldo;
    }

    // Método para cargar datos desde un archivo CSV
    public static List<Estudiantes> cargardatos(String csv) {
        List<Estudiantes> estudiantes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Estudiantes.class.getResourceAsStream("/" + csv)))) {
            String line;
            // Saltar la cabecera
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                String correo = datos[0].trim();
                String clave = datos[1].trim();
                double saldo = Double.parseDouble(datos[2].trim());
                estudiantes.add(new Estudiantes(correo, clave, saldo));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return estudiantes;
    }

    public static void main(String[] args) {
        String csv = "estudiantes.csv"; // Nombre del archivo CSV
        List<Estudiantes> estudiantes = Estudiantes.cargardatos(csv);

        // Imprimir todos los estudiantes
        if (estudiantes != null && !estudiantes.isEmpty()) {
            System.out.println("Estudiantes cargados:");
            for (Estudiantes estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        } else {
            System.out.println("No se encontraron estudiantes.");
        }
    }
}
