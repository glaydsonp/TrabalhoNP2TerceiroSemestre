package view;

import java.util.Scanner;
import model.ListaCurso;

public class CursoView {

    public int escolherOpcao() {
        System.out.print("--------- MENU ---------");
        System.out.println("\n1 - Para inserir um novo curso.\n2 - Para voltar ao menu principal. ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public void mostrarCursos(ListaCurso grade) {
        System.out.println(grade);
    }
}
