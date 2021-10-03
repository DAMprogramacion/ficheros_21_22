package ficherosBinarios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LecturaFicheroBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path inPath  = Paths.get("ficheros/tux.jpg");
		Path outPath = Paths.get("ficheros/tux_copia.jpg");

		try {
			byte[] bytesLeidos = Files.readAllBytes(inPath);
//			for (byte byteLeido : bytesLeidos) {
//				System.out.println(byteLeido);
//			}
			System.out.printf("El tamaño del fichero %s es %d bytes%n",
					inPath, bytesLeidos.length);
			Files.write(outPath, bytesLeidos, StandardOpenOption.CREATE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
