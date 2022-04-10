package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream entradaDoArquivo = new FileInputStream(
				new File("C:\\Users\\alex_\\git\\repository3\\arquivos\\src\\arquivos\\arquivo.csv"));
		try (Scanner lerArquivo = new Scanner(entradaDoArquivo, "UTF-8")) {

			List<Pessoa> pessoas = new ArrayList<Pessoa>();

			while (lerArquivo.hasNext()) {

				String linha = lerArquivo.nextLine();

				if (linha != null && !linha.isEmpty()) {

					// Quebrando os dados no array com a expressão \\ e separando os dados com ;
					String[] dados = linha.split("\\;");

					Pessoa pessoa = new Pessoa();

					pessoa.setNome(dados[0]);
					pessoa.setEmail(dados[1]);
					pessoa.setIdade(Integer.parseInt(dados[2]));

					pessoas.add(pessoa);

				}
			}
			for (Pessoa pessoa : pessoas) {/*
											 * Poderia gravr no banco de dados, enviar email, gerar boleto, fazer coisa
											 */
				System.out.println(pessoa);
			}
		}
	}
}
