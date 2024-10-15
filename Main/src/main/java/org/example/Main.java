package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Estudiantes> estudiantes = cargarEstudiantes();

        if (estudiantes == null || estudiantes.isEmpty()) {
            System.out.println("No se encontraron estudiantes.");
            return;
        }

        iniciarSesion(estudiantes);
    }

    private static List<Estudiantes> cargarEstudiantes() {
        String csv = "estudiantes.csv"; // Nombre del archivo CSV
        return Estudiantes.cargardatos(csv);
    }

    private static void iniciarSesion(List<Estudiantes> estudiantes) {
        Scanner scanner = new Scanner(System.in);

        String correo = solicitarCorreo(scanner);
        String clave = solicitarClave(scanner);

        if (verificarCredenciales(estudiantes, correo, clave)) {
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + correo + "!");
        } else {
            System.out.println("Correo o clave incorrectos. Intente nuevamente.");
        }

        scanner.close();
    }

    private static String solicitarCorreo(Scanner scanner) {
        System.out.print("Ingrese su correo: ");
        return scanner.nextLine();
    }

    private static String solicitarClave(Scanner scanner) {
        System.out.print("Ingrese su clave: ");
        return scanner.nextLine();
    }

    private static boolean verificarCredenciales(List<Estudiantes> estudiantes, String correo, String clave) {
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getCorreo().equals(correo) && estudiante.getClave().equals(clave)) {
                return true;
            }
        }
        return false;
    }
}
