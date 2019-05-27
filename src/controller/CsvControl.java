package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import model.Aluno;
import model.CorpoDeAlunos;
import model.ListaCurso;
import model.CsvAluno;
import model.CsvCurso;
import model.Curso;
import model.Faculdade;
import static model.Faculdade.corpoDeAlunos;

public class CsvControl {

    CsvAluno csvAluno = new CsvAluno();
    CsvCurso csvCurso = new CsvCurso();

    //Esse método vai chamar o CSV de Alunos para serem cadastrados no programa
    public void lerCsvAluno() throws IOException {
        csvAluno.lerCsvAluno();
    }

    //Esse método vai chamar o CSV de Cursos para serem cadastrados no programa
    public void lerCsvCurso() throws IOException {
        csvCurso.lerCsvCurso();
    }

    private static final String pontovirgula = ";";
    private static final String pulalinha = "\n";

    public void escreveAlunosCsv() throws IOException {

        //incializacao do filewriter
        FileWriter fileWriter = null;

        try {
            //aqui vai o nome do arquivo dentro de ( )
            fileWriter = new FileWriter("alunos.csv");

            Iterator<Map.Entry<String, String>> itr = corpoDeAlunos.alunos.entrySet().iterator();

            while (itr.hasNext()) {
                Map.Entry<String, String> entry = itr.next();
                fileWriter.append(entry.getKey());
                fileWriter.append(pontovirgula);
                fileWriter.append(entry.getValue());
                fileWriter.append(pulalinha);
            }
            System.out.println("Alteracoes em alunos.csv realizadas com sucesso!!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar alunos.csv.");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro durante flush/close.");
            }

        }
    }
    public void escreveCursosCsv() throws IOException {

        //incializacao do filewriter
        FileWriter fileWriter = null;

        try {
            //aqui vai o nome do arquivo dentro de ( )
            fileWriter = new FileWriter("cursos.csv");

            for (Curso aCurso : Faculdade.gradeDeCursos.listaCurso) {
                fileWriter.append(aCurso.getNomeDoCurso());
                fileWriter.append(pontovirgula);
                fileWriter.append(aCurso.getTipoDoCurso().toString());
                fileWriter.append(pontovirgula);
                fileWriter.append(aCurso.getAnoDoCurso().toString());
                fileWriter.append(pulalinha);
            }
            System.out.println("Alteracoes em cursos.csv realizadas com sucesso!!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar cursos.csv.");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro durante flush/close.");
            }

        }
    }
    
    //TODO
//    public void escreveCursoEspecificoCsv() throws IOException {
//        String nomeCurso = null;
//        //incializacao do filewriter
//        FileWriter fileWriter = null;
//
//        try {
//            for (Curso aCurso : Faculdade.gradeDeCursos.listaCurso){
//                nomeCurso = aCurso.getNomeDoCurso() +"_" 
//                        + aCurso.getTipoDoCurso().toString() +"_" 
//                        + aCurso.getAnoDoCurso().toString()) +".csv"
//                fileWriter.append(aCurso.getNomeDoCurso());
//                fileWriter.append(pontovirgula);
//                fileWriter.append(aCurso.getTipoDoCurso().toString());
//                fileWriter.append(pontovirgula);
//                fileWriter.append(aCurso.getAnoDoCurso().toString());
//                fileWriter.append(pulalinha);
//            
//            //aqui vai o nome do arquivo dentro de ( )
//            fileWriter = new FileWriter(nomeCurso);
//
//            
//            System.out.println("Alteracoes em " + nomeCurso +" realizadas com sucesso!!");
//            }
//        } catch (IOException e) {
//            System.out.println("Erro ao salvar cursos.csv.");
//        } finally {
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println("Erro durante flush/close.");
//            }
//
//        }
//    }
    

}
