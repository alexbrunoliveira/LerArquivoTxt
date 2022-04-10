package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("C:\\Users\\alex_\\git\\repository3\\arquivos\\\\arquivo_excel.xls");
		
		if (!file.exists()) {
			file.createNewFile();
			 
		}
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(50);
		pessoa1.setNome("Alex Bruno");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(25);
		pessoa2.setNome("Marcos Tadeu");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(40);
		pessoa3.setNome("Maria Jesus");
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setEmail("pessoa4@gmail.com");
		pessoa4.setIdade(45);
		pessoa4.setNome("João Carlos");
		
		/*Pode vir do banco de dados ou qualquer fonte de dados*/
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);

		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // Usado para escrever na planilha
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de Pessoas Jdev Treinamento"); // Criar planilha
		
		int numeroLinha = 0 ; // Cria uma linha para cada pessoa
		
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha ++); // Criando linha na tabela
			
			int celula  = 0;
			
			Cell celNome = linha.createCell(celula ++) ; // Celula 1
			celNome.setCellValue(p.getNome());
			
			Cell celemail = linha.createCell(celula ++) ; // Celula 2
			celemail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++) ; // Celula 3
			celIdade.setCellValue(p.getIdade());
			
		} /*Termino de montra planilha*/
			
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida); /*Escreve planilha em arquivo*/
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada");
	}

}
