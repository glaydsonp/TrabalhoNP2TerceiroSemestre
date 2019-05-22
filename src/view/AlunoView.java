package view;

import java.util.Scanner;
import model.Aluno;
import model.CorpoDeAlunos;

public class AlunoView {

    public int escolherOpcao() {
        System.out.println("\n1 - Para inserir um novo aluno.\n2 - Para voltar ao menu principal. ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public void mostrarAlunos(CorpoDeAlunos quadro) {
        System.out.println(quadro);
    }

    public Aluno pedirAluno() {

        System.out.println("Entre com os dados do aluno");

        Scanner in = new Scanner(System.in);
        System.out.println("ID: ");
        String novoId = in.nextLine();
        System.out.println("Nome: ");
        String novoNome = in.nextLine();

        return new Aluno(novoId, novoNome);
    }
}
