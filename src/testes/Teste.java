package testes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import entidades.Header;
import entidades.ResumoConexoes;
import entidades.ResumoPesos;
import entidades.Trailer;
import leitura.CriarDiretorio;
import leitura.EscreverArquivo;
import leitura.LerArquivo;

public class Teste {
	Header header;
	List<ResumoConexoes> conexoes = new ArrayList<>();
	List<ResumoPesos> pesos = new ArrayList<>();
	Trailer trailer;

	public void Go() {
		String sequencial = "03";
		String sep = "=";
		String rota = LerArquivo.buscar("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\rota" + sequencial + ".txt");
		String config = LerArquivo.buscar("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\config.txt");
		try {
			CriarDiretorio.Create("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\Teste");
		} catch (Exception e) {
			System.out.println("NÃO FOU POSSIVEL CRIAR O DIRETORIO /Teste, POIS O CAMINHO JA EXISTE");
		}
		try {
			CriarDiretorio.Create("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\Teste\\Configuracao");
		} catch (Exception e) {
			System.out.println("NÃO FOU POSSIVEL CRIAR O DIRETORIO /Teste/Configuracao, POIS O CAMINHO JA EXISTE");
		}
		
		try {
			CriarDiretorio.Create("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\Teste\\Processado");
		} catch (Exception e) {
			System.out.println("NÃO FOU POSSIVEL CRIAR O DIRETORIO, POIS O CAMINHO JA EXISTE");
		}
		try {
			CriarDiretorio.Create("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\Teste\\NaoProcessado");
		} catch (Exception e) {
			System.out.println("NÃO FOU POSSIVEL CRIAR O DIRETORIO, POIS O CAMINHO JA EXISTE");
		}
		
		try {
			CriarDiretorio.Create("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\Teste\\Configuracao");
		} catch (Exception e) {
			System.out.println("NÃO FOU POSSIVEL CRIAR O DIRETORIO /Teste/Configuracao, POIS O CAMINHO JA EXISTE");
		}

		if (config == "$$") {
			System.out.println("ARQUIVO config.txt NÃO FOI ENCONTRADO NO DIRETORIO /Teste/Configuracao");
			String[] configA = { "Processado=/Processado", "Não Processado=/NaoProcessado" };
			EscreverArquivo.Escrever("/Teste/Configuracao/config.txt", configA);
		}
		if (config == "") {
			System.out.println("ARQUIVO config.txt ESTA VAZIO");
			String[] configA = { "Processado=/Processado", "Não Processado=/NaoProcessado" };
			EscreverArquivo.Escrever("/Teste/Configuracao/config.txt", configA);
		}
		if (!config.contains("Não Processado=/NaoProcessado")) {
			System.out.println("ARQUIVO config.txt ESTA INCOMPLETO");
			String[] configA = { "Processado=/Processado", "Não Processado=/NaoProcessado" };
			EscreverArquivo.Escrever("/Teste/Configuracao/config.txt", configA);
		}
		if (!config.contains("=")) {
			System.out.println("POR ALGUM MOTIVO O ARQUIVO config.txt ESTA MAL ESCRITO");
			sep = "@";
		}
		String rotas[] = rota.split(":");
		Boolean erro = false;
		for (String linhas : rotas) {
			if(!linhas.equals("")) {
				String[] linha = linhas.split("");
				String id = linha[1];
				switch (id) {
				case "0":
					if (!(linha[2] + linha[3]).equals(sequencial)) {
						System.out.println("NUMERO TOTAL DE NÓS INVALIDO");
						erro = true;
					} else if (linha.length != 8) {
						System.out.println("HEADER INVALIDO");
						erro = true;
					} else {
						header = new Header(linha[2] + linha[3], linha[4] + linha[5] + linha[6] + linha[7]);
					}
					break;
				case "1":
					if (linha.length != 7) {
						System.out.println("RESUMO DE CONEXOES INVALIDO");
						erro = true;
					} else {
						conexoes.add(new ResumoConexoes(linha[2] + linha[3], linha[5] + linha[6]));
					}
					break;
				case "2":
					if (linha.length != 12) {
						System.out.println("RESUMO DE PESOS INVALIDO");
						erro = true;
					} else {
						pesos.add(new ResumoPesos(linha[2] + linha[3], linha[5] + linha[6],
								linha[8] + linha[9] + linha[10] + linha[11]));
					}
					break;
				case "9":
					if (linha.length != 7) {
						System.out.println("TRAILER INVALIDO");
						erro = true;
					} else {
						trailer = new Trailer(linha[2] + linha[3], linha[5] + linha[6]);
					}
					break;
				}
			}
		}

		int pesoTotal = 0;
		for (ResumoPesos peso : pesos) {
			pesoTotal += peso.getPesoAresta();
		}
		if (header.getSomaPesos() != pesoTotal) {
			System.out.println("SOMA DOS PESOS DIFERE");
			erro = true;
		}
		if (trailer.getNumLinhasConexoes() != conexoes.size()) {
			System.out.println("SOMA DOS NOS DIFERE");
			erro = true;
		}
		if (trailer.getNumLinhasPesos() != conexoes.size()) {
			System.out.println("NÃO SEI POR QUE ISSO É UM ERRO");
			erro = true;
		}

		if(erro) {
			try {
				Files.move(Paths.get("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\rota" + sequencial + ".txt"), Paths.get("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\Teste\\NaoProcessado\\rota" + sequencial + ".txt"), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				System.out.println("ERRO NÃO IDENTIFICADO 1");
			}
		}else {
			try {
				Files.move(Paths.get("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\rota" + sequencial + ".txt"), Paths.get("D:\\Documentos\\Eclipse projetos\\TrabGrafos\\res\\Teste\\Processado\\rota" + sequencial + ".txt"), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				System.out.println("ERRO NÃO IDENTIFICADO 2");
			}
		}
	}

}
