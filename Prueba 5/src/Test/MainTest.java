import avance1.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.stream.ImageInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private String[] correos;
    private String[] contraseñas;

    @BeforeEach
    void setup() {
         correos = new String[] {"correo1", "correo2", "correo3"};
         contraseñas = new String[] {"contraseña1", "contraseña2", "contraseña3"};
    }
    @AfterEach
    void tearDown(){
        /* limpia las listas */
        correos = new String[0];
        contraseñas = new String[0];
    }

    @Test
    /* prueba de un usuario valido */
    void testValidarUsuario() {
        assertTrue(Main.validarUsuario(correos, "correo1"));

    }

    @Test
    /* prueba de un usuario no valido */
    void testValidarUsuarioInvalido(){
        assertFalse(Main.validarUsuario(correos, "hola"));
    }
    @Test
    void testgetIndexValido(){
        assertEquals(2,Main.getIndex(correos, "correo3"));


    }
    @Test
    void testgetIndexInvalido(){
        assertEquals(-1, Main.getIndex(correos, "hola"));
    }
    @Test
    void testValidarContraseña(){
        int index = Main.getIndex(contraseñas, "contraseña1");
        assertTrue(Main.validarContraseña(contraseñas, index, "contraseña1"));
    }
    /* prueba de indices que no coinciden */
    @Test
    void testValidarContraseñaIncorrecta(){
        int index = Main.getIndex(contraseñas, "contraseña2");
        assertFalse(Main.validarContraseña(contraseñas, index, "contraseña3"));
    }

}