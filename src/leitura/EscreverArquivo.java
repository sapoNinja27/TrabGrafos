package leitura;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class EscreverArquivo {

	public static void Escrever(String path, String[] texto) {
		try {		
			OutputStream stream = new FileOutputStream(path);
			OutputStreamWriter swriter = new OutputStreamWriter(stream);
			BufferedWriter buffer = new BufferedWriter(swriter);
			for (String linha : texto) {
				buffer.write(linha);
			}
			buffer.flush();
			buffer.close();			
		}
		catch (Exception e) {
			System.out.println("ERRO DESCONHECIDO AO ESCREVER ARQUIVO");
		}
	}

}
