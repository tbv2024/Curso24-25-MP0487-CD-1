package neoqubit.net.pruebasMaven.entities;

import java.util.Date;

public class Persona {
	int id;
	int edad;
	String nombre;
	Date fechaNacimiento;

	public Persona() { }

	public Persona(String nombre, int edad, Date fechaNacimiento) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
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
		return "Persona [id=" + id + ", edad=" + edad + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ "]";
	}

}
