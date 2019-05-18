package controller;

import model.Curso;
import model.Faculdade;
import view.CursoView;
import view.MenuView;

public class CursoControl {
    
    Faculdade faculdade = new Faculdade();
    CursoView view = new CursoView();

    public void inicio() {
        boolean continua = true;
        do {
            int escolha = menu();
            switch (escolha) {
                case 1:
                    inserirCurso();
                    System.out.println("aqui");
                    break;
                case 2:
                    MenuView start = new MenuView();
                    start.inicio();
                    break;
                default:
                    System.out.println("opcao nao listada");

            }}while (continua == true);

        
        System.exit(0);
    }

    public int menu() {
        return view.escolherOpcao();
    }

    public void inserirCurso() {
        boolean cursoInserido = false;

        while (cursoInserido == false) {

            Curso curso = view.pedirCurso();

            cursoInserido = Faculdade.gradeDeCursos.add(curso);
            if (cursoInserido == false) {
                System.out.println("Curso nao foi inserido");
            }
        }
        System.out.println("mostrando cursos");
        view.mostrarCursos(Faculdade.gradeDeCursos);

    }    
    public void listarCursos(){
        System.out.println("mostrando cursos");
        view.mostrarCursos(Faculdade.gradeDeCursos);
    }
}
