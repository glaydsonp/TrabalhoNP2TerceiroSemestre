package controller;

import model.Aluno;
import model.Historico;
import model.exceptions.InputWithSpecialCharactersException;
import view.HistoricoView;
import view.MenuView;

public class HistoricoControl {

    HistoricoView view = new HistoricoView();

    public void inicio() throws InputWithSpecialCharactersException {
        boolean continua = true;
        do {
            int escolha = menu();
            switch (escolha) {
                case 1:
                    //Inicia o método de puxar o histórico
                    getHistorico();
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
