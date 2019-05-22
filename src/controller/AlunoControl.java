package controller;

import model.Aluno;
//import model.CorpoDeAlunos;
import model.Faculdade;
import view.AlunoView;
import view.MenuView;

public class AlunoControl {

    Faculdade faculdade = new Faculdade();
    AlunoView view = new AlunoView();

    public void inicio() {
        boolean continua = true;
        while (continua) {
            int escolha = menu();
            switch (escolha) {
                case 1:
                    inserirAluno();
                    break;
                case 2:
                    MenuView start = new MenuView();
                    start.inicio();
                    break;
                default:
                    System.out.println("opcao nao listada");
            }
        }
        System.exit(0);
    }

    public int menu() {
        return view.escolherOpcao();
    }

    public void inserirAluno() {
        boolean alunoInserido = false;

        while (alunoInserido == false) {

            Aluno aluno = view.pedirAluno();

            alunoInserido = Faculdade.corpoDeAlunos.add(aluno);
            if (alunoInserido == false) {
                System.out.println("Aluno nao foi inserido");
            }
        }
    }

    public void listarAlunos() {
//        CorpoDeAlunos corpo = new CorpoDeAlunos();
        System.out.println("mostrando alunos");
        view.mostrarAlunos(Faculdade.corpoDeAlunos);
    }
}
