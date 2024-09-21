import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String[] usuarios = cargarCorreos();
        String[] contraseñas = cargarContraseñas();
        Scanner scanner = new Scanner(System.in);

        // cargamos los correos y contraseñas

        boolean usuarioValido = login(usuarios, contraseñas, scanner);

        if (usuarioValido == true) {
            menuPrincipal();
            int opcion = pedirOpcion();
            boolean validador = validarOpcion(opcion);

            // Si el usuario es valido llamamos al menu, pedimos y validamos su opcion

            if (validador == true) {
                ejecutarMenu(opcion);
            }
        }
        scanner.close();
    }

    public static boolean login(String[] correos, String[] contraseñas, Scanner scanner) {
        //Cargamos lista de correos, lista de contraseñas y scanner

        System.out.println("Ingrese su correo:");
        String correoUser = scanner.nextLine();

        if (!validarUsuario(correos, correoUser)) {
            System.out.println("Usuario" + correoUser + " no encontrado");
            return false;

            // Si validateUser retorna <false> significa que el correoUser no se encontro en la lista de correos
        }

        System.out.println("Usuario encontrado\n");

        int index = getIndex(correos, correoUser);

        System.out.println("Ingrese su contraseña:");
        String contraseñaUser = scanner.nextLine();

        if (!validarContraseña(contraseñas, index, contraseñaUser)) {
            System.out.println("Contraseña incorrecta para el usuario " + correoUser);
            return false;

            // Si validateUser retorna <false> significa que el la contraseñaUser no coincide con la de la lista
        }

        System.out.println("Contraseña correcta\n");
        System.out.println("Bienvenido " + correoUser);
        return true;
    }

    public static boolean validarContraseña(String[] contraseñas, int index, String contraseñaUser) {
        if (contraseñas[index].equals(contraseñaUser)) {
            return true;
        }
        return false;

        /* Si la contraseña ingresada por el usuario coincide con la guardada en la lista de
         contraseñas ( en el mismo index) retorna <true>, en caso contrario retorna <false> */
    }

    public static boolean validarUsuario(String[] correos, String correoUsuario) {
        //Cargamos lista de correos y un correo del usuario.

        for (String i : correos) {
            if (i.equals(correoUsuario)) {
                return true;
            }
        }
        return false;

        /*Recorremos una lista de correos , si el correo ingresado por el usuario coincide con alguno de
        la lista retorna <true>, si no coincide retorna <false> */
    }

    public static int getIndex(String[] correos, String correoUser) {

        int index = -1;

        for (int i = 0; i < correos.length; i++) {
            if (correos[i].equals(correoUser)) {
                index = i;
                break;
            }
        }
        return index;

        // Si correoUser se encuentra en la lista de correos retorna el indice en cual se encuentra
    }

    public static int pedirOpcion() {
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        return opcion;

        // Retorna un entero
    }

    public static boolean validarOpcion(int opcion) {
        boolean estado = false;
        if (opcion >= 1 && opcion <= 4) {
            estado = true;
        }
        return estado;

        // Si la opcion se encuentra en el menu retorna <true> en caso contrario retorna <false>
    }

    public static void ejecutarMenu(int opcion) {
        switch (opcion) {
            case 1:
                if (opcion == 1) {
                    mostrarPlatos();
                    int opcionPlatos = pedirOpcion();
                    if (validarOpcion(opcionPlatos) == true) {
                        seleccionarPlato(opcionPlatos);
                        break;
                    }
                }
            case 2:
                if (opcion == 2) {
                    System.out.println("aun no implementado");
                    break;
                }
            case 3:
                if (opcion == 3) {
                    System.out.println("aun no implementado");
                    break;
                }
            case 4:
                if (opcion == 4) {
                    break;
                }
        }
    }

    public static void seleccionarPlato(int opcionPlato) {
        switch (opcionPlato) {
            case 1: {
                if (opcionPlato == 1) {
                    platoBarato();
                    break;
                }
            }
            case 2: {
                if (opcionPlato == 2) {
                    platoIntermedio();
                    break;
                }
            }
            case 3: {
                if (opcionPlato == 3) {
                    platoCaro();
                    break;
                }
            }
            case 4: {
                if (opcionPlato == 4) {
                    break;
                }
            }
        }
    }

    public static void menuPrincipal() {

        System.out.println("Bienvenido!");
        System.out.println("Elige una opcion!");
        System.out.println("1. realizar pedido");
        System.out.println("2. verificar pedido");
        System.out.println("3. cancelar pedido");
        System.out.println("4. Salir");
    }

    public static void mostrarPlatos() {
        System.out.println("-----menu-----");
        System.out.println("1.- menu barato");
        System.out.println("2.- menu intermedio");
        System.out.println("3.- menu caro");
        System.out.println("4.- salir");
        System.out.println("selecciona una opcion:");
    }

    public static void platoBarato() {
        System.out.println("Plato principal : porotos");
        System.out.println("Postre : banana");
        System.out.println("Bebestible : agua");
    }

    public static void platoIntermedio() {
        System.out.println("Plato principal : arroz con pollo");
        System.out.println("Postre : chocolate");
        System.out.println("Bebestible : bebida");
    }

    public static void platoCaro() {
        System.out.println("Plato principal : piza");
        System.out.println("Postre : pie de limon");
        System.out.println("Bebestible : cafe");
    }

    public static String[] cargarCorreos() {
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

    public static String[] cargarContraseñas() {
        String[] listaContraseñas = {
                "pass1234", "qwerty56", "abcde789", "user2023", "letmein88",
                "welcome1", "secret123", "helloWorld7", "javaRocks9", "password99",
                "test12345", "secureCode8", "samplePass4", "myPassword1", "userPass02",
                "simple2024", "data123", "code4567", "randomUser3", "example88",
                "qwertyuiop1", "abcdef123", "login2023", "openSesame4", "admin567"
        };
        return listaContraseñas;
    }
}
