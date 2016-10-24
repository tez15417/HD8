import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Vector;
import java.io.FileNotFoundException;

/** 
* Jorge Mario Tezen 15417
*/

public class Hospital {

	public static void main(String[] args) throws FileNotFoundException {
		
            String archivo = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Heap\\src\\pacientes.txt";
            String[] listaT; //
            BufferedReader br = new BufferedReader(new FileReader(archivo));
	    String linea;
	    
	   //Vector de Pacientes
	    Vector<Paciente> listaPacientes = new Vector<Paciente>();
	 	     
             try {
		while ((linea = br.readLine()) != null) {
                    //se guarda el paciente con sus atributos al Vector
		    listaT=linea.split(","); 
		    listaPacientes.add(new Paciente(listaT[0], listaT[1], listaT[2]));   
		}	
            } 
            catch (IOException e) {
		System.out.println("error");
            }
     
            //Se imprime la lista de pacientes original.
            System.out.println("Ficha de Pacientes que ingresaron a emergencia:");
            for(int i=0; i<listaPacientes.size(); i++){
                System.out.println(listaPacientes.get(i));
            }

            //Se muestra la lista de pacientes ordenados por prioridad
		
            System.out.println("\nPor favor atienda a los pacientes en el orden de prioridad mostrado en esta lista:");
            //se intancia el vectorHeap de pacientes, lleno con la lista de pacientes
            VectorHeap<Paciente> vectorH = new VectorHeap<Paciente>(listaPacientes); 
		
            int cont = vectorH.size();
            for(int i=0; i<cont; i++){
                //Se remueve cada paciente por orden de prioridad, para mostrarlo en la lista de atencion
		Paciente pacienteTemp = vectorH.remove(); 
		System.out.println(pacienteTemp.toString()); //Se imprime la lista de prioridad
            }
	}
}
