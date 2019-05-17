package view;

import controller.MenuControl;
import controller.AlunoControl;
import controller.CursoControl;
import controller.RendimentoControl;

public class MenuView {

    MenuControl view = new MenuControl();

    public int menu() {
        return view.menuPrincipal();
    }

    public void inicio() {
        boolean continua = true;
        while (continua) {

            int escolha = menu();
            switch (escolha) {
                case 1:
                    listarCursos();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    listarHistorico();
                    break;
                case 4:
                    listarRelatorio();
                    break;
                case 5:
                    incluirAluno();
                    break;
                case 6:
                    incluirCurso();
                    break;
                case 7:
                    incluirRendimento();
                    break;
                case 8:
                    continua = false;
                    break;
                default:
                    System.out.println("opcao nao listada");

            }

        }
        System.exit(0);
    }

    public void listarCursos() {
        CursoControl cursos = new CursoControl();
        cursos.listarCursos();
    }

    public void listarAlunos() {
        AlunoControl alunos = new AlunoControl();
        alunos.listarAlunos();
    }

    public void listarHistorico() {
        //TODO
    }

    public void listarRelatorio() {
        //TODO
    }

    public void incluirAluno() {
        AlunoControl aluno = new AlunoControl();
        aluno.inicio();
    }

    public void incluirCurso() {
        CursoControl curso = new CursoControl();
        curso.inicio();
    }

    public void incluirRendimento() {
        //TODO
    }
}
