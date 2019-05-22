package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import model.entities.TipoDoCurso;
import static model.entities.TipoDoCurso.GRADUACAO;

public class CsvCurso {

    public String caminhoCsv() {
        String caminho = System.getProperty("user.dir");
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
            } while (in.hasNextLine());
        }
    }

}
