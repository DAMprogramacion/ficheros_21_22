package accesoAleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class EscribirLeerEnterosAleatorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		File inOut = new File("ficheros/enteros.bin");
		try (RandomAccessFile inOutFile = new RandomAccessFile(inOut, "rw");) {
			escribirNumerosEnFichero(random, inOutFile);
			System.out.println();
			System.out.printf("Escritos %d bytes en el fichero %s%n", inOut.length(), inOut);
			System.out.println("Leyendo el fichero");
			leerNumerosDeFichero(inOutFile);
			System.out.println();
			cambiarDosPosicionesEnFichero(random, inOutFile);
			System.out.println("Leyendo el fichero");
			leerNumerosDeFichero(inOutFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Fichero no encotrado: " + inOut);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("Erro I/O");
		}

	}

	private static void cambiarDosPosicionesEnFichero(Random random, RandomAccessFile inOutFile) throws IOException {
		System.out.println("Intercambiado dos posiciones por 0");
		int posicion1 = random.nextInt(10);
		int posicion2 = random.nextInt(10);
		while (posicion1 == posicion2)
			posicion2 = random.nextInt(10);
		inOutFile.seek(posicion1 * 4);
		inOutFile.writeInt(0);
		inOutFile.seek(posicion2 * 4);
		inOutFile.writeInt(0);
	}

	private static void leerNumerosDeFichero(RandomAccessFile inOutFile) throws IOException {
		for (int i = 0; i < 10; i++) {
			//inOutFile.seek(i * 4);
			System.out.printf("%d ", inOutFile.readInt());
		}
	}

	private static void escribirNumerosEnFichero(Random random, RandomAccessFile inOutFile) throws IOException {
		for (int i = 0; i < 10; i++) {
			int numero = random.nextInt(10) + 1;
			inOutFile.writeInt(numero);
		}
	}

}
