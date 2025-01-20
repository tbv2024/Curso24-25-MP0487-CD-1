package clubdeportivo;

import java.io.Serializable;

/**
 *
 * @author AlumnoT
 */
public abstract class Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String nombre;
    protected String dni;
    protected String direccion;
    protected String telefono;
    protected int partidosGanados;

    public Personal(String nombre, String dni, String direccion, String telefono, int partidosGanados) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.partidosGanados = partidosGanados;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }
    
    @Override
    public String toString() {
        return "Persona: "
                + getNombre() + " - "
                + getDNI() + " - "
                + getDireccion() + " - "
                + getTelefono()
                + getPartidosGanados();
    }
}
