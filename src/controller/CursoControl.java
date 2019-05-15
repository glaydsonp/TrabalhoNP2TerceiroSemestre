package controller;

import entities.TipoDoCurso;
import java.util.Scanner;
import model.Curso;
import model.GradeDeCursos;

public class CursoControl {
    

    public int escolherOpcao() {
        System.out.println("Digite 1 para inserir um novo curso.\nDigite 2 para fechar o programa: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public void mostrarCursos(GradeDeCursos grade) {
        System.out.println(grade);
    }

    public Curso pedirCurso() {

        System.out.println("Entre com os dados do curso");

        Scanner in = new Scanner(System.in);
        System.out.println("Nome: ");
        String novoNome = in.nextLine();
        System.out.println("Ano: ");
        Integer novoAno = in.nextInt();
        System.out.println("Tipo: ");
        String novoTipo = in.nextLine();

        return new Curso(novoNome, novoAno, TipoDoCurso.valueOf(novoTipo));
    }

    
}
