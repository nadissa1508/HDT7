import java.io.BufferedReader;
import java.io.FileReader;  
import java.io.IOException;

public class ReadFile{

    public void insertBST(){  

    }

    public String readFile(String fileName){
        String translate = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String linea;

            while ((linea = br.readLine()) != null) {
                linea += br.readLine();
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error, no existe el archivo datos.txt en el folder: " );
            e.printStackTrace();
        }
        return translate;
    }
}