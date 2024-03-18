/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764 
 * @description clase que se encarga de leer los archivos diccionario.txt y texto.txt
 * Al leer diccionario.txt utiliza la información dentro del archivo para llenar el arbol binario que
 * utilizamos como diccionario
 * Al leer texto.txt se encarga de traducir el contenido que se encuentre en el archivo de ingles a español,
 * de no encontrar alguna palabra en el diccionario la encerarrá entre asteriscos
 * @date última modificación 18/03/2024
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    
    /** 
     * @param fileName
     * @return BinarySearchTree
     * Se lee el texto diccionario.txt y los valores dentro de el se separan en pares y se rodean por parentesis
     * para crear las asociaciones, con dichas asociaciones se crea el arbol binario
     */
    public BinarySearchTree insertBST(String fileName) {
        BinarySearchTree dictionary = new BinarySearchTree();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String linea;
            while ((linea = br.readLine()) != null) {
                //separar asociaciones
                String[] palabras = linea.split(",\\s*");

                if (palabras.length == 2) {
                    //asignar palabra en ingles como clave y la palabra en español como valor
                    String key = palabras[0].trim();
                    String value = palabras[1].trim();

                    //crear la asociacion e insertarla en el árbol
                    Association<String,String> association = new Association(key, value);
                    dictionary.insert(association);
                } else {
                    System.out.println("Formato de la línea incorrecto: " + linea);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error, no se puede leer el archivo " + fileName);
            e.printStackTrace();
        }

        return dictionary;
    }

    
    /** 
     * @param fileName
     * @param dictionary
     * @return String
     */
    public String translateText(String fileName, BinarySearchTree dictionary) {
        StringBuilder translatedText = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String linea;
            Association<String, String> association;
            while ((linea = br.readLine()) != null) {
                String[] words = linea.split("\\s+");

                for (String word : words) {
                    String translatedWord = "";
                    association = dictionary.search(new Association(word, ""));
                    if (association != null) {
                        translatedWord = association.getValue();
                    } else {
                        translatedWord = "*" + word + "*";
                    }
                    translatedText.append(translatedWord).append(" ");
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error, no se puede leer el archivo " + fileName);
            e.printStackTrace();
        }
        return translatedText.toString();
    }

}
