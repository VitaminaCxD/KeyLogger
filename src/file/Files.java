package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author VitaminaC
 * @version 1.0
 */
public class Files {

    //Carpeta y archivo de texto
    private File carpeta = new File(PATH_CARPETA);
    private File archivo = new File(PATH_ARCHIVO);

    //FileWriter
    private FileWriter fw;

    //Paths
    private static final String PATH_CARPETA = "C:\\ProyectoKeyLogger";
    private static final String PATH_ARCHIVO = "C:\\ProyectoKeyLogger\\Texto.txt";

    //Método para guardar el texto obtenido del KeyLogger
    public void guardarTexto(String texto) {
        generarArchivos();
        try {
            fw = new FileWriter(archivo);
            fw.write(texto);

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo. " + e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo. " + e);
            }
        }
    }

    //Generación de la carpeta y el archivo de texto
    private void generarArchivos() {
        //Creación de carpeta
        carpeta.mkdir();

        //Creación de archivo
        try {
            fw = new FileWriter(archivo, true);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo. " + e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo. " + e);
            }
        }

    }

}
