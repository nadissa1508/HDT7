import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public BinarySearchTree insertBST(String fileName) {
        BinarySearchTree dictionary = new BinarySearchTree();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(",\\s*");
                if (palabras.length == 2) {
                    String key = palabras[0].trim();
                    String value = palabras[1].trim();
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
