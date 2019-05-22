package controller;

import java.io.IOException;
import model.CsvAluno;
import model.CsvCurso;

public class CsvControl {

    CsvAluno csvAluno = new CsvAluno();
    CsvCurso csvCurso = new CsvCurso();

    public void lerCsvAluno() throws IOException {
        csvAluno.lerCsvAluno();
    }

    public void lerCsvCurso() throws IOException {
        csvCurso.lerCsvCurso();
    }

}
