package actividad2;
import actividad2.exceptions.EdadException; 

//Hereda de empleado no es necesario volver a definir los métodos
public class Programador extends Empleado{
   
private int lineasDeCodigoPorHora;
private String lenguajeDominante;

//Constructor sin parámetros
public Programador() {
super(); // Llama al constructor sin parámetros de la clase "padre"
this.lineasDeCodigoPorHora = 0; 
this.lenguajeDominante = "";
}

//Constructor con parámetros
public Programador(String nombre, String DNI, int Edad, boolean casado, double salario, int lineasDeCodigoPorHora, String lenguajeDominante) throws EdadException {
super(nombre, DNI, Edad, casado, salario); 
this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
this.lenguajeDominante = lenguajeDominante;
}

//Getters y setters
public int getLineasDeCodigoPorHora() {
return lineasDeCodigoPorHora;
}

public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
}

public String getLenguajeDominante() {
return lenguajeDominante;
}

public void setLenguajeDominante(String lenguajeDominante) {
this.lenguajeDominante = lenguajeDominante;
}}






