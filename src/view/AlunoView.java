package view;

import java.util.Scanner;
import model.Aluno;
import model.CorpoDeAlunos;

public class AlunoView {

    public int escolherOpcao() {
//        System.out.print("--------- MENU ---------");
        System.out.println("\n1 - Para inserir um novo aluno.\n2 - Para voltar ao menu principal. ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public void mostrarAlunos(CorpoDeAlunos quadro) {
        System.out.println(quadro);
    }
}
