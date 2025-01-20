package clubdeportivo;

import java.io.Serializable;

/**
 *
 * @author AlumnoT
 */
public class Mantenedor extends Personal  implements Serializable {
    private static final long serialVersionUID = 1L;
    private double sueldo;
    private boolean fijo;
    private double plusFijo;

    public Mantenedor(String nombre,
                        String dni, 
                        String direccion, 
                        String telefono, 
                        int partidosGanados,
                        double sueldo, 
                        boolean fijo,
                        double plusFijo) {
        super(nombre, dni, direccion, telefono, partidosGanados);
        this.sueldo = sueldo;
        this.plusFijo = plusFijo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isFijo() {
        return fijo;
    }

    public void setFijo(boolean fijo) {
        this.fijo = fijo;
    }

    public Double getSueldoFinal() {    
        if(fijo) {
            return sueldo + plusFijo;
        } else {
            return sueldo;
        }
    }

    
    public double getPlusFijo() {
        return plusFijo;
    }

    public void setPlusFijo(double plusFijo) {
        this.plusFijo = plusFijo;
    }
    
    
     @Override
    public String toString() {
        return "Jugador: "
                + getNombre() + " - "
                + getDNI() + " - "
                + getDireccion() + " - "
                + getTelefono() + " - "
                + getPartidosGanados() + " - "
                + getSueldo() + " - "
                + getPlusFijo()
                ;
    }

}
