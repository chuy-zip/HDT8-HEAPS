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
		}
		
		if(option.equals("1")) {
			
			reader.readTxtFileToPriorityQueue();

			while(!option.equals("4")) {
				System.out.println("Indique la operacion que desea realizar:\n"
						+ "|1| Ver la lista de pacientes por orden de prioridad\n"
						+ "|2| Atender paciente\n"
						+ "|3| Ingresar paciente\n"
						+ "|4| Salir del programa\n");
				option = scan.nextLine();
			}
			
		}
		
		else if(option.equals("2")) {
			
			while(!option.equals("4")) {
				System.out.println("Indique la operacion que desea realizar:\n"
						+ "|1| Ver la lista de pacientes por orden de prioridad\n"
						+ "|2| Atender paciente\n"
						+ "|3| Ingresar paciente\n"
						+ "|4| Salir del programa\n");
				option = scan.nextLine();
			}
			
		}
		
		
	}
}
