
package controller;

import java.util.InputMismatchException;
import model.Curso;
import model.Faculdade;
import view.CursoView;
import view.MenuView;

public class RendimentoControl {
    Faculdade faculdade = new Faculdade();
    CursoView view = new CursoView();

    public void inicio() {
        boolean continua = true;
        do {
            try {
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
                    throw new InputMismatchException("Opção não listada! Insira uma das opções acima.");
               }
            } catch (InputMismatchException e) {
                if(e.getMessage() != null){
                    System.out.println("Erro: " + e.getMessage());
                } else{
                    System.out.println("Erro: Opção não listada! Insira inteiros para escolher uma opção.");
                }
            }
            
        } while (continua == true);
        System.exit(0);
    }

    public int menu() {
        return view.escolherOpcao();
    }

    public void inserirRendimento() {
//
//        System.out.println("mostrando cursos");
//        view.mostrarCursos(faculdade.gradeDeCursos);
//
//        boolean cursoInserido = false;
//
//        while (cursoInserido == false) {
//
//            Curso curso = view.pedirCurso();
//
//            cursoInserido = faculdade.gradeDeCursos.add(curso);
//            if (cursoInserido == false) {
//                System.out.println("Curso nao foi inserido");
//            }
//        }
//
//        System.out.println("mostrando cursos");
//        view.mostrarCursos(faculdade.gradeDeCursos);

    }
}
