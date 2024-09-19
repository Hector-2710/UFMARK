
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

        //menu(scanner);
       //int opcion = seleccionarOpcionMenu();


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

}