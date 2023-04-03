import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;

public class Reader {
	
	public BTHeap readTxtFileToList() {
   	 ArrayList<String> wordsList = new ArrayList<String>();
   	 String MyFile = "src/texto.txt";
   	 
        try {
        	BufferedReader reader = new BufferedReader(new FileReader(MyFile));
            String line = reader.readLine();
            
            while (line != null) {
              String[] Strline = line.split(",");
              Strline[0] = Strline[0].trim();
              Strline[1] = Strline[1].trim();
              Strline[2] = Strline[2].trim();
              
              System.out.println(Strline[0] + Strline[1] + Strline[2]);
            }
            
            reader.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
