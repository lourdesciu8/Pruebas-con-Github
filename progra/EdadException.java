package actividad2.exceptions; 

//mediante esta excepcion controlamos en el constructor de empleado el rango de edad.  
public class EdadException  extends Exception {

    public EdadException(String message) {
        super(message);
    }
}

