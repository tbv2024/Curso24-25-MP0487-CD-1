package clubdeportivo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AlumnoT
 */
public class Jugador extends Personal  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String posicion;  // "portero" ó "defensa" ó "delantero"
    private double sueldo;
    private Date fechaNac; //formatear con format()
    private double plusPartidosGanados;
    private int numGoles;
    private double plusPorGol;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Jugador(String nombre,
                     String dni, 
                     String direccion, 
                     String telefono, 
                     int partidosGanados, 
                     String posicion,
                     double sueldo,
                     Date fechaNac, 
                     double plusPartidosGanados, 
                     int numGoles, 
                     double plusPorGol) {
        super(nombre, dni, direccion, telefono, partidosGanados);
        this.posicion = posicion;
        this.sueldo = sueldo;
        this.fechaNac = fechaNac;
        this.plusPartidosGanados = plusPartidosGanados;
        this.numGoles = numGoles;
        this.plusPorGol = plusPorGol;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        try {
            this.fechaNac = sdf.parse(fechaNac);
        } catch (ParseException e) {
            System.out.println("ERROR en Jugador.setFechaNac: recibió valor incorrecto");
            this.fechaNac = null;
        }
    }

    public double getPlusPartidoGanado() {
        return plusPartidosGanados;
    }

    public void setPlusPartidoGanado(double plusPartidosGanados) {
        this.plusPartidosGanados = plusPartidosGanados;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }

    public double getPlusPorGol() {
        return plusPorGol;
    }

    public void setPlusPorGol(double plusPorGol) {
        this.plusPorGol = plusPorGol;
    }
 
    public Double getSueldoFinal() {       
        return sueldo + getPartidosGanados() * plusPartidosGanados + numGoles * plusPorGol;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    @Override
    public String toString() {
        return "Jugador: "
                + getNombre() + " - "
                + getDNI() + " - "
                + getDireccion() + " - "
                + getTelefono()
                + getPartidosGanados() + " - "
                + getPosicion() + " - "
                + getSueldo() + " - "
                + getFechaNac() + " - "
                + getNumGoles() + " - "
                + getPlusPorGol()
                ;
    }

}
