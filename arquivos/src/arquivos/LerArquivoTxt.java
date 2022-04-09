package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream entradaDoArquivo = new FileInputStream(
				new File("C:\\temp\\ws-eclipse\\arquivos\\src\\arquivos\\arquivo.txt"));
		try (Scanner lerArquivo = new Scanner(entradaDoArquivo, "UTF-8")) {
			while (lerArquivo.hasNext()) {

				String linha = lerArquivo.nextLine();

				if (linha != null && !linha.isEmpty()) {
					
					System.out.println(linha);

				}
			}

		}
	}
}
