package net.andresbustamante.framework.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Utilidad para manejo de archivos
 *
 * @author Andres Bustamante 
 */
public class FileUtils {

    /**
     * Guardar un archivo en el sistema de archivos utilizando un buffer, a
     * partir de datos leídos en bytes
     *
     * @param path Ruta completa de creación del archivo
     * @param data Arreglo de bytes con los datos a guardar en el archivo
     * @param bufferSize Tamaño del buffer para escritura del archivo
     * @throws IOException
     */
    public static void saveFile(String path, byte[] data, int bufferSize)
            throws IOException {
        byte[] buffer = new byte[bufferSize];
        Integer bytesRead;
        InputStream input = null;
        OutputStream output = null;

        try {
            input = new BufferedInputStream(new ByteArrayInputStream(data));
            File file = new File(path);
            output = new BufferedOutputStream(new FileOutputStream(file));

            while ((bytesRead = input.read(buffer)) > 0) {
                if (bytesRead < bufferSize) {
                    output.write(buffer, 0, bytesRead);
                } else {
                    output.write(buffer);
                }
            }
        } finally {
            input.close();
            output.close();
        }
    }

    /**
     * Guardar un archivo de texto en la ruta indicada
     * 
     * @param path Ruta completa del archivo a guardar
     * @param content Texto con el contenido del archivo
     * @throws IOException 
     */
    public static void saveFile(String path, String content) throws IOException {
        PrintWriter output = null;
        
        try {
            // Crear el archivo a partir del contenido
            File outputFile = new File(path);
            output = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputFile)));
            output.print(content);
        } finally {
            output.close();
        }
    }

    /**
     * Borrar un archivo del sistema de archivos
     *
     * @param path Ruta completa del archivo a borrar
     * @return Indica si el archivo fue borrado exitosamente
     */
    public static boolean removeFile(String path) {
        File file = new File(path);

        if (file.exists()) {
            return file.delete();
        } else {
            return false;
        }
    }
}
