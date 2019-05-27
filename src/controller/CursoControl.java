package controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Curso;
import model.Faculdade;
import model.GradeDeCursos;
import model.entities.TipoDoCurso;
import model.exceptions.CheckSpecialCharactersInFields;
import model.exceptions.InputWithSpecialCharactersException;
import view.CursoView;
import view.MenuView;

public class CursoControl {

    Faculdade faculdade = new Faculdade();
    CursoView view = new CursoView();

    public void inicio() throws InputWithSpecialCharactersException, IOException {
        boolean continua = true;
        do {
            try {
                int escolha = menu();
                switch (escolha) {
                case 1:
                    //Inicia o método de inserir curso
                    inserirCurso();
                    break;
                case 2:
                    //Retorna ao menu principal
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

    /*
     Esse método irá inserir um curso novo no sistema
     */
    public void inserirCurso() {
        Boolean cursoInserido = false;

        while (cursoInserido == false) {

            try {
                Curso curso = this.pedirCurso();

                /*
                 Essa variável retorna verdadeira se o curso for inserido
                 Retorna falso e quebra o while se o curso não tiver sido inserido
                 O curso não será inserido quando já houver um curso
                 Com os mesmos atributos já cadastrado
                 */
                cursoInserido = Faculdade.gradeDeCursos.add(curso);
                if (cursoInserido == false) {
                    System.out.println("Curso nao foi inserido");
                }
            } //Pega a exceção caso o usuário digite caracteres não permitidos no campo nome ou ano
            catch (InputWithSpecialCharactersException ex) {
                System.out.println("Erro: " + ex.getMessage());
            } catch (InputMismatchException e){
                System.out.println("Erro: Por favor insira inteiros para o ano do curso.");
            }
        }
    }

    //Método que lista todos os cursos cadastrados
    public void listarCursos() {
        GradeDeCursos grade = new GradeDeCursos();
        System.out.println("---- Exibindo cursos ---");
        view.mostrarCursos(Faculdade.gradeDeCursos);
    }

    //Método que pede os dados do aluno a ser inserido
    public Curso pedirCurso() throws InputWithSpecialCharactersException, InputMismatchException {
        String novoTipo = "";
        Boolean condicao = false;

        System.out.println("\nEntre com os dados do curso:");

        Scanner in = new Scanner(System.in);
        System.out.print("Nome: ");
        String novoNome = in.nextLine();
        System.out.print("Ano: ");
        Integer novoAno = in.nextInt();

        /*
        Laço para o usuário entrar com o tipo do curso 
        Só será quebrando quando o usuário digitar um tipo do curso válido
        */
        do {
            System.out.println("Tipo:");
            System.out.println("1 - Para Curso de Graduação");
            System.out.println("2 - Para Curso de Pós-Graduação");

            Integer tipoInt = in.nextInt();
            switch (tipoInt) {
                case 1:
                    novoTipo = "GRADUACAO";
                    condicao = true;
                    break;
                case 2:
                    novoTipo = "POSGRADUACAO";
                    condicao = true;
                    break;
                default:
                    System.out.println("Tipo Inválido.");
                    break;
            }

            String testarAno = novoAno.toString();

            /*
             Classe CheckSpecialCharactersInFields vai checar todos os caracteres inseridos pelo usuário
             Irá verificar e, quando aplicado, lançará uma exceção que dirá se existe caracter não permitido
             Checa todos os valores que o usuário inserir
             */
            CheckSpecialCharactersInFields error = new CheckSpecialCharactersInFields(novoNome, testarAno, novoTipo);
            error.VerifyName();
            error.VerifyYear();
            error.VerifyCourseType();
        } while (condicao == false);

        /*
        Caso não haja nenhum conflito, o método retornará um aluno construído 
        para ser adicionado no método inserirAluno() lá em cima
        */
        return new Curso(novoNome, novoAno, TipoDoCurso.valueOf(novoTipo));
    }
}
