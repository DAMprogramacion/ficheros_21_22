package ficherosTexto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopiarQuijote {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path source = Paths.get("ficheros/quijote.txt");
		Path target = Paths.get("ficheros/quijote_backup.txt");
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Creado backup del fichero");
	}

}
