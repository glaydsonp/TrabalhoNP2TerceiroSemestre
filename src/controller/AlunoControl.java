package controller;

import model.Aluno;
import model.CorpoDeAlunos;
import model.Faculdade;
import view.AlunoView;

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
                    continua = false;
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
        
        

        System.out.println("mostrando alunos");
        view.mostrarAlunos(faculdade.corpoDeAlunos);

        boolean alunoInserido = false;

        while (alunoInserido == false) {

            Aluno aluno = view.pedirAluno();

            alunoInserido = faculdade.corpoDeAlunos.add(aluno);
            if (alunoInserido == false) {
                System.out.println("Aluno nao foi inserido");
            }
        }

        System.out.println("mostrando alunos");
        view.mostrarAlunos(faculdade.corpoDeAlunos);

    }
    
    public void listarAlunos(){
        CorpoDeAlunos grade = new CorpoDeAlunos();
        grade.listarAlunos();
        
    }
}
