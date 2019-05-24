package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import model.entities.Prova;
import model.entities.TipoDoCurso;
import static model.entities.TipoDoCurso.GRADUACAO;

public class CsvCurso {

    public String caminhoCsv() {
        String caminho = System.getProperty("user.dir");
        caminho += File.separator + "files";
        caminho += File.separator + "cursos.csv";
        return caminho;
    }

    //csv.4: metodo que le os ids e nomes dos alunos do cursos.csv 
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
                if (null != tipo) {
                    switch (tipo) {
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
                }

                anoDoCurso = Integer.parseInt(palavra[2]);
                Curso curso = new Curso(nomeDoCurso, anoDoCurso, tipoDoCurso);
                Faculdade.gradeDeCursos.add(curso);
                lerCurso(curso);

            } while (in.hasNextLine());
        }
    }

    /*
    Método que, para cada curso lido no arquivo cursos.csv, lê o arquivo csv específico do curso
    que contêm as notas dos alunos daquele curso
    */
    public void lerCurso(Curso curso) throws IOException {

        String cursoCaminho = System.getProperty("user.dir");

        cursoCaminho += File.separator + "files";
        cursoCaminho += File.separator
                + curso.getNomeDoCurso() + "_"
                + curso.getTipoDoCurso() + "_"
                + curso.getAnoDoCurso() + ".csv";

        FileInputStream fisCurso = new FileInputStream(cursoCaminho);
        Scanner inCurso = new Scanner(fisCurso, "UTF-8");

        if (inCurso.hasNextLine()) {
            do {
                String linhaCurso = inCurso.nextLine();
                String[] rendimento = linhaCurso.split("\\;");

                String idDoAluno = rendimento[0];
                Double np1 = Double.parseDouble(rendimento[1]);
                Double np2 = Double.parseDouble(rendimento[2]);
                Double sub = Double.parseDouble(rendimento[3]);
                Double exame = Double.parseDouble(rendimento[4]);

                Nota notaNp1 = new Nota(np1);
                Nota notaNp2 = new Nota(np2);
                Nota notaSub = new Nota(sub);
                Nota notaExame = new Nota(exame);

                Notas notas = new Notas();

                notas.add(Prova.NP1, notaNp1);
                notas.add(Prova.NP2, notaNp2);
                notas.add(Prova.SUB, notaSub);
                notas.add(Prova.EXAME, notaExame);
                
                System.out.println(curso.toString());
                System.out.println("Id: " + idDoAluno);
                System.out.println("Nome: " + Faculdade.corpoDeAlunos.getAluno(idDoAluno));
                System.out.println("NP1: " + np1);
                System.out.println("NP2: " + np2);
                System.out.println("SUB: " + sub);
                System.out.println("EXAME: " + exame);
            } while (inCurso.hasNextLine());
        }

    }

}
