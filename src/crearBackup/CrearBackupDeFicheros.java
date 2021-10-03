package crearBackup;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CrearBackupDeFicheros {
	public static void main(String[] args) {
		Path dir = Paths.get("ficheros");
		Path backup = Paths.get("ficheros/backup");
		if (!Files.isDirectory(dir, LinkOption.NOFOLLOW_LINKS)) {
			System.out.printf("%s no es un directorio%n", dir);
			System.exit(1);
		}
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			Files.createDirectories(backup);
			for (Path entry : stream) {
				if (Files.isDirectory(entry, LinkOption.NOFOLLOW_LINKS));
				else {
					String pathName = backup + "/" + entry.getFileName();
//					backup/nombre_fichero
					System.out.println("Copiando como" +  pathName);
					Files.copy(entry, Paths.get(pathName),
							StandardCopyOption.REPLACE_EXISTING);
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
