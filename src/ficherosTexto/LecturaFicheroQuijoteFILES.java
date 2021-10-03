package ficherosTexto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LecturaFicheroQuijoteFILES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path inPath  = Paths.get("ficheros/quijote.txt");
		Path outPath = Paths.get("ficheros/informacion_quijote.txt");
		
		int ocuerrenciasQuijote = 0;
		int ocuerrenciasDulcinea = 0, ocuerrenciasSancho = 0;
		
		try {
			String textoCompleto = Files.readString(inPath);
			String informacionBytes = String.format("%d bytes tiene el fichero %s%n",
					textoCompleto.getBytes().length, inPath);
			System.out.printf(informacionBytes);
			
			String informacionLineas = String.format("%d líneas que tiene el fichero %s%n",
					textoCompleto.split("\n").length, inPath);
			System.out.printf(informacionLineas);
			
			String patternQuijote = "(Quijote|QUIJOTE)";
			Pattern pattern = Pattern.compile(patternQuijote);
	        Matcher matcher = pattern.matcher(textoCompleto);
			while(matcher.find()) 
				ocuerrenciasQuijote++;
			String informacionQuijote = String.format("El fichero %s contiene %d veces la palabra Quijote%n",
					inPath, ocuerrenciasQuijote);
			System.out.printf(informacionQuijote);
			
			String patternDulcinea = "(Dulcinea|DULCINEA)";
			pattern = Pattern.compile(patternDulcinea);
	        matcher = pattern.matcher(textoCompleto);
			while(matcher.find()) 
				ocuerrenciasDulcinea++;
			String informacionDulcinea = String.format("El fichero %s contiene %d veces la palabra Dulcinea%n",
					inPath, ocuerrenciasDulcinea);
			System.out.printf(informacionDulcinea);
			
			String patternSancho = "(Sancho|SANCHO)";
			pattern = Pattern.compile(patternSancho);
	        matcher = pattern.matcher(textoCompleto);
			while(matcher.find()) 
				ocuerrenciasSancho++;
			String infomracionSancho = String.format("El fichero %s contiene %d veces la palabra Sancho%n",
					inPath, ocuerrenciasSancho);
			System.out.printf(infomracionSancho);
			
			//escribir en fichero
			String informacion = informacionBytes + informacionLineas + informacionQuijote +
					informacionDulcinea + infomracionSancho;
				
			Files.writeString(outPath, informacion, StandardOpenOption.CREATE);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
