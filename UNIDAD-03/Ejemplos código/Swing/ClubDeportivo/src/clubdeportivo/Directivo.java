package clubdeportivo;

import java.io.Serializable;

/**
 *
 * @author AlumnoT
 */
public class Directivo extends Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cargo;   // "presidente" ó "delegado" ó "secretario"
    private double sueldo;
    private boolean activo;

    public Directivo(String nombre,
                      String dni, 
                      String direccion, 
                      String telefono, 
                      int partidosGanados, 
                      String cargo,
                      Double sueldo, 
                      boolean activo) {
        super(nombre, dni, direccion, telefono, partidosGanados);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.activo = true;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public Double getSueldoFinal() {
        double plusPorCargo = 0.0;
        
        if(cargo.equals("presidente")) {
            plusPorCargo = 1000.0;
        } else if ( cargo.equals("delegado")) {
            plusPorCargo = 500.0;
        } else if ( cargo.equals("secretario") ) {
            plusPorCargo = 200.0;
        }
        
        return sueldo + plusPorCargo + (getPartidosGanados() * 10.0);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
     @Override
    public String toString() {
        return "Directivo: "
                + getNombre() + " - "
                + getDNI() + " - "
                + getDireccion() + " - "
                + getTelefono()
                + getPartidosGanados() + " - "
                + getCargo() + " - "
                + getSueldo() + " - "
                + getActivo()
                ;
    }
    
}
