
package br.com.UNIPSGF.model.vo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Csv {
    //csv.1: metodo que cria uma lista com todos os arquivos csv, e invoca os metodos de leitura para cada
    public void criaLista() throws IOException{
        File folder = new File(caminhoCsv());
        File[] listOfFiles = folder.listFiles();
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    System.out.println("File " + listOfFile.getName());
                    switch (listOfFile.getName()) {
                        case "alunos.csv":
                            System.out.println("csv dos alunos: " + listOfFile.getName());
                            lerCsvAluno();
                            break;
                        case "cursos.csv":
                            System.out.println("csv dos cursos: " + listOfFile.getName());
                            lerCsvCurso();
                            break;
                        default:
                            System.out.println("csv especifico de cada curso: " + listOfFile.getName());
                            lerCsvEspecifico();
                            break;
                    }
                } else if (listOfFile.isDirectory()) {
                    System.out.println("Directory " + listOfFile.getName());
                }
                else{
                    System.out.println("erro.");
                }
            }
        }
    //csv.2: metodo que define o caminho em que estarao os arquivos csv
    public String caminhoCsv(){        
        String caminho = System.getProperty("user.dir");        
    return caminho;
    }

    //csv.3: metodo que escreve os ids e nomes dos alunos que forem editados/adicionados
    public void escreveCsvAluno() {            
        String id = escreveIdAluno();
        String nome = escreveNomeAluno();           
    }
    
    //csv.3.1:metodo para escrever o id do aluno
    private String escreveIdAluno(){          
        String id = "";			
        System.out.println("Coloque o Id do Aluno");
	Scanner in = new Scanner(System.in);
        id = in.nextLine();			
        return id;
    }
    
    //csv.3.2: metodo para escrever o nome do aluno
    private String escreveNomeAluno(){
        String nome = "";			
        System.out.println("Coloque o nome do Aluno");
        Scanner in = new Scanner(System.in);
	nome = in.nextLine();				
        return nome;	
    }
        
    //csv.4: metodo que le os ids e nomes dos alunos do alunos.csv 
    public void lerCsvAluno() throws IOException{
        String id = lerIdAluno();
        String nome = lerNomeAluno();     
    }
    
    //csv.4.1:metodo para ler o id do aluno            
    public String lerIdAluno() throws IOException{ 
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            String linha = in.nextLine();
            String[] palavra = linha.split("\\;");
            String idAluno = palavra[0];                  
            return idAluno;   
        }                    
    }
    
    //csv.4.2:metodo para ler o nome do aluno        
    public String lerNomeAluno() throws IOException{ 
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
                String linha = in.nextLine();
                String[] palavra = linha.split("\\;");
                String nomeAluno = palavra[1];
                return nomeAluno;
        }        
    }
    
    //csv.5: metodo que le os nomes,niveis e anos dos cursos do cursos.csv
    public void lerCsvCurso() throws IOException{
            String id = lerNomeCurso();
            String nome = lerNivelCurso();
            Integer ano = lerAnoCurso();
    }
    
    //csv.5.1: metodo para ler os nomes dos cursos
    public String lerNomeCurso() throws IOException{ 
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
                Scanner in = new Scanner(fis, "UTF-8");
                String linha = in.nextLine();
                String[] palavra = linha.split("\\;");
                String nomeCurso = palavra[0];
            return nomeCurso; 
        }
    }
    
    //csv.5.2: metodo para ler os niveis dos cursos
    public String lerNivelCurso() throws IOException{
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            String linha = in.nextLine();
            String[] palavra = linha.split("\\;");
            String nivelCurso = palavra[1];
            return nivelCurso;
        }
    }
    
    //csv.5.3: metodo para ler os anos dos cursos
    public Integer lerAnoCurso() throws IOException{
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            String linha = in.nextLine();
            String[] palavra = linha.split("\\;");
            String anoCursoString = palavra[2];
            Integer anoCurso;
            anoCurso = Integer.parseInt(anoCursoString);
            return anoCurso;
        }
    }
    
    //csv.6: metodo que le o id do aluno, np1, np2,reposicao e exame, do 'curso_fulano.csv' 
    public void lerCsvEspecifico() throws IOException{
    String id_do_aluno = lerIdAlunoEspecifico();
    Double nota_NP1 = lerNP1();
    Double nota_NP2 = lerNP2();
    Double nota_reposicao = lerSUB();
    Double nota_exame = lerEXAME();
//        System.out.println("");
    }
    
    //csv.6.1: metodo para ler o id do 'curso_fulano.csv'
    public String lerIdAlunoEspecifico() throws IOException{ 
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            String linha = in.nextLine();
            String[] palavra = linha.split("\\;");
            String idAlunoEspecifico = palavra[0];                  
            return idAlunoEspecifico;   
        }                    
    }
    
    //csv.6.2: metodo para ler a nota p1 do 'curso_fulano.csv'
    private Double lerNP1() throws IOException{
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            String linha = in.nextLine();
            String[] palavra = linha.split("\\;");
            String nota_NP1String = palavra[1];
            Double nota_NP1;
            nota_NP1 = Double.parseDouble(nota_NP1String);
            return nota_NP1;
        }
    }
    
    //csv.6.3: metodo para ler a nota p2 do 'curso_fulano.csv'
    private Double lerNP2() throws IOException {
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            String linha = in.nextLine();
            String[] palavra = linha.split("\\;");
            String nota_NP2String = palavra[2];
            Double nota_NP2;
            nota_NP2 = Double.parseDouble(nota_NP2String);
            return nota_NP2;
        }
    }

    //csv.6.4: metodo para ler a nota da sub/reposicao do 'curso_fulano.csv'
    private Double lerSUB() throws IOException {
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            String linha = in.nextLine();
            String[] palavra = linha.split("\\;");
            String nota_reposicaoString = palavra[3];
            Double nota_reposicao;
            nota_reposicao = Double.parseDouble(nota_reposicaoString);
            return nota_reposicao;
        }
    }

    //csv.6.5: metodo para ler a nota do exame do 'curso_fulano.csv'
    private Double lerEXAME() throws IOException {
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            String linha = in.nextLine();
            String[] palavra = linha.split("\\;");
            String nota_exameString = palavra[4];
            Double nota_exame;
            nota_exame = Double.parseDouble(nota_exameString);
            return nota_exame;
        }       
    }
}