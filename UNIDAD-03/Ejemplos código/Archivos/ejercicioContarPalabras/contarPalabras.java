import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class contarPalabras {

	public static void main(String[] args) {
		args = new String[1];
		args[0] = "src\\contarPalabras.txt";
		
		ArrayList<String> lineas        = new ArrayList<>();
		ArrayList<String> listaPalabras = new ArrayList<>();
		ArrayList<Integer> contadores   = new ArrayList<>();
		String linea;
		String[] palabrasLinea;
		
		
		// Leer el fichero  y:
		//   - guardar cada l�nea en Arraylist lineas
		//   - crear lista de palabras y frecuencia de aparici�n de cada palabra (contadores)
		try {
			Scanner sc = new Scanner(new File(args[0]));
			//  Para cada linea del fichero de texto:
			while(sc.hasNext()) {
				//    leer l�nea
				linea = sc.nextLine();
				// Guardar la l�ena para posterior impresi�n
				lineas.add(linea);
				//    obtener las palabras de la l�nea
				palabrasLinea = linea.split("(\\s|\\.|,|;|:)+");
				//    Guardar cada palabra y su frecuencia
				for(String palabra:palabrasLinea) {
					boolean encontrada = false;
					for(int i = 0; i < listaPalabras.size() && !encontrada; i++) {
						if(listaPalabras.get(i).equalsIgnoreCase(palabra)) {
							contadores.set(i, contadores.get(i)+1);
							encontrada = true;
						}
					}
					
					if(!encontrada) {
						listaPalabras.add(palabra);
						contadores.add(1);
					}
				}
			}
			sc.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.toString());
		} 
		catch(Exception e) {
			System.out.println(e.toString());
		}

		// Imprimir lineas que ya hab�a en archivo + informaci�n de lista de palabras ordenada por frecuencia de aparici�n de cada palabara (mayor a menor)

		try {
			//   Imprimir las l�neas que ya hab�a en el archivo
			BufferedWriter bf = new BufferedWriter(new FileWriter(new File(args[0])));
			for(int i = 0; i < lineas.size();i++) {
				bf.write(lineas.get(i));
				bf.write("\n");
			}
			//  Imprimir informaci�n de lista de palabras ordenada por frecuencia de aparici�n de cada palabara (mayor a menor)
			//     Mientras haya palabras/contadores en la lista
			while(listaPalabras.size() > 0) {
				// 	   - Buscar el mayor de los contadores recorriendo toda la lista:  indiceContadorMayor
				int maxContador = 0;
				int indiceMaxContador = 0;
				for(int i = 0; i < contadores.size(); i++) {
					if(contadores.get(i) > maxContador) {
						maxContador = contadores.get(i);
						indiceMaxContador = i;
					}
				}
				//     - Imprimir la palabra y su contador correspondientes al indiceContadorMayor
				bf.write("La palabra " + listaPalabras.get(indiceMaxContador) + " aparece " + contadores.get(indiceMaxContador) + "\n");
				// 	bf.write("La palabra " + listaPalabras.get(indiceMaxContador) + " aparece " + maxContador);

				//     - Eliminar esa palabra y su contador (indiceContadorMayor) de la lista
				contadores.remove(indiceMaxContador);
				listaPalabras.remove(indiceMaxContador);
			}

			bf.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}		
}
