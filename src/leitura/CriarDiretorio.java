package leitura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CriarDiretorio {
	public static void Create(String path) throws Exception{
		try {
			Files.createDirectory(Paths.get(path));
		} catch (IOException e) {
			throw e;
		}
	}
}
