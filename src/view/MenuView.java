package view;

import controller.MenuControl;
import controller.AlunoControl;
import controller.CursoControl;
import controller.HistoricoControl;
import controller.RendimentoControl;
import java.util.InputMismatchException;
import model.exceptions.InputWithSpecialCharactersException;

public class MenuView {

    MenuControl view = new MenuControl();
    CursoControl curso = new CursoControl();
    AlunoControl alunos = new AlunoControl();
    HistoricoControl historico = new HistoricoControl();
    RendimentoControl rendimento = new RendimentoControl();

    public int menu() {
        return view.menuPrincipal();
    }

    public void inicio() throws InputWithSpecialCharactersException {
        boolean continua = true;
        while (continua) {
            
            try {
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
                        System.exit(0);
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
        }
    }

    public void listarCursos() {
        curso.listarCursos();
    }

    public void listarAlunos() { 
        alunos.listarAlunos();
    }

    public void listarHistorico() throws InputWithSpecialCharactersException {
        historico.inicio();
    }

    public void listarRelatorio() {
        //TODO
    }

    public void incluirAluno() throws InputWithSpecialCharactersException {
        alunos.inicio();
    }

    public void incluirCurso() throws InputWithSpecialCharactersException {
        curso.inicio();
    }

    public void incluirRendimento() throws InputWithSpecialCharactersException {
        rendimento.inicio();
    }
}
