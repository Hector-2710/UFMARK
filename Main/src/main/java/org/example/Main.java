package org.example;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Estudiante> estudiantes = CargarDatosEstudiantes.cargarEstudiantes();
        Map<String, Tarjeta> tarjetas = CargarDatosTarjetas.cargarTarjetas();

        // Asocia las tarjetas a los estudiantes
        for (Estudiante estudiante : estudiantes) {
            Tarjeta tarjeta = tarjetas.get(estudiante.getCorreo());
            if (tarjeta != null) {
                estudiante = new Estudiante(estudiante.getCorreo(), estudiante.getNombre(), estudiante.getClave(), tarjeta);
            }
        }

        if (estudiantes.isEmpty()) {
            System.out.println("No se encontraron estudiantes.");
            return;
        }

        iniciarSesion(estudiantes);
    }

    private static void iniciarSesion(List<Estudiante> estudiantes) {
        Scanner scanner = new Scanner(System.in);

        String correo = solicitarCorreo(scanner);
        String clave = solicitarClave(scanner);

        if (verificarCredenciales(estudiantes, correo, clave)) {
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + correo + "!");
            Estudiante estudiante = estudiantes.stream()
                    .filter(e -> e.getCorreo().equals(correo))
                    .findFirst().orElse(null);
            System.out.println("Detalles del Estudiante: " + estudiante);
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

    private static boolean verificarCredenciales(List<Estudiante> estudiantes, String correo, String clave) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCorreo().equals(correo) && estudiante.getClave().equals(clave)) {
                return true;
            }
        }
        return false;
    }
}
