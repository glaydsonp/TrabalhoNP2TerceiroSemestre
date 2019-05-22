
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import model.entities.TipoDoCurso;
import static model.entities.TipoDoCurso.GRADUACAO;

public class CsvCurso {

//    public Map<String, String> corpoDeAlunos = new HashMap<>();

    GradeDeCursos grade = new GradeDeCursos();
    
    public String caminhoCsv() {
        String caminho = System.getProperty("user.dir");
        caminho += File.separator + "cursos.csv";
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
    public void lerCsvCurso() throws IOException {
        String nomeDoCurso, tipo;
        Integer anoDoCurso;
        TipoDoCurso tipoDoCurso = null;
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            do {
                String linha = in.nextLine();
                String[] palavra = linha.split("\\;");
                nomeDoCurso = palavra[0];
                tipo = palavra[1];
                if(null != tipo)switch (tipo) {
                    case "GRADUACAO":
                        tipoDoCurso = GRADUACAO;
                        break;
                    case "POS_GRADUACAO":
                        tipoDoCurso = TipoDoCurso.POS_GRADUACAO;
                        break;
                    default:
                        System.out.println("Tipo do curso inválido.");
                        break;
                }
                anoDoCurso = Integer.parseInt(palavra[2]);
//                corpo.put(idAluno, nomeAluno);
//                in.nextLine();
                Curso curso = new Curso(nomeDoCurso, anoDoCurso, tipoDoCurso);
                Faculdade.gradeDeCursos.add(curso);
//                System.out.println(aluno);
//                System.out.println(idAluno);
//                System.out.println(nomeAluno);
            } while (in.hasNextLine());
        }
    }

}


