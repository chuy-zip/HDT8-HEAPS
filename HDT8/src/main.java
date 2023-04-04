import java.util.PriorityQueue;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Reader reader = new Reader();
		
		Scanner scan = new Scanner(System.in);
		String option = "";

		
		while(!option.equals("1") && !option.equals("2")) {
			System.out.println("Bienvenido, cual de las 2 implementaciones desea utilizar:\n"
					 + "|1| Utilizar la implementacion propia\n"
					 + "|2| Utilizar la implementacion de Java\n");
			option = scan.nextLine();
			BTHeap heap = reader.readTxtFileToPriorityQueue();
		}
		
		if(option.equals("1")) {
			
			BTHeap heap = reader.readTxtFileToPriorityQueue();

			while(!option.equals("4")) {
				System.out.println("Indique la operacion que desea realizar:\n"
						+ "|1| Ver la lista de pacientes (Orden arriba hacia abajo del arbol)\n"
						+ "|2| Atender paciente con mayor prioridad\n"
						+ "|3| Ingresar paciente\n"
						+ "|4| Salir del programa\n");
				option = scan.nextLine();
				
				if(option.equals("1")) {
					heap.printTree();
					System.out.println("\n");
				}
				else if(option.equals("2")) {
					heap.remove();
					System.out.println("\n");
				}
				else if(option.equals("3")) {
					
					System.out.println("Ingrese el nombre");
					String name = scan.nextLine();
					
					System.out.println("Ingrese la condicion medica del paciente");
					String condition = scan.nextLine();
					
					System.out.println("Ingrese la prioridad");
					String prio = scan.nextLine();
					
					Patient pat = new Patient(name, condition, prio);
					
					heap.insert(pat);
					System.out.println("Paciente ingresado\n");
				}
			}
			
		}
		
		else if(option.equals("2")) {
			
			PriorityQueue<Patient> PatientQueue = reader.readTxtFileToPriorityQueueJava();
			
			while(!option.equals("4")) {
				
				System.out.println("Indique la operacion que desea realizar:\n"
						+ "|1| Ver la lista de pacientes\n"
						+ "|2| Atender paciente con mayor prioridad\n"
						+ "|3| Ingresar paciente\n"
						+ "|4| Salir del programa\n");
				option = scan.nextLine();
			}
			
			if(option.equals("1")) {
				
			}
			else if(option.equals("2")) {
				
			}
			else if(option.equals("3")) {
				System.out.println("Ingrese el nombre");
				String name = scan.nextLine();
				
				System.out.println("Ingrese la condicion medica del paciente");
				String condition = scan.nextLine();
				
				System.out.println("Ingrese la prioridad");
				String prio = scan.nextLine();
				
				Patient pat = new Patient(name, condition, prio);
				
				PatientQueue.add(pat);
				System.out.println("Paciente ingresado\n");
			}
			
		}
		
		
	}
}
