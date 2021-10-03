package ficherosTexto;

import java.io.IOException;
//import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LecturaQuijote {
	public static void main(String[] args) {
		//forma clásica
		//File inFile = new File("ficheros/quijote.txt");
		Path inPath = Paths.get("ficheros/quijote.txt");
		int contadorLineas = 0, ocuerrenciasQuijote = 0;
		int ocuerrenciasDulcinea = 0, ocuerrenciasSancho = 0;

		try (Scanner in = new Scanner(inPath);){
			while (in.hasNextLine()) {
				String lineaLeida = in.nextLine();
				String[] tokens = lineaLeida.split("\s+");
				for(String token: tokens) {
					if (token.toLowerCase().contains("quijote")) {
						ocuerrenciasQuijote++;
					}
					if (token.toLowerCase().contains("dulcinea")) {
						ocuerrenciasDulcinea++;
					}
					if (token.toLowerCase().contains("sancho")) {
						ocuerrenciasSancho++;
					}
				}
				contadorLineas++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%d líneas leídas del fichero %s%n",
				contadorLineas, inPath);
		System.out.printf("El fichero %s contiene %d veces la palabra Quijote%n",
				inPath, ocuerrenciasQuijote);
		System.out.printf("El fichero %s contiene %d veces la palabra Dulcinea%n",
				inPath, ocuerrenciasDulcinea);
		System.out.printf("El fichero %s contiene %d veces la palabra Sancho%n",
				inPath, ocuerrenciasSancho);
		System.out.printf("El fichero %s tiene %d bytes%n", inPath,
				inPath.toFile().length());
		
		
		
		
	}
}
