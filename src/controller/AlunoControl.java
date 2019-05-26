package controller;

import java.util.InputMismatchException;
import model.exceptions.CheckSpecialCharactersInFields;
import java.util.Scanner;
import model.Aluno;
import model.Faculdade;
import view.AlunoView;
import view.MenuView;
import model.exceptions.InputWithSpecialCharactersException;

public class AlunoControl {

    Faculdade faculdade = new Faculdade();
    AlunoView view = new AlunoView();

    public void inicio() throws InputWithSpecialCharactersException {
        boolean continua = true;
        while (continua) {
            try {
                int escolha = view.escolherOpcao();
                switch (escolha) {
                case 1:
                    //Inicia o método de inserir aluno
                    inserirAluno();
                    break;
                case 2:
                    //Retorna ao menu principal
                    MenuView start = new MenuView();
                    start.inicio();
                    break;
                default:
                    System.out.println("Opção não listada! Insira uma das opções acima.");
                }
            } catch (InputMismatchException e) {
                if(e.getMessage() != null){
                    System.out.println("Erro: " + e.getMessage());
                } else{
                    System.out.println("Erro: Opção não listada! Insira inteiros para escolher uma opção.");
                }
            }
            
        }
        System.exit(0);
    }

    //Método que insere um novo aluno
    public void inserirAluno() {
        boolean alunoInserido = false;
        while (alunoInserido == false) {
            try {
                Aluno aluno = this.pedirAluno();

                /*
                Essa variável retorna verdadeira se o aluno for inserido
                Retorna falso e quebra o while se o aluno não tiver sido inserido
                O aluno não será inserido quando já houver um aluno com aquele id
                */                
                alunoInserido = Faculdade.corpoDeAlunos.add(aluno);

                if (alunoInserido == false) {
                    System.out.println("Aluno nao foi inserido");
                }
            } //Pega a exceção caso o usuário digite caracteres não permitidos no campo nome ou id
            catch (InputWithSpecialCharactersException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    //Método que lista todos os alunos cadastrados
    public void listarAlunos() {
        view.mostrarAlunos(Faculdade.corpoDeAlunos);
    }

    //Método que pede os dados do aluno a ser inserido
    public Aluno pedirAluno() throws InputWithSpecialCharactersException {

        System.out.println("\nEntre com os dados do aluno:");
        Scanner in = new Scanner(System.in);
        System.out.print("ID: ");
        String novoId = in.nextLine();
        System.out.print("Nome: ");
        String novoNome = in.nextLine();

        /*
        Classe CheckSpecialCharactersInFields vai checar todos os caracteres inseridos pelo usuário
        Irá verificar e, quando aplicado, lançará uma exceção que dirá se existe caracter não permitido
        Checa tanto no campo ID quanto no campo NOME
        */
        CheckSpecialCharactersInFields error = new CheckSpecialCharactersInFields(novoNome, novoId);
        error.VerifyId();
        error.VerifyName();
        
        /*
        Caso não haja nenhum conflito, o método retornará um aluno construído 
        para ser adicionado no método inserirAluno() lá em cima
         */
        return new Aluno(novoId, novoNome);
    }
}
