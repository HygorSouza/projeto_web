package remap.utils;

import java.io.FileWriter;
import java.io.IOException;

public class Log {
	public static final String NOME = "rastreamento.txt";
	private FileWriter arquivo;
	
	public void abrir(String nome) throws IOException{
		arquivo = new FileWriter(nome, true);
		System.out.println("Procure o arquivo em " + nome);
	}
	
	public void escrever(String texto) throws IOException{
		arquivo.write(texto);
		arquivo.flush();
	}
	
	public void fechar() throws IOException{
		arquivo.close();
	}

}
