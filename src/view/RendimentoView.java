package view;

import java.util.Scanner;

public class RendimentoView {

    public int escolherOpcao() {
        System.out.println("Digite 1 para inserir um novo rendimento.\nDigite 2 para retornar ao menu principal: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    //Método tipo Double[] (vetor de variáveis tipo double) que retornará as notas digitadas no console
    public Double[] pedirNotas() {
        Scanner in = new Scanner(System.in);

        //Cria um vetor que irá receber as notas digitadas via console
        Double notas[] = null;
        
        System.out.println("Insira a nota da NP1: ");
        notas[0] = in.nextDouble();
        System.out.println("Insira a nota da NP2: ");
        notas[1] = in.nextDouble();
        System.out.println("Insira a nota da Prova SUB: ");
        notas[2] = in.nextDouble();
        System.out.println("Insira a nota da Prova Exame: ");
        notas[3] = in.nextDouble();

        return notas;
    }
}
