
package view;


import controller.CsvControl;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
  
//        CsvControl csvControl = new CsvControl();
//        csvControl.lerCsvAluno();
//        csvControl.lerCsvCurso();

        MenuView menu = new MenuView(); 
        menu.inicio();
               
    }
}
