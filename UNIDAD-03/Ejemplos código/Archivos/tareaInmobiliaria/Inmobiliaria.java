

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inmobiliaria {
	
	public static double calcularPrecioMedioProvincia
	      (int indiceProvincia,
			ArrayList<Double> datosTrimestre1,
			ArrayList<Double> datosTrimestre2,
			ArrayList<Double> datosTrimestre3,
			ArrayList<Double> datosTrimestre4
		  ) { 
		
		return ( datosTrimestre1.get(indiceProvincia) +
				 datosTrimestre2.get(indiceProvincia) +
				 datosTrimestre3.get(indiceProvincia) +
				 datosTrimestre4.get(indiceProvincia) ) / 4.0;
	}
	
	public static double calcularPrecioMedioTrimestre(ArrayList<Double> datosTrimestre) {
		Double suma = 0.0;
		
		for(Double dato:datosTrimestre) {
			suma += dato;
		}
		
		return suma / datosTrimestre.size();
	}
	
	public static int buscarIndiceValorMaximo(ArrayList<Double> datosTrimestre) {
		Double maximo = datosTrimestre.get(0);
		int indiceMaximo = 0;
		
		for(int i = 1; i < datosTrimestre.size(); i++) {
			if (datosTrimestre.get(i) > maximo) {
				maximo = datosTrimestre.get(i);
				indiceMaximo = i;				
			}
		}
		
		return indiceMaximo;
	}
	
	
	public static int buscarIndiceValorMinimo(ArrayList<Double> datosTrimestre) {
		Double minimo = datosTrimestre.get(0);
		int indiceMinimo = 0;
		
		for(int i = 1; i < datosTrimestre.size(); i++) {
			if (datosTrimestre.get(i) < minimo) {
				minimo = datosTrimestre.get(i);
				indiceMinimo = i;				
			}
		}
		
		return indiceMinimo;
	}
	
	
	public static void main (String[] args) {
		ArrayList<String> nombresProvincias = new ArrayList<>();
		ArrayList<Double> datosTrimestre1 = new ArrayList<>();
		ArrayList<Double> datosTrimestre2 = new ArrayList<>();
		ArrayList<Double> datosTrimestre3 = new ArrayList<>();
		ArrayList<Double> datosTrimestre4 = new ArrayList<>();
		
				
		// Leer fichero
		try ( Scanner sc = new Scanner(new File("src\\tareaInmobiliaria\\provincias.txt")))  {
			String linea;
			String[] datosLinea;
	
			while(sc.hasNext()) {
				linea = sc.nextLine();
				datosLinea = linea.split(" ");
				nombresProvincias.add(datosLinea[0]);
				datosTrimestre1.add(Double.parseDouble(datosLinea[1]));
				datosTrimestre2.add(Double.parseDouble(datosLinea[2]));
				datosTrimestre3.add(Double.parseDouble(datosLinea[3]));
				datosTrimestre4.add(Double.parseDouble(datosLinea[4]));
			}
			sc.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} 
		catch(Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		
		// Sacar por pantalla precio medio por provincia
		System.out.println("Informe precio medio por provincia: ");
		System.out.println("====================================");	

		for(int i = 0; i < nombresProvincias.size(); i++) {
			System.out.printf("%s: %.2f%n", nombresProvincias.get(i),
					calcularPrecioMedioProvincia(i, datosTrimestre1,
													datosTrimestre2,
													datosTrimestre3,
													datosTrimestre4));
		}
		
		// Sacar por pantalla precio medio por trimestre
		System.out.println("Informe precio medio por trimestre: ");
		System.out.println("====================================");	
		
		System.out.println("Precio medio del primer trimestre: " +
		                      calcularPrecioMedioTrimestre(datosTrimestre1));
		System.out.println("Precio medio del segundo trimestre: " +
							  calcularPrecioMedioTrimestre(datosTrimestre2));
		System.out.println("Precio medio del tercer trimestre: " +
                			  calcularPrecioMedioTrimestre(datosTrimestre3));		
		System.out.println("Precio medio del cuarto trimestre: " +
                			  calcularPrecioMedioTrimestre(datosTrimestre4));
		
		
		int indiceMaximo = buscarIndiceValorMaximo(datosTrimestre1);
		int indiceMinimo = buscarIndiceValorMinimo(datosTrimestre1);
		System.out.println("Informe precio máximo y mínimo por trimestre: ");
		System.out.println("====================================");	

		System.out.println("Trimestre 1: " + 
		                 nombresProvincias.get(indiceMaximo) + " " +
				         datosTrimestre1.get(indiceMaximo)  + " y " +
				         nombresProvincias.get(indiceMinimo) + " " +
				         datosTrimestre1.get(indiceMinimo));

		indiceMaximo = buscarIndiceValorMaximo(datosTrimestre2);
		indiceMinimo = buscarIndiceValorMinimo(datosTrimestre2);
		System.out.println("Trimestre 2: " + 
                nombresProvincias.get(indiceMaximo) + " " +
		         datosTrimestre2.get(indiceMaximo)  + " y " +
		         nombresProvincias.get(indiceMinimo) + " " +
		         datosTrimestre2.get(indiceMinimo));	


		indiceMaximo = buscarIndiceValorMaximo(datosTrimestre3);
		indiceMinimo = buscarIndiceValorMinimo(datosTrimestre3);
		System.out.println("Trimestre 3: " + 
                nombresProvincias.get(indiceMaximo) + " " +
		         datosTrimestre3.get(indiceMaximo)  + " y " +
		         nombresProvincias.get(indiceMinimo) + " " +
		         datosTrimestre3.get(indiceMinimo));	


		indiceMaximo = buscarIndiceValorMaximo(datosTrimestre3);
		indiceMinimo = buscarIndiceValorMinimo(datosTrimestre3);
		System.out.println("Trimestre 3: " + 
                nombresProvincias.get(indiceMaximo) + " " +
		         datosTrimestre4.get(indiceMaximo)  + " y " +
		         nombresProvincias.get(indiceMinimo) + " " +
		         datosTrimestre4.get(indiceMinimo));			
		
		
	}
}
