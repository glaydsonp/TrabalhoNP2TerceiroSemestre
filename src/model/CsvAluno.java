
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CsvAluno {
    
    public String caminhoCsv() {
        String caminho = System.getProperty("user.dir");
        caminho += File.separator + "alunos.csv";
        return caminho;
    }

    //csv.4: metodo que le os ids e nomes dos alunos do alunos.csv 
    public void lerCsvAluno() throws IOException {
        String idAluno;
        String nomeAluno;
        try (FileInputStream fis = new FileInputStream(caminhoCsv())) {
            Scanner in = new Scanner(fis, "UTF-8");
            do {
                String linha = in.nextLine();
                String[] palavra = linha.split("\\;");
                idAluno = palavra[0];
                nomeAluno = palavra[1];
                Aluno aluno = new Aluno(idAluno, nomeAluno);
                Faculdade.corpoDeAlunos.add(aluno);

            } while (in.hasNextLine());
        }
    }

}


