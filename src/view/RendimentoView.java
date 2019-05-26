package view;

import static java.lang.System.in;
import java.util.Scanner;
import model.Nota;
import model.Rendimento;
import model.entities.Prova;

public class RendimentoView {

    public int escolherOpcao() {
        System.out.println("Digite 1 para inserir um novo rendimento.\nDigite 2 para retornar ao menu principal: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public Double[] pedirNotas() {
        Scanner in = new Scanner(System.in);
        
        Double notas[] = null;
        
        System.out.println("Insira a nota da NP1: ");
        notas[0] = in.nextDouble();
        System.out.println("Insira a nota da NP2: ");
        notas[1]= in.nextDouble();
        System.out.println("Insira a nota da Prova SUB: ");
        notas[2] = in.nextDouble();
        System.out.println("Insira a nota da Prova Exame: ");
        notas[3] = in.nextDouble();
        
        return notas;
    }
}
