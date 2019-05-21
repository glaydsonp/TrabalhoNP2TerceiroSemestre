//package model;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//import model.entities.Prova;
//import model.entities.TipoDoCurso;
///*So far, a classe de LerCsv esta lendo os dados dos arquivos .csv
//* e exportando os dados em forma de 3 HashMaps, 
//
//
//
//*/
//
//public class LerCsv {
//    //indice idAluno, valor nome do aluno
//    Map<String, String> corpoDeAlunos = new HashMap<>();
//    //indice id do curso (juncao de nome, nivel e ano), valor e um objeto curso
//    Map<String, Curso> corpoDeCursos = new HashMap<>();
//    //indice id do aluno, valor o rendimento do aluno
//    Map<String, Rendimento> corpoDeRendimentos = new HashMap<>();
//
//    //TODO
//    //csv.1: metodo que cria uma lista com todos os arquivos csv, e invoca os metodos de leitura para cada
//    public void criaLista() throws IOException {
//        File folder = new File(caminhoCsv());
//        File[] listOfFiles = folder.listFiles();
//        for (File listOfFile : listOfFiles) {
//            if (listOfFile.isFile()) {
//                if (listOfFile.getAbsolutePath().endsWith(".csv")) {
//                    System.out.println("File " + listOfFile.getName());
//                    if (listOfFile.getName().equals("alunos.csv")) {
//                        System.out.println("csv dos alunos: " + listOfFile.getName());
//                        lerCsvAluno();
//                    } 
//                    else if (listOfFile.getName().equals("cursos.csv")) {
//                        System.out.println("csv dos cursos: " + listOfFile.getName());
//                        lerCsvCurso();
//                    } 
//                    else {
//                        System.out.println("csv especifico de cada curso: " + listOfFile.getName());
//                            lerCsvEspecifico(listOfFile);
//                    }
//                }
//            } else {
//                System.out.println("");
//            }
//        }
//    }
//
//    //csv.2: metodo que define o caminho em que estarao os arquivos csv
//    public String caminhoCsv() {
//        String caminho = System.getProperty("user.dir");
//        caminho += File.separator;
//        return caminho;
//    }
//
////    //csv.3: metodo que escreve os ids e nomes dos alunos que forem editados/adicionados
////    public void escreveCsvAluno() {            
////        String id = escreveIdAluno();
////        String nome = escreveNomeAluno();           
////    }
////    
////    //csv.3.1:metodo para escrever o id do aluno
////    private String escreveIdAluno(){          
////        String id = "";			
////        System.out.println("Coloque o Id do Aluno");
////	Scanner in = new Scanner(System.in);
////        id = in.nextLine();			
////        return id;
////    }
////    
////    //csv.3.2: metodo para escrever o nome do aluno
////    private String escreveNomeAluno(){
////        String nome = "";			
////        System.out.println("Coloque o nome do Aluno");
////        Scanner in = new Scanner(System.in);
////	nome = in.nextLine();				
////        return nome;	
////    }
//    //csv.4: metodo que le os ids e nomes dos alunos do alunos.csv 
//    public void lerCsvAluno() throws IOException {
//        String idAluno;
//        String nomeAluno;
//        try (FileInputStream fis = new FileInputStream(caminhoCsv() + "alunos.csv")) {
//            Scanner in = new Scanner(fis, "UTF-8");
//            do {
//                String linha = in.nextLine();
//                String[] palavra = linha.split("\\;");
//                idAluno = palavra[0];
//                nomeAluno = palavra[1];
//                corpoDeAlunos.put(idAluno, nomeAluno);
//                System.out.println(idAluno);
//                System.out.println(nomeAluno);
//            } while (in.hasNextLine());
//        } catch (FileNotFoundException e) {
//            System.out.println("Arquivo nao encontrado.");
//        }
//    }
//
//    //csv.5: metodo que le os nomes,niveis e anos dos cursos do cursos.csv
//    public void lerCsvCurso() throws IOException {
//        String nomeCurso;
//        String nivel;
//        String anoString;
//        TipoDoCurso tipoDoCurso;
//        Integer anoDoCurso;
//        try (FileInputStream fis = new FileInputStream(caminhoCsv() + "cursos.csv")) {
//            Scanner in = new Scanner(fis, "UTF-8");
//            do {
//                Curso curso = new Curso();
//                String linha = in.nextLine();
//                String[] palavra = linha.split("\\;");
//                nomeCurso = palavra[0];
//                nivel = palavra[1];
//                anoString = palavra[2];
//                anoDoCurso = Integer.parseInt(anoString);
//                tipoDoCurso = TipoDoCurso.valueOf(nivel);
//                curso.setNomeDoCurso(nomeCurso);
//                curso.setAnoDoCurso(anoDoCurso);
//                curso.setTipoDoCurso(tipoDoCurso);
//                corpoDeCursos.put(nomeCurso + "_" + nivel + "_" + anoDoCurso, curso);
//                //print para teste
//                System.out.println(nomeCurso + "_" + nivel + "_" + anoDoCurso);
//                System.out.println(nomeCurso);
//                System.out.println(nivel);
//                System.out.println(anoDoCurso + "\n--------");                
//            } while (in.hasNextLine());
//        } catch (FileNotFoundException e) {
//            System.out.println("Arquivo nao encontrado.");
//        }
//    }
//
//
//
////    csv.6: metodo que le o id do aluno, np1, np2,reposicao e exame, do 'curso_fulano.csv' 
//    public void lerCsvEspecifico(File listOfFile) throws IOException {
//        String id_do_aluno ;
//        Double nota_NP1 ;
//        Double nota_NP2 ;
//        Double nota_reposicao;
//        Double nota_exame ;
//try (FileInputStream fis = new FileInputStream(caminhoCsv() + listOfFile.getName())) {
//            Scanner in = new Scanner(fis, "UTF-8");
//            do {//cria um novo curso
//                Curso cursoRendimento = new Curso();
//                //transforma o nome do arquivo como um vetor de strings
//                String tituloCurso = listOfFile.getName();
//                String[] titulo = tituloCurso.split("\\_"); 
//                //coloca os atributos do curso de acordo com os strings do vetor do nome do arquivo
//                cursoRendimento.setNomeDoCurso(titulo[0]);
//                cursoRendimento.setTipoDoCurso(TipoDoCurso.valueOf(titulo[1]));
//                cursoRendimento.setAnoDoCurso(Integer.parseInt(titulo[2]));
//                //cria um novo rendimento
//                Rendimento rendimento = new Rendimento(cursoRendimento);
//                //transforma os dados do input do arquivo (textos dentro do .csv) em vetor de strings
//                String linha = in.nextLine();
//                String[] palavra = linha.split("\\;");
//                //seta as variaveis de acordo com as strings do vetor de dados
//                id_do_aluno = palavra[0];
//                //as notas no arquivo estao aqui como strings, entao eh necessario transformar em numeros tipo Double
//                nota_NP1 = Double.parseDouble(palavra[1]);
//                nota_NP2 = Double.parseDouble(palavra[2]);
//                nota_reposicao = Double.parseDouble(palavra[3]);
//                nota_exame = Double.parseDouble(palavra[4]);
//                
//                //seta as notas como atributos do rendimento
//                rendimento.setNotas(Prova.NP1, nota_NP1);
//                rendimento.setNotas(Prova.NP2, nota_NP2);
//                rendimento.setNotas(Prova.SUB, nota_reposicao);
//                rendimento.setNotas(Prova.EXAME, nota_exame);
//                
//                //seta o id do aluno que possui o rendimento acima
//                corpoDeRendimentos.put(id_do_aluno, rendimento);
//                //print para teste
//                System.out.println("RA: "+ id_do_aluno);
//                System.out.println("NP1: " + nota_NP1);
//                System.out.println("NP2: " + nota_NP2);
//                System.out.println("SUB: " + nota_reposicao);
//                System.out.println("EXAME: " + nota_exame);                
//            } while (in.hasNextLine());
//        } catch (FileNotFoundException e) {
//            System.out.println("Arquivo nao encontrado.");
//        }
//    }
//
//}
