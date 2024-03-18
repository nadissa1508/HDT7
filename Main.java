    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;

    public class Main {

        public static void main(String[] args) {
            //Crear y llenar el arbol
            ReadFile reader = new ReadFile();
            BinarySearchTree dictionary = reader.insertBST("diccionario.txt");

            //leer el archivo para traducir su contenido
            String translatedText = reader.translateText("texto.txt", dictionary);
            System.out.println("\n\nDICCIONARIO INGLES-ESPAÑOL");
            System.out.println("\nLa traducción del texto ingresado es:");
            System.out.println("\n" + translatedText);
        }
    }