
package br.com.UNIPSGF.model.vo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Csv {

    
    public String caminhoCsv(){
    
        
        String caminho = System.getProperty("user.dir");
        caminho += File.separator + "alunos.csv";
        
    return caminho;
    }

        //escrever
        public void escreveCsvAluno() {
            
            String id = escreveIdAluno();
            String nome = escreveNomeAluno();
           
        }

        //le id do aluno
        private String escreveIdAluno(){
            
            String id = "";
			
		System.out.println("Coloque o Id do Aluno");
		Scanner in = new Scanner(System.in);
		
                id = in.nextLine();
			
            return id;
        }
        


        //le nome do aluno
        private String escreveNomeAluno(){

            String nome = "";
			
		System.out.println("Coloque o nome do Aluno");
		Scanner in = new Scanner(System.in);
		nome = in.nextLine();
				
            return nome;	
	}
        
        public void lerCsvAluno() throws IOException{
             String id = lerIdAluno();
             String nome = lerNomeAluno();
            
            
        }
        
        public String lerIdAluno() throws IOException{
            
		
            try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
                Scanner in = new Scanner(fis, "UTF-8");


                    String linha = in.nextLine();
                    String[] palavra = linha.split("\\;");

                    String idAluno = palavra[0];
                    

                return idAluno;   

            }
        
        }
        
        public String lerNomeAluno() throws IOException{
            
		
            try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
                Scanner in = new Scanner(fis, "UTF-8");


                    String linha = in.nextLine();
                    String[] palavra = linha.split("\\;");

                    //String idAluno = palavra[0];
                    String nomeAluno = palavra[1];


                return nomeAluno;
            
        }
        
        }
}