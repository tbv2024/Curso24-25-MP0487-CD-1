// Indica si un número dado es positivo, negativo o igual a cero.

Algoritmo Ejercicio013
	Definir num Como Real;
	num = 0;
	Escribir "Dime un número: " Sin Saltar;
	Leer num;
	Si num > 0 Entonces
		Escribir "El número es positivo";
	SiNo
		Si num = 0 Entonces
			Escribir "El número es cero";
		SiNo
			Escribir "El número es negativo";
		FinSi		
	FinSi
FinAlgoritmo
