
package view;

//import model.Aluno;

import java.io.IOException;
import model.CsvAluno;
import model.CsvCurso;


//import model.Nota;
//import model.Notas;
//import static model.entities.Prova.*;
//import model.CorpoDeAlunos;
//import model.Curso;
//import model.GradeDeCursos;
//import static model.entities.TipoDoCurso.*;

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
