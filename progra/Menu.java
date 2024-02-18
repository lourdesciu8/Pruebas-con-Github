package actividad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import actividad2.exceptions.utils.InputOutput;
import actividad2.exceptions.EdadException;

public class Menu { 
	//Creamos un ArrayList de tipo empleados
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    
    public static void main(String[] args) throws EdadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion;

        do {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Dar de alta un empleado");
            System.out.println("2. Dar de baja un empleado");
            System.out.println("3. Aumentar salario de un empleado");
            System.out.println("4. Mostrar todos los empleados");
            System.out.println("0. Salir");

            opcion = InputOutput.getInt("Seleccione una opción: ");

            switch (opcion) { 
            case 0:  
            	System.out.println("Ha salido del programa");
                break;  
            
                case 1: 
                    try {
                        InputOutput.altaEmpleado(empleados);
                    } catch (IOException e) {
                        System.out.println("Error al leer la entrada del usuario.");
                    }
                    break;
                case 2:
                    try {
                        InputOutput.bajaEmpleado(empleados);
                    } catch (IOException e) {
                        System.out.println("Error al leer la entrada del usuario.");
                    }
                    break;
                case 3:
                    try {
                       InputOutput.aumentarSalario(empleados);
                    } catch (IOException e) {
                        System.out.println("Error al leer la entrada del usuario.");
                    }
                    break;
                case 4:
                   InputOutput.mostrarEmpleados(empleados);
                    break;
                
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

}