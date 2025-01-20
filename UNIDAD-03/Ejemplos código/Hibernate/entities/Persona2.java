package neoqubit.net.pruebasMaven.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


@Entity
@Table(name = "personas2")
public class Persona2 {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	int edad;
	String nombre;
	@Column(name = "fecha_nacimiento")
	Date fechaNacimiento;

	public Persona2() { }

	public Persona2(String nombre, int edad, Date fechaNacimiento) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona2(int id, String nombre, int edad, Date fechaNacimiento) {
		this(nombre, edad, fechaNacimiento);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona2 [id=" + id + ", edad=" + edad + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ "]";
	}

	
}
