package controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Aluno;
import model.Curso;
import model.Faculdade;
import model.Nota;
import model.Rendimento;
import model.entities.Prova;
import model.exceptions.CheckSpecialCharactersInFields;
import model.exceptions.InputWithSpecialCharactersException;
import view.MenuView;
import view.RendimentoView;

public class RendimentoControl {

    Faculdade faculdade = new Faculdade();
    RendimentoView view = new RendimentoView();
    Scanner in = new Scanner(System.in);

    public void inicio() throws InputWithSpecialCharactersException, IOException {
        boolean continua = true;
        do {
            try {
                int escolha = menu();
                switch (escolha) {
                    case 1:
                        //Inicia o método de inserir rendimento
                        inserirRendimento();
                        break;
                    case 2:
                        //Retorna ao menu principal
                        MenuView start = new MenuView();
                        start.inicio();
                        break;
                    default:
                        throw new InputMismatchException("Opção não listada! Insira uma das opções acima.");
                }
            } catch (InputMismatchException e) {
                if (e.getMessage() != null) {
                    System.out.println("Erro: " + e.getMessage());
                } else {
                    System.out.println("Erro: Opção não listada! Insira inteiros para escolher uma opção.");
                }
            }

        } while (continua == true);
        System.exit(0);
    }

    public int menu() {
        return view.escolherOpcao();
    }

    //Método que insere um novo rendimento
    public void inserirRendimento() throws InputWithSpecialCharactersException {

        CursoControl cursoC = new CursoControl();
        Rendimento rend = new Rendimento();

        /*
         Pede o id do aluno e puxa o nome do aluno diretamente do cadastro
         Cria um novo objeto aluno para inserção do rendimento no histórico
         */
        System.out.println("Insira o Id do aluno: ");
        String id = in.nextLine();

        /*
         Método para verificar se a entrada do usuário possui apenas caracteres válidos
         */
        CheckSpecialCharactersInFields error = new CheckSpecialCharactersInFields(id);
        error.VerifyId();

        //Cria um novo objeto aluno para inserir no histórico
        Aluno aluno = new Aluno(id, Faculdade.corpoDeAlunos.getAluno(id));

        //Chama o método de pedir curso (mesmo método que pede um curso pra inserção)
        Curso curso = cursoC.pedirCurso();

        //Chama o método de pedir as notas e retorna um vetor com todas as notas
        Double[] notas = view.pedirNotas();

        Nota notaNp1 = this.transformaNota(notas[0]);
        Nota notaNp2 = this.transformaNota(notas[1]);
        Nota notaSub = this.transformaNota(notas[2]);
        Nota notaExame = this.transformaNota(notas[3]);

        rend.setNotas(Prova.NP1, notaNp1);
        rend.setNotas(Prova.NP2, notaNp2);
        rend.setNotas(Prova.SUB, notaSub);
        rend.setNotas(Prova.EXAME, notaExame);

        Faculdade.historico.add(aluno, curso, rend);

    }

    public Nota transformaNota(Double valor) {
        Nota nota = new Nota(valor);
        return nota;
    }

    public Double inserirNota() {
        Double valor = in.nextDouble();

        while (valor > 10.0 || valor < 0.0) {
            System.out.println("Nota inválida, por favor insira novamente.");
            valor = in.nextDouble();
        }

        return valor;
    }
}
