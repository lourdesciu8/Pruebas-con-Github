package actividad2;

import actividad2.exceptions.EdadException;

public class Empleado { 
private String nombre; 
private String DNI; 
private int Edad;
private boolean casado;  
private Double salario;   

//Constructor sin parámetros 
public Empleado() { 
	this.nombre="";    
	this.DNI=""; 
	this.Edad=0; 
	this.casado=true; //?¿
	this.salario=0.0;
} 
//Constructor con parámetros 
public Empleado(String nombre, String DNI, int Edad, boolean casado, double salario) throws EdadException {
    this.nombre = nombre;
    this.DNI = DNI;
    if (Edad < 18 || Edad > 45) {
        throw new EdadException("La edad debe estar entre 18 y 45 años");
    }
    this.Edad = Edad;
    this.casado = casado;
    this.salario = salario;
}
//getters y setters
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDNI() {
	return DNI;
}
public void setDNI(String dNI) {
	DNI = dNI;
}
public int getEdad() {
	return Edad;
}
public void setEdad(int edad) {
	Edad = edad;
}
public boolean isCasado() {
	return casado;
}
public void setCasado(boolean casado) {
	this.casado = casado;
}
public Double getSalario() {
	return salario;
}
public void setSalario(Double salario) {
	this.salario = salario;
} 

 
//Método de clasificación según la edad   
 public String clasificacion(int edad) { 
		    if (edad <= 21) {
		        return "Principiante";
		    } else if (edad >= 22 && edad <= 35) {
		        return "Intermedio";
		    } else {
		        return "Senior";
		    }
		}         
 
//ToString 
@Override
public String toString() {
	return "Empleado [nombre=" + nombre + ", DNI=" + DNI + ", Edad=" + Edad + ", casado=" + casado + ", salario="
			+ salario + "]";
}


//Método que permite aumentar el salario 
public void aumentarSalario(double porcentajeAumento) {
    double aumento = salario * (porcentajeAumento / 100); //convertimos el porcentaje a forma decimal
    salario = salario +  aumento;
}
}

