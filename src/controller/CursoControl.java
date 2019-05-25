package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Curso;
import model.Faculdade;
import model.GradeDeCursos;
import model.entities.TipoDoCurso;
import model.exceptions.CheckSpecialCharactersInFields;
import model.exceptions.InputWithSpecialCharactersException;
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
                    break;
                case 2:
                    MenuView start = new MenuView();
                    start.inicio();
                    break;
                default:
                    System.out.println("Opção não listada.");

            }
        } while (continua == true);
        
        System.exit(0);
    }

    public int menu() {
        return view.escolherOpcao();
    }

    public void inserirCurso() {
        boolean cursoInserido = false;

        while (cursoInserido == false) {

            try {
                Curso curso = this.pedirCurso();
                
                cursoInserido = Faculdade.gradeDeCursos.add(curso);
                if (cursoInserido == false) {
                    System.out.println("Curso nao foi inserido");
                }
            } catch (InputWithSpecialCharactersException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
//        System.out.println("mostrando cursos");
//        view.mostrarCursos(Faculdade.gradeDeCursos);

    }    
    
    public void listarCursos(){
        GradeDeCursos grade = new GradeDeCursos();
        System.out.println("mostrando cursos");
        view.mostrarCursos(Faculdade.gradeDeCursos);
    }
    
    public Curso pedirCurso() throws InputWithSpecialCharactersException, InputMismatchException {
    String novoTipo = "";
    Boolean condicao = false;

    System.out.println("\nEntre com os dados do curso:");

    Scanner in = new Scanner(System.in);
    System.out.print("Nome: ");
    String novoNome = in.nextLine();
    System.out.print("Ano: ");
    Integer novoAno = in.nextInt();
    
        do {
            System.out.println("Tipo:");
            System.out.println("1 - Para Curso de Graduação");
            System.out.println("2 - Para Curso de Pós-Graduação");
            
            Integer tipoInt = in.nextInt();
            switch (tipoInt) {
                case 1:
                    novoTipo = "GRADUACAO";
                    condicao = true;
                    break;
                case 2:
                    novoTipo = "POSGRADUACAO";
                    condicao = true;
                    break;
                default:
                    System.out.println("Tipo Inválido.");
                    break;
            }
            
            String testarAno = novoAno.toString();
            CheckSpecialCharactersInFields error = new CheckSpecialCharactersInFields(novoNome, testarAno, novoTipo);
            error.VerifyName();
            error.VerifyYear();
            error.VerifyCourseType();
        } while (condicao == false);

    return new Curso(novoNome, novoAno, TipoDoCurso.valueOf(novoTipo));
    }
}
