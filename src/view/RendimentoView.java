package view;

import java.util.Scanner;
import model.Curso;
import static model.Faculdade.gradeDeCursos;
import model.Rendimento;
import model.entities.TipoDoCurso;

public class RendimentoView {

    public int escolherOpcao() {
        System.out.println("Digite 1 para inserir um novo rendimento.\nDigite 2 para retornar ao menu principal: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public Rendimento pedirRendimento() {
        //TODO
        Scanner in = new Scanner(System.in);
        System.out.println("Insira o ID do aluno cujo deseja adicionar um rendimento: ");
        String novoId = in.nextLine();

        //se o id do aluno entrado não for nulo 
        if (novoId != null) {
            //Se o id do aluno entrado existir
            //if () {
            
                String novoNome = "";
                String novoTipo = "";
                Boolean condicao = false;
                
                System.out.println("Entre com os dados do curso");
                System.out.println("Nome: ");
                novoNome = in.nextLine();
                System.out.println("Ano: ");
                Integer novoAno = in.nextInt();
                do {
                    System.out.println("Tipo (digite 1 para Curso de Graduação e 2 para Curso de Pós-Graduação): ");
                    Integer tipoInt = in.nextInt();
                    if (tipoInt == 1) {
                        novoTipo = "GRADUACAO";
                        condicao = true;
                    } else if (tipoInt == 2) {
                        novoTipo = "POS_GRADUACAO";
                        condicao = true;
                    } else {
                        System.out.println("Tipo Inválido.");
                    }
                } while (condicao == false);
                
                Curso outroCurso = new Curso(novoNome, novoAno, TipoDoCurso.valueOf(novoTipo));
                
                Rendimento rend = new Rendimento();
                //Temos que comprar o curso que foi digitado pelo usuário para saber se já é um curso existente
//                if(outroCurso.equals(rend.getCurso())){}
//                      
//                } else {
//                      System.out.println("O Curso digitado não existe.");
//                }

            //}
        } else {
            System.out.println("O ID digitado não é de um aluno.");
        }

        return null;
    }
}
