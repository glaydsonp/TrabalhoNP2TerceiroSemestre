package view;

import java.util.Scanner;

public class HistoricoView {

    Scanner in = new Scanner(System.in);

    public int escolherOpcao() {
        System.out.println("Digite 1 para mostrar o historico de um aluno.\nDigite 2 para voltar ao menu principal: ");

        return in.nextInt();
    }

    public void mostrarHistorico() {
        //TODO   
    }

    public String pedirHistorico() {
        String id;
        System.out.println("Entre com o id do aluno que deseja exibir o histórico: ");
        in.nextLine();
        id = in.nextLine();

        return id;
    }

}
