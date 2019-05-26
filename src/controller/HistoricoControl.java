package controller;

import java.util.InputMismatchException;
import model.Historico;
import model.exceptions.InputWithSpecialCharactersException;
import view.HistoricoView;
import view.MenuView;

public class HistoricoControl {

    HistoricoView view = new HistoricoView();

    public void inicio() throws InputWithSpecialCharactersException {

        try {
            int escolha = menu();
            switch (escolha) {
                case 1:
                    getHistorico();
                    break;
                case 2:
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
    }

    public int menu() {
        return view.escolherOpcao();
    }

    //Método que pega o histórico cadastrado no sistema
    private void getHistorico() {
        Boolean aluno = false;
        while (aluno == false) {
            String id = view.pedirHistorico();

            Historico historico = new Historico();
            /*
             Caso o ID que o usuário tenha entrado seja inválido não retorna o historico
             */
            if (id != null) {
                System.out.println(historico.getHistorico(id));
                aluno = true;
            } else {
                System.out.println("Id inválido. Insira novamente.");
            }

        }
    }
}
