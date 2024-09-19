import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    }

    public static void menu() {
        System.out.println("Bienvenido!");
        System.out.println("Elige una opcion!");
        System.out.println("1. realizar pedido");
        System.out.println("2. verificar pedido");
        System.out.println("3. cancelar pedido");
        System.out.println("4. Salir");
    }

    public static int pedirOpcion() {
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        return opcion;
    }

    public static boolean validarOpcion(int opcion) {
        boolean estado = false;
        if (opcion >= 1 && opcion <= 4) {
            estado = true;
        }
        return estado;
    }

    public static String[] cargarDatos() {
        String[] correosEstudiantes = {"j.perez01@ufromail.cl",
                "m.gonzalez02@ufromail.cl",
                "c.fernandez03@ufromail.cl",
                "s.munoz04@ufromail.cl",
                "j.rodriguez05@ufromail.cl",
                "c.martinez06@ufromail.cl",
                " p.lopez07@ufromail.cl",
                "f.diaz08@ufromail.cl",
                "i.morales09@ufromail.cl",
                "p.soto10@ufromail.cl",
                "r.torres11@ufromail.cl",
                "a.gutierrez12@ufromail.cl",
                "f.vargas13@ufromail.cl",
                "c.silva14@ufromail.cl",
                "n.contreras15@ufromail.cl",
                "v.espinoza16@ufromail.cl",
                "f.sandoval17@ufromail.cl",
                "n.ramirez18@ufromail.cl",
                "a.vega19@ufromail.cl",
                "v.arias20@ufromail.cl",
                "c.bustos21@ufromail.cl",
                "p.fuentes22@ufromail.cl",
                "e.rivas23@ufromail.cl",
                "c.araya24@ufromail.cl",
                "s.castro25@ufromail.cl",
                "a.miranda26@ufromail.cl",
                "f.reyes27@ufromail.cl",
                "t.vera28@ufromail.cl",
                "e.salas29@ufromail.cl",
                "l.palacios30@ufromail.cl"};
        return correosEstudiantes;
    }
}

