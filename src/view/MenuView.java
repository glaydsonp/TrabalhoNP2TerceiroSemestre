package view;

import controller.MenuControl;
import controller.AlunoControl;
import controller.CsvControl;
import controller.CursoControl;
import controller.HistoricoControl;
import controller.RendimentoControl;
import java.io.IOException;
import java.util.Collection;
import java.util.InputMismatchException;
import model.exceptions.InputWithSpecialCharactersException;

import model.Faculdade;
import model.CorpoDeAlunos;
import model.Aluno;
import model.Curso;
import model.ListaCurso;
import model.Nota;
import model.Rendimento;
import model.entities.Prova;
import model.entities.TipoDoCurso;

public class MenuView {

    MenuControl view = new MenuControl();
    CursoControl curso = new CursoControl();
    AlunoControl alunos = new AlunoControl();
    HistoricoControl historico = new HistoricoControl();
    RendimentoControl rendimento = new RendimentoControl();
    CsvControl csvControl = new CsvControl();

    public int menu() {
        return view.menuPrincipal();
    }

    public void inicio() throws InputWithSpecialCharactersException, IOException {
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
                        salvaAlteracao();
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

    public void listarHistorico() throws InputWithSpecialCharactersException, IOException {
        historico.inicio();
    }

    public void listarRelatorio() {
        //TODO
    }

    public void incluirAluno() throws InputWithSpecialCharactersException, IOException {
        alunos.inicio();
    }

    public void incluirCurso() throws InputWithSpecialCharactersException, IOException {
        curso.inicio();
    }

    public void incluirRendimento() throws InputWithSpecialCharactersException, IOException {
        rendimento.inicio();
    }
    
    public void salvaAlteracao() throws IOException{
        csvControl.escreveAlunosCsv();
        csvControl.escreveCursosCsv();
//        csvControl.escreveCursoEspecificoCsv();
    }
    
//    public void inclusaoTeste(){
//        Faculdade test1 = new Faculdade();
//        ListaCurso test2 = new ListaCurso();
//        Faculdade.gradeDeCursos = test2;
//        Curso cursoTest = new Curso("curs3",1314,TipoDoCurso.GRADUACAO);
//        test2.add(cursoTest);
//        Aluno alunoTest = new Aluno("b1341","Jose");
//        Rendimento rendTest = new Rendimento(cursoTest);
//        rendTest.setNotas(Prova.NP1, new Nota(7.0));
//        rendTest.setNotas(Prova.NP2, new Nota(3.0));
//        rendTest.setNotas(Prova.SUB, new Nota(4.0));
//        rendTest.setNotas(Prova.EXAME, new Nota(9.0));
//        Faculdade.historico.add(alunoTest, cursoTest, rendTest);
//    }
    
}
