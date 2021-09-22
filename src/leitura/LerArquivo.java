package leitura;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class LerArquivo {
	
	public static String buscar(String path) {
		String arquivo = "";
		try {			
			InputStream stream = new FileInputStream(path);
			InputStreamReader sreader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(sreader);

			String linha = "";
			while ((linha = buffer.readLine()) != null) {
				arquivo+=":"+linha;
			}
			buffer.close();
		} catch (Exception e) {
			arquivo = "$$";
		}
		return arquivo;
	}
}
