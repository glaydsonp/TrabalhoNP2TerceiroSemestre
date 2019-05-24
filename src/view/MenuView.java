package view;

import controller.MenuControl;
import controller.AlunoControl;
import controller.CursoControl;
import controller.HistoricoControl;
import controller.RendimentoControl;

public class MenuView {

    MenuControl view = new MenuControl();
    CursoControl curso = new CursoControl();
    AlunoControl alunos = new AlunoControl();
    HistoricoControl historico = new HistoricoControl();
    RendimentoControl rendimento = new RendimentoControl();

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
        curso.listarCursos();
    }

    public void listarAlunos() { 
        alunos.listarAlunos();
    }

    public void listarHistorico() {
        historico.inicio();
    }

    public void listarRelatorio() {
        //TODO
    }

    public void incluirAluno() {
        alunos.inicio();
    }

    public void incluirCurso() {
        curso.inicio();
    }

    public void incluirRendimento() {
        rendimento.inicio();
    }
}
