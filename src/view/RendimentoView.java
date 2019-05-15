
package view;

import java.util.Scanner;
import model.Rendimento;

public class RendimentoView {
    
    public int escolherOpcao() {
        System.out.println("Digite 1 para inserir um novo rendimento.\nDigite 2 para fechar o programa: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    
    public Rendimento pedirRendimento() {
        //TODO
        Scanner in = new Scanner(System.in);
        System.out.println("Insira o ID do aluno cujo deseja adicionar um rendimento: ");
        String novoId = in.nextLine();
        
//        if(!alunos.containsKey(aluno.getId())){}
        
        return null;
    }
}
