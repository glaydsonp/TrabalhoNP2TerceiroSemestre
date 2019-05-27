
package controller;

import java.io.IOException;
import java.util.InputMismatchException;
import model.Aluno;
import model.Historico;
import model.exceptions.InputWithSpecialCharactersException;
import view.HistoricoView;
import view.MenuView;

public class HistoricoControl {
    
    HistoricoView view = new HistoricoView();
    
    public void inicio() throws InputWithSpecialCharactersException, IOException {
        boolean continua = true;
        do {
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

    private void getHistorico() {
        Boolean aluno = false;
        while (aluno == false){
            String id = view.pedirHistorico();
            
            Historico historico = new Historico();
//            Aluno aluno01 = new Aluno(id);
            
            if(id != null){
                System.out.println(historico.getHistorico(id));
                aluno = true;
            } else {
                System.out.println("Id inválido. Insira novamente.");
            }
            
        }
    }
}
