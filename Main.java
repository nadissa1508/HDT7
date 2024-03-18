/**
 * Universidad del Valle de Guatemala
 * 
 * @author Angie Nadissa Vela López, 23764
 * @description clase que funciona como interfaz para que el usuario vea la traducción
 * que realiza el programa
 * @date última modificación 18/03/2024
 */

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Crear y llenar el arbol
        ReadFile reader = new ReadFile();
        BinarySearchTree dictionary = reader.insertBST("diccionario.txt");

        // leer el archivo para traducir su contenido
        String translatedText = reader.translateText("texto.txt", dictionary);
        System.out.println("\n\nDICCIONARIO INGLES-ESPAÑOL");
        System.out.println("\nLa traducción del texto ingresado es:");
        System.out.println("\n" + translatedText);
    }
}