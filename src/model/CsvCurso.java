package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import model.entities.Prova;
import model.entities.TipoDoCurso;

public class CsvCurso {

    public String caminhoCsv() {
        
        //Seta o caminho do arquivo curso.csv para o diretório do programa
        String caminho = System.getProperty("user.dir");
        
        //Seta o caminho para a pasta "files" do diretório do programa
        caminho += File.separator + "files";
        
        //Seta o caminho para o arquivo cursos.csv 
        caminho += File.separator + "cursos.csv";
        
        //Retorna toda a string do caminho
        return caminho;
    }

    //Método que lê o nome, tipo e ano dos cursos cadastrados no arquivo cursos.csv 
    public void lerCsvCurso() throws IOException {

        String nomeDoCurso, tipo;
        Integer anoDoCurso;
        TipoDoCurso tipoDoCurso = null;

        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            
            //Inicia a classe scanner pra poder fazer input pelo teclado
            Scanner in = new Scanner(fis, "UTF-8");
            
            do {
                
                //Lê como string todas as colunas de cada linha do arquivo cursos.csv
                String linha = in.nextLine();
                
                //Cria um vetor e armazena em cada índice como string cada coluna lida
                String[] palavra = linha.split("\\;");
                nomeDoCurso = palavra[0];
                tipo = palavra[1];
                
                //Confere qual o tipo do curso
                if (null != tipo) {
                    switch (tipo) {
                        case "GRADUACAO":
                            tipoDoCurso = TipoDoCurso.GRADUACAO;
                            break;
                        case "POS_GRADUACAO":
                            tipoDoCurso = TipoDoCurso.POSGRADUACAO;
                            break;
                        default:
                            System.out.println("Tipo do curso inválido.");
                            break;
                    }
                }

                //Transforma em inteiro o ano do curso
                anoDoCurso = Integer.parseInt(palavra[2]);
                
                //Cria o curso para poder salvar na lista de cursos
                Curso curso = new Curso(nomeDoCurso, anoDoCurso, tipoDoCurso);
                
                //Adiciona o curso criado a grade de cursos oferecidos
                Faculdade.gradeDeCursos.add(curso);
                
                //Método que lê o arquivo individual do curso lido 
                lerCurso(curso);

            } while (in.hasNextLine());
        }
    }

    /*
     Método que, para cada curso lido no arquivo cursos.csv 
     lê o arquivo csv específico do curso
     que contêm as notas dos alunos daquele curso
     */
    public void lerCurso(Curso curso) throws IOException {
        
        //Seta o caminho dos arquivos para a pasta do projeto
        String cursoCaminho = System.getProperty("user.dir");

        //Adiciona na string do caminho para setar a pasta "files"
        cursoCaminho += File.separator + "files";
        
        /*
        Pega as informações do curso a ser lido as notas e adiciona no caminho 
        seguindo a ordem Nome_Tipo_Ano.csv
        */
        cursoCaminho += File.separator
                + curso.getNomeDoCurso() + "_"
                + curso.getTipoDoCurso() + "_"
                + curso.getAnoDoCurso() + ".csv";

        FileInputStream fisCurso = new FileInputStream(cursoCaminho);
        Scanner inCurso = new Scanner(fisCurso, "UTF-8");
        
        /*
        Caso o documento não esteja vazio, vai ler o idDoAluno e as notas daquele aluno
        */
        
        if (inCurso.hasNextLine()) {
            do {
                //Lê como string as cinco colunas de cada linha
                String linhaCurso = inCurso.nextLine();
                String[] rendimento = linhaCurso.split("\\;");
                
                //Separa a coluna do id do aluno e salva como string
                String idDoAluno = rendimento[0];
                
                //Separa cada nota cadastrada no csv e já converte em double
                Double np1 = Double.parseDouble(rendimento[1]);
                Double np2 = Double.parseDouble(rendimento[2]);
                Double sub = Double.parseDouble(rendimento[3]);
                Double exame = Double.parseDouble(rendimento[4]);
                
                //Cria as notas já com a validação 0.0 <= nota <= 10.0
                Nota notaNp1 = new Nota(np1);
                Nota notaNp2 = new Nota(np2);
                Nota notaSub = new Nota(sub);
                Nota notaExame = new Nota(exame);

                //Passa as notas para o método que cria e adiciona elas no rendimento
                Rendimento rend = addNotas(notaNp1, notaNp2, notaSub, notaExame);
                
                Aluno aluno00 = new Aluno(idDoAluno, Faculdade.corpoDeAlunos.alunos.get(idDoAluno));
                
                //Adiciona as informações do aluno, do curso e do rendimento 
                Faculdade.historico.add(aluno00, curso, rend);

            } while (inCurso.hasNextLine());
        }
    }

    public Rendimento addNotas(Nota notaNp1, Nota notaNp2, Nota notaSub, Nota notaExame) {
        Rendimento rend = new Rendimento();

        rend.setNotas(Prova.NP1, notaNp1);
        rend.setNotas(Prova.NP2, notaNp2);
        rend.setNotas(Prova.SUB, notaSub);
        rend.setNotas(Prova.EXAME, notaExame);

        return rend;
    }
}
