package utils;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Log {
	
	public static final String NOME = "rastreamento.txt";
	private PrintWriter arquivo;

	public void abrir(String nome) throws IOException {
		File outFile = new File(nome);
		FileOutputStream outFileStream;
		
		System.out.println("Procure o arquivo" + nome);
		if (outFile.exists()) {
			outFileStream = new FileOutputStream(outFile, true);
		} else {
			outFileStream = new FileOutputStream(outFile);
		}
		arquivo = new PrintWriter(outFileStream);
	}

	public void escrever(String texto) throws IOException {
		arquivo.println(texto);
		arquivo.flush();
	}

	public void fechar() throws IOException {
		arquivo.close();
	}

}
