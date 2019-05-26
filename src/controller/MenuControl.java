
package controller;

import model.Menu;

public class MenuControl {
    public int menuPrincipal(){
        
        //Instancia a classe model.Menu
        Menu chamaMenu = new Menu();
        //Printa para o usuário o menu principal
        System.out.println(chamaMenu);
        //Retorna a opção escolhida pelo usuário
        return chamaMenu.escolherOpcao();
    }
}
