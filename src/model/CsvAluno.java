
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CsvAluno {

//    public Map<String, String> corpoDeAlunos = new HashMap<>();

    CorpoDeAlunos corpo = new CorpoDeAlunos();
    
    public String caminhoCsv() {
        String caminho = System.getProperty("user.dir");
        caminho += File.separator + "alunos.csv";
        System.out.println(caminho);
        return caminho;
    }
//    csv.3: metodo que escreve os ids e nomes dos alunos que forem editados/adicionados
//    public void escreveCsvAluno() {            
//        String id = escreveIdAluno();
//        String nome = escreveNomeAluno();           
//    }
//    
//    //csv.3.1:metodo para escrever o id do aluno
//    private String escreveIdAluno(){          
//        String id = "";			
//        System.out.println("Coloque o Id do Aluno");
//	Scanner in = new Scanner(System.in);
//        id = in.nextLine();			
//        return id;
//    }
//    
//    //csv.3.2: metodo para escrever o nome do aluno
//    private String escreveNomeAluno(){
//        String nome = "";			
//        System.out.println("Coloque o nome do Aluno");
//        Scanner in = new Scanner(System.in);
//	nome = in.nextLine();				
//        return nome;	
//    }

    //csv.4: metodo que le os ids e nomes dos alunos do alunos.csv 
    public void lerCsvAluno() throws IOException {
        String idAluno;
        String nomeAluno;
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            do {
                String linha = in.nextLine();
                String[] palavra = linha.split("\\;");
                idAluno = palavra[0];
                nomeAluno = palavra[1];
//                corpo.put(idAluno, nomeAluno);
//                in.nextLine();
                Aluno aluno = new Aluno(idAluno, nomeAluno);
                Faculdade.corpoDeAlunos.add(aluno);
//                System.out.println(aluno);
//                System.out.println(idAluno);
//                System.out.println(nomeAluno);
            } while (in.hasNextLine());
        }
    }

}


