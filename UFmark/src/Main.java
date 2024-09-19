
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        setUp();
    }

    public static void setUp() {

        String[] users = {"caja", "myha", "joaquin03"};
        String[] passwords = {"caja", "hola", "faundez_ufromail"};

        Scanner scanner = new Scanner(System.in);

        run(users, passwords, scanner);

        scanner.close();
    }

    public static void run(String[] users, String[] passwords, Scanner scanner) {

        System.out.println("Ingrese su nombre de usuario:");
        String user = scanner.nextLine();


        /*
            Si no encuentra al usuario en la lista de usuarios,
            se finaliza el proceso con << return >>.
        */
        if (!validateUser(users, user)) {
            System.out.println("Usuario" + user + " no encontrado");
            return;
        }

        System.out.println("Usuario encontrado\n");

       /*
            Si se valida el usuario, se obtiene el de la lista de usuarios.
        */
        int index = getIndex(users, user);

        System.out.println("Ingrese su contraseña:");
        String password = scanner.nextLine();

        /*
            Si el indice del usuario en la lista de usuario no coincide
            con la contraseña en la lista de contraseñas, se finaliza
            el proceso conn << return >>.
        */
        if (!validateCredentials(passwords, index, password)) {
            System.out.println("Contraseña incorrecta para el usuario " + user);
            return;
        }

        System.out.println("Contraseña correcta\n");


        /*
            Si el usuario y la contraseña coinciden, se imprime un mensaje de bienvenida.
        */
        System.out.println("Bienvenido " + user);

        // llamamos al menu //

        menu(scanner);
        int opcion = seleccionarOpcionMenu();


    }

    public static boolean validateUser(String[] usersArr, String user) {

        /*
            Se recorre la lista de usuarios, si el usuario
            se encuentra en la lista, se retorna << true >>
            y en caso contrario, se retorna << false >>.

            << String u >> Corresponde a la variable que
            recorre la lista de usuarios.
        */
        for (String u : usersArr) {
            if (u.equals(user)) {
                return true;
            }
        }

        return false;
    }

    public static int getIndex(String[] arr, String value) {

        /*
            << index >> se inicializa en -1, porque una
            posicion en una array es siempre >= 0
        */
        int index = -1;


        /*
            Se recorre la lista de usuarios, si el usuario ingresado
            coindice con alguno en la lista, se retorna el indice de
            dicho usuario en la lista.

            << int i >> Corresponde a la variable que
            recorre la lista de usuarios.
        */
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static boolean validateCredentials(String[] passwordsArr, int index, String password) {

        /*
            Se valida si la contraseña ingresada coincide con la
            contraseña que esta en el mismo indice del usuario,
            si coinciden, se retorna << true >>,
            en caso contrario, se retorna << false >>.
        */
        if (passwordsArr[index].equals(password)) {
            return true;
        }

        return false;
    }

    public static void menu(Scanner scanner) {

        /* Mostrando el menu con las opciones disponible */

        int opcion = 0;
        do {
            System.out.println("-----menu-----");
            System.out.println("1.- menu barato");
            System.out.println("2.- menu intermedio");
            System.out.println("3.- menu caro");
            System.out.println("4.- salir");
            System.out.println("selecciona una opcion:");
            opcion = seleccionarOpcionMenu();

            if (validarOpcion(opcion)) {

                /* Si la opcion se valida continua ejecutando la opcion del menu llamada
                en caso de no ser validada continuara con el menu*/

                ejecutarOpcion(opcion);
            }
        } while ( opcion != 4);
    }

    public static int seleccionarOpcionMenu() {

        // Lee un valor entero ingresado por el usuario //

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static boolean validarOpcion(int opcion) {

        /* Valida que la opcion ingresada sea alguna de las que permite
        el menu y retorna un boleano dependiendo de la validacion */

        if (0 < opcion && opcion < 5) {
            return true;
        } else {
            System.out.println("opcion no valida");
            return false;
        }
    }

    public static void ejecutarOpcion(int opcion){

        /* Recibe la opcion en caso de ya ser validada y ejecuta para
        cada opcion solicitada un desplege del menu */

        switch (opcion){
            case 1:
                menuBarato();
                 break;
            case 2:
                menuIntermedio();
                break;
            case 3:
                menuCaro();
                break;
            case 4:
                System.out.println("saliendo del menuu");
                break;
        default:
                System.out.println("Opción no válida.");
        }
    }

    public static void menuBarato() {
        System.out.println("Plato principal : porotos");
        System.out.println("Postre : banana");
        System.out.println("Bebestible : agua");

    }

    public static void menuIntermedio() {
        System.out.println("Plato principal : arroz con pollo");
        System.out.println("Postre : chocolate");
        System.out.println("Bebestible : bebida");
    }

    public static void menuCaro() {
        System.out.println("Plato principal : piza");
        System.out.println("Postre : pie de limon");
        System.out.println("Bebestible : cafe");
    }




}