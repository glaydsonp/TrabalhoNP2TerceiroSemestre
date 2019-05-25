package controller;

import model.exceptions.CheckSpecialCharactersInFields;
import java.util.Scanner;
import model.Aluno;
//import model.CorpoDeAlunos;
import model.Faculdade;
import view.AlunoView;
import view.MenuView;
import model.exceptions.InputWithSpecialCharactersException;

public class AlunoControl {

    Faculdade faculdade = new Faculdade();
    AlunoView view = new AlunoView();

    public void inicio() {
        boolean continua = true;
        while (continua) {
            int escolha = view.escolherOpcao();
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

//    public int menu() {
//        return view.escolherOpcao();
//    }

    public void inserirAluno() {
        boolean alunoInserido = false;
        while (alunoInserido == false) {
            try {
                Aluno aluno = this.pedirAluno();
                alunoInserido = Faculdade.corpoDeAlunos.add(aluno);
                
                if (alunoInserido == false) {
                    System.out.println("Aluno nao foi inserido");
                }
            } catch (InputWithSpecialCharactersException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }


    public void listarAlunos() {
        System.out.println("mostrando alunos");
        view.mostrarAlunos(Faculdade.corpoDeAlunos);
    }

    public Aluno pedirAluno() throws InputWithSpecialCharactersException {

        System.out.println("\nEntre com os dados do aluno:");
        Scanner in = new Scanner(System.in);
        System.out.print("ID: ");
        String novoId = in.nextLine();
        System.out.print("Nome: ");
        String novoNome = in.nextLine();

        CheckSpecialCharactersInFields error = new CheckSpecialCharactersInFields(novoNome, novoId);
        error.VerifyId();
        error.VerifyName();

        return new Aluno(novoId, novoNome);
    }
}
