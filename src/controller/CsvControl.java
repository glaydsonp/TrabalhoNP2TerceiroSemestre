package controller;

import java.io.IOException;
import model.CsvAluno;
import model.CsvCurso;

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

}
