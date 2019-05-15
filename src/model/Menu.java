
package model;

import java.util.Scanner;

public class Menu {

    public Menu() {
    }
    
    public int escolherOpcao(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    
    @Override
    public String toString() {
        return "Menu{\n" + 
                "1 - Listar os cursos dados\n" +
                "2 - Listar todos os alunos inscritos\n" +
                "3 - Listar o histórico de um aluno em específico\n" + 
                "4 - Listar o relatório de rendimento de um ou mais cursos\n" +
                "5 - Incluir um novo aluno\n" +
                "6 - Incluir um novo curso\n" +
                "7 - Incluir um novo rendimento\n" +
                "8 - Para fechar o programa\n" +
                '}';
    }
    
}
