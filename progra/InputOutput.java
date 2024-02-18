package actividad2.exceptions.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import actividad2.Empleado;
import actividad2.Programador;
	import actividad2.exceptions.EdadException;


	public class InputOutput {
		
//metodo que permite pedir un entero por teclado
		public static int getInt(String question) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        int x = 0;
	        while (true) {
	            try {
	                System.out.println(question);
	                String stringLeido = reader.readLine();
	                x = Integer.parseInt(stringLeido);
	                return x;
	            } catch (NumberFormatException | IOException ex) {
	                System.out.println("Introduce un número entero");
	            }
	        }
	    }  
		
//metodo que permite pedir un entero en un rango determinado por teclado
	    public static int getIntInRange(String question, int begin, int end) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        int x = 0;
	        boolean t = true;
	        while (t) {
	            try {
	                System.out.println(question);
	                String stringLeido = reader.readLine();
	                x = Integer.parseInt(stringLeido);
	                if (x >= begin && x <= end) {
	                    return x;
	                } else {
	                    System.out.println("Debe introducir un número entre " + begin + " y " + end);
	                }
	            } catch (NumberFormatException | IOException ex) {
	                System.out.println("Introduce un número entero");
	            }
	        }
	        return x;
	    } 
	    
//metodo que permite pedir un string por teclado
	    public static String getString(String question) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        String stringLeido = "";
	        while (true) {
	            try {
	                System.out.println(question);
	                stringLeido = reader.readLine();
	                return stringLeido;
	            } catch (IOException ex) {
	                System.out.println("ERROR");
	            }
	        }
	    } 
	    
//metodo que permite pedir un decimal por teclado
	    public static double getDouble(String question) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        double x = 0.0;
	        while (true) {
	            try {
	                System.out.println(question);
	                String stringLeido = reader.readLine();
	                x = Double.parseDouble(stringLeido);
	                return x;
	            } catch (NumberFormatException | IOException ex) {
	                System.out.println("Introduce un número decimal");
	            }
	        }
	    } 
	    
//metodo que permite pedir un booleano por teclado
	    public static boolean getBoolean(String question) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        while (true) {
	            try {
	                System.out.println(question);
	                String input = reader.readLine().trim().toLowerCase();
	                if (input.equals("true")) {
	                    return true;
	                } else if (input.equals("false")) {
	                    return false;
	                } else {
	                    System.out.println("Error: Por favor, ingresa 'true' o 'false'.");
	                }
	            } catch (IOException e) {
	                System.out.println("Error al leer la entrada del usuario.");
	            }
	        }
	    }  
	    
/*metodo que recibe como parametros un array de tipo empleados, da de alta a un empleado de tipo programador o de tipo "normal"
  y lo añade a un array de empleados */    

	    public static void altaEmpleado(ArrayList<Empleado> empleados) throws IOException, EdadException { 
	    	 System.out.println("\nCreación de un nuevo empleado:");
	         String nombre = getString("Nombre y apellido: ");
	         String dni =getString("DNI: ");
	         int edad = getIntInRange("Edad (entre 18 y 45 años): ", 18, 45);
	         boolean casado = getBoolean("¿Está casado? (true/false): ");
	         double salario = getDouble("Salario: ");
	         
	         int tipoEmpleado = getIntInRange("Tipo de empleado (1: Programador, 2: Otro): ", 1, 2);

	         if (tipoEmpleado == 1) {
	             int lineasDeCodigoPorHora = getInt("Líneas de código por hora: ");
	             String lenguajeDominante = getString("Lenguaje dominante: ");
	             empleados.add(new Programador(nombre, dni, edad, casado, salario, lineasDeCodigoPorHora, lenguajeDominante));
	         } else {
	             empleados.add(new Empleado(nombre, dni, edad, casado, salario));
	         }
	         System.out.println("Empleado dado de alta correctamente.");
	    }   
	    
//metodo que muestra los empleados dados de alta que se encuentran en el array empleados   
	    public static void mostrarEmpleados(ArrayList<Empleado> empleados) {
	        if (empleados.isEmpty()) {
	            System.out.println("No hay ningún empleado registrado.");
	            return;
	        }
	        System.out.println("\nLista de empleados:");
	        for (int i = 0; i < empleados.size(); i++) {
	            System.out.println(i + ". " + empleados.get(i));
	        }
	    }  
	    
//metodo que borrra del array un empleado. Cuando se borra el array retrasa a los empleados una posicion 	    
	    public static void bajaEmpleado(ArrayList<Empleado> empleados) throws IOException {
	    	   if (empleados.isEmpty()) {
	               System.out.println("No hay ningún empleado registrado.");
	               return;
	           }
	           
	           System.out.println("\nDar de baja un empleado:");
	           mostrarEmpleados(empleados);
	           int index = getIntInRange("Ingrese el índice del empleado que desea dar de baja: ", 0, empleados.size() - 1);
	           empleados.remove(index);
	           System.out.println("Empleado dado de baja correctamente.");
	       } 
	    
//metodo que aumenta el salario de un empleado. para seleccionar el empleado se pide el indice de este(posicion)
	    public static void aumentarSalario(ArrayList<Empleado> empleados) throws IOException {
	    	if (empleados.isEmpty()) {
	            System.out.println("No hay ningún empleado registrado.");
	            return;
	        }
	        
	        System.out.println("\nAumentar salario de un empleado:");
	        mostrarEmpleados(empleados);
	        int index = getIntInRange("Ingrese el índice del empleado cuyo salario desea aumentar: ", 0, empleados.size() - 1);
	        double porcentaje = getDouble("Porcentaje de aumento del salario: ");
	        Empleado empleado = empleados.get(index);
	        empleado.aumentarSalario(porcentaje);
	        System.out.println("Salario aumentado correctamente.");
	    }
	} 
	
	
	

	 


