import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //llenar el arbol
        ReadFile reader = new ReadFile();
        reader.insertBST();

        //leer el archivo para traducir su contenido
        String translate = reader.readFile();
        System.out.println("\n\nDICCIONARIO INGLES-ESPAÑOL");
        System.out.println("\nLa traducción del texto ingresado es:");
        System.out.println("\n" + translate);
    }
}