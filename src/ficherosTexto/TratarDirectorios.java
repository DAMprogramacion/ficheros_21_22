package ficherosTexto;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TratarDirectorios {
	public static void main(String[] args) {
		Path dir = Paths.get("ficheros");
		if (!Files.isDirectory(dir, LinkOption.NOFOLLOW_LINKS)) {
			System.out.printf("%s no es un directorio%n", dir);
			System.exit(1);
		}
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
		       for (Path entry: stream) {
		          if (Files.isDirectory(entry, LinkOption.NOFOLLOW_LINKS))
		        	  System.out.printf("%s es un directorio%n", entry);
		          else
		        	  System.out.printf("%s es un fichero regular%n", entry.getFileName());
		       }
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
