
package view;

import model.Aluno;
import java.io.IOException;
import model.CsvAluno;
import model.CsvCurso;

public class Main {
    public static void main(String[] args) throws IOException{
  
        CsvAluno csvAluno = new CsvAluno();
        CsvCurso csvCurso = new CsvCurso();
        csvAluno.lerCsvAluno();
        csvCurso.lerCsvCurso();

        MenuView start = new MenuView(); 
        start.inicio();
               
    }
}
