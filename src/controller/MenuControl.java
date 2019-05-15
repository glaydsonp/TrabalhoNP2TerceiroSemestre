
package controller;

import model.Menu;

public class MenuControl {
    public int menuPrincipal(){
        
        Menu chamaMenu = new Menu();
        System.out.println(chamaMenu);
        return chamaMenu.escolherOpcao();
        
    }
}
