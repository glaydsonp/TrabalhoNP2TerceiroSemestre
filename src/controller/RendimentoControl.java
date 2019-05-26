package controller;

import java.util.Scanner;
import model.Aluno;
import model.Faculdade;
import model.Curso;
import model.Nota;
import model.Rendimento;
import model.entities.Prova;
import model.exceptions.InputWithSpecialCharactersException;
import view.MenuView;
import view.RendimentoView;

public class RendimentoControl {

    Faculdade faculdade = new Faculdade();
    RendimentoView view = new RendimentoView();

    public void inicio() throws InputWithSpecialCharactersException {
        boolean continua = true;
        do {
            int escolha = menu();
            switch (escolha) {
                case 1:
                    inserirRendimento();
                    break;
                case 2:
                    MenuView start = new MenuView();
                    start.inicio();
                    break;
                default:
                    System.out.println("opcao nao listada");

            }
        } while (continua == true);

        System.exit(0);
    }

    public int menu() {
        return view.escolherOpcao();
    }

    public void inserirRendimento() throws InputWithSpecialCharactersException {

        Scanner in = new Scanner(System.in);
        CursoControl cursoC = new CursoControl();
        Rendimento rend = new Rendimento();

        System.out.println("Insira o Id do aluno: ");
        String id = in.nextLine();
        Aluno aluno = new Aluno(id, Faculdade.corpoDeAlunos.getAluno(id));

        Curso curso = cursoC.pedirCurso();

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
}
