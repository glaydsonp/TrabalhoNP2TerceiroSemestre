
package controller;

import model.Aluno;
import model.Historico;
import view.HistoricoView;
import view.MenuView;

public class HistoricoControl {
    
    HistoricoView view = new HistoricoView();
    
    public void inicio() {
        boolean continua = true;
        do {
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
                    System.out.println("opcao nao listada");

            }}while (continua == true);

        
        System.exit(0);
    }
    
    public int menu() {
        return view.escolherOpcao();
    }

    private void getHistorico() {
        Boolean aluno = false;
        while (aluno == false){
            String id = view.pedeAluno();
            
            Historico historico = new Historico();
            Aluno aluno01 = new Aluno(id);
            
            if(aluno01 != null){
                System.out.println(historico.getHistorico(aluno01));
                aluno = true;
            } else {
                System.out.println("Id inválido. Insira novamente.");
            }
            
        }
    }
}
