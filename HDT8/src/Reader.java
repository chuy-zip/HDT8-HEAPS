import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {
	
	public BTHeap readTxtFileToPriorityQueue() {
	    String MyFile = "src/pacientes.txt";
	    System.out.println("Pacientes ingresados");
	    
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(MyFile));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            String[] Strline = line.split(",");
	            Strline[0] = Strline[0].trim();
	            Strline[1] = Strline[1].trim();
	            Strline[2] = Strline[2].trim();
	            
	            Patient patient = new Patient(Strline[0], Strline[1], Strline[2]);
	            System.out.println(patient.getName() + " " + patient.getCondition() + " " + patient.getPriority());
	        }

	        reader.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("\n");
	    return null;
	}
}
