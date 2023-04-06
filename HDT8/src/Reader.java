import java.io.BufferedReader;
import java.io.FileReader;
import java.util.PriorityQueue;

public class Reader {
	
	/**
	 * This function reads patient information from a text file, creates patient objects, inserts them
	 * into a binary heap, and returns the heap.
	 * 
	 * @return The method is returning a binary heap tree (BTHeap) containing Patient objects read from a
	 * text file.
	 */
	public BTHeap readTxtFileToPriorityQueue() {
	    String MyFile = "src/pacientes.txt";
	    System.out.println("Pacientes ingresados");
	    BTHeap<Patient> heapTree = new BTHeap();
	    
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(MyFile));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            String[] Strline = line.split(",");
	            Strline[0] = Strline[0].trim();
	            Strline[1] = Strline[1].trim();
	            Strline[2] = Strline[2].trim();
	            
	            Patient patient = new Patient(Strline[0], Strline[1], Strline[2]);
	            heapTree.insert(patient);
	            System.out.println(patient.getName() + ", " + patient.getCondition() + ", " + patient.getPriority());
	        }

	        reader.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("\n");
	    return heapTree;
	}
	
	/**
	 * This function reads a text file containing patient information, creates a priority queue of
	 * patients based on their priority level, and returns the priority queue.
	 * 
	 * @return A PriorityQueue of Patient objects is being returned.
	 */
	public PriorityQueue readTxtFileToPriorityQueueJava() {
	    String MyFile = "src/pacientes.txt";
	    System.out.println("Pacientes ingresados");
	    PriorityQueue<Patient> heapQueue = new PriorityQueue<Patient>();
	    
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(MyFile));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            String[] Strline = line.split(",");
	            Strline[0] = Strline[0].trim();
	            Strline[1] = Strline[1].trim();
	            Strline[2] = Strline[2].trim();
	            
	            Patient patient = new Patient(Strline[0], Strline[1], Strline[2]);
	            heapQueue.add(patient);
	            System.out.println(patient.getName() + ", " + patient.getCondition() + ", " + patient.getPriority());
	        }

	        reader.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("\n");
	    return heapQueue;
	}
}
