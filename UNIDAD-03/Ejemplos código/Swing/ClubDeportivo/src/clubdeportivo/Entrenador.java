package clubdeportivo;

import java.io.Serializable;

/**
 *
 * @author AlumnoT
 */
public class Entrenador extends Personal  implements Serializable {
    private static final long serialVersionUID = 1L;
    private double sueldo;
    private double plusPartidoGanado;

    public Entrenador(String nombre,
                        String dni, 
                        String direccion, 
                        String telefono, 
                        int partidosGanados,
                        double sueldo, 
                        double plusPartidoGanado) {
        super(nombre, dni, direccion, telefono, partidosGanados);
        this.sueldo = sueldo;
        this.plusPartidoGanado = plusPartidoGanado;
    }
    

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getPlusPorGol() {
        return plusPartidoGanado;
    }

    public void setPlusPorGol(double plusPorGol) {
        this.plusPartidoGanado = plusPorGol;
    }

    public Double getSueldoFinal() {       
        return sueldo + getPartidosGanados() * plusPartidoGanado;
    }
    
     @Override
    public String toString() {
        return "Entrenador: "
                + getNombre() + " - "
                + getDNI() + " - "
                + getDireccion() + " - "
                + getTelefono()
                + getPartidosGanados() + " - "
                + getSueldo() + " - "
                + getPlusPorGol()
                ;
    }
    
}
