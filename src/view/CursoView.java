package view;

import java.util.Scanner;
import model.Curso;
import model.GradeDeCursos;
import model.ListaCurso;
import model.entities.TipoDoCurso;

public class CursoView {

    public int escolherOpcao() {
        System.out.println("\n1 - Para inserir um novo curso.\n2 - Para voltar ao menu principal. ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public void mostrarCursos(ListaCurso grade) {
        System.out.println(grade);
    }

    public Curso pedirCurso() {
        String novoTipo = "";
        Boolean condicao = false;

        System.out.println("Entre com os dados do curso");

        Scanner in = new Scanner(System.in);
        System.out.println("Nome: ");
        String novoNome = in.nextLine();
        System.out.println("Ano: ");
        Integer novoAno = in.nextInt();
        do {
            System.out.println("Tipo (digite 1 para Curso de Graduação e 2 para Curso de Pós-Graduação): ");
            Integer tipoInt = in.nextInt();
            if (tipoInt == 1) {
                novoTipo = "GRADUACAO";
                condicao = true;
            } else if (tipoInt == 2) {
                novoTipo = "POSGRADUACAO";
                condicao = true;
            } else {
                System.out.println("Tipo Inválido.");
            }
        } while (condicao == false);

        return new Curso(novoNome, novoAno, TipoDoCurso.valueOf(novoTipo));
    }
}
