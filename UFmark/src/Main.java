import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        String[] usuarios = cargarUsuarios();
        String[] contraseñas = cargarContraseñas();
        Scanner scanner = new Scanner(System.in);
        login( usuarios, contraseñas, scanner);
        scanner.close();
    }
    public static void login(String [] correos, String[] contraseñas,Scanner scanner){
        System.out.println("Ingrese su nombre de usuario:");
        String user = scanner.nextLine();


        /*
            Si no encuentra al usuario en la lista de usuarios,
            se finaliza el proceso con << return >>.
        */
        if (!validateUser(correos, user)) {
            System.out.println("Usuario" + user + " no encontrado");
            return;
        }

        System.out.println("Usuario encontrado\n");

       /*
            Si se valida el usuario, se obtiene el de la lista de usuarios.
        */
        int index = getIndex(correos, user);

        System.out.println("Ingrese su contraseña:");
        String password = scanner.nextLine();

        /*
            Si el indice del usuario en la lista de usuario no coincide
            con la contraseña en la lista de contraseñas, se finaliza
            el proceso conn << return >>.
        */
        if (!validateCredentials(contraseñas, index, password)) {
            System.out.println("Contraseña incorrecta para el usuario " + user);
            return;
        }

        System.out.println("Contraseña correcta\n");


        /*
            Si el usuario y la contraseña coinciden, se imprime un mensaje de bienvenida.
        */
        System.out.println("Bienvenido " + user);

    }
    public static void menuPrincipal() {
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

    public static String[] cargarUsuarios() {
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

    public static String[] cargarContraseñas(){
        String[] listaContraseñas = {"/)7Mn#cGP:", "gx5]=A]QHj", "DM-qVwV\\G.", "c+UzO`O<`u", "3(958:zg~3", "`ou6'*$4]r",
                "It?1<P)E/z", "\\B\"GfAAmJ'", "]ctdg,7>}d", "RS$%azgFa0", "MSdpmO]t$4", ":uj+MtVGnC",
                "CjrZf2Cocz", "*QhPwP#KwJ", "/!=+vy77:>", "zRV6anhC>Y", "t3./Zw3T]>", ".L~pSvs$?#",
                "4,2a\"Q=x<>", "X:nuW|qQ'w", "FIU>]|f2ZM", "V)jWn;I@Bh", "T=:_@3pA<|", "Iq.O:E6J#^",
                "tgEdwfY@.E", "Eg9IiQqVB`", "@jA\"'NxK?D", "cbgnSaK9V<", "1!+b:4Q4M;", "ZO!g!9N2Wl"};
        return listaContraseñas;
    }
    public static String pedirDatos(){
        Scanner scanner = new Scanner(System.in);
        String usuario = scanner.nextLine();
        return usuario;
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

