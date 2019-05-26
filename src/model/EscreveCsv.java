/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Daniel
 */
    public class EscreveCsv {
        public EscreveCsv(){
        }
       
    //delimitadores para o arquivo csv
    private static final String pontovirgula = ";";
    private static final String pulalinha = "\n";

    public static void  EscreveArquivoCsv() {

//        //listaAlunos para teste
//        Aluno aluno1 = new Aluno("555", "Ahmed");
//        Aluno aluno2 = new Aluno("666", "Sara");
//        Aluno aluno3 = new Aluno("zz2", "Seila O. Quemaiz");
//        Aluno aluno4 = new Aluno("f32", "an1111111111111a paula");
//
//        //cria objetos listaAlunos para teste
//        ArrayList<Aluno> listaAlunos = new ArrayList<>();
//        listaAlunos.add(aluno1);
//        listaAlunos.add(aluno2);
//        listaAlunos.add(aluno3);
//        listaAlunos.add(aluno4);
//        
//aqui sera feito o equivalente ao que foi feito em teste, 
//porem criado, puxando o corpodealunos
//        for(corpoDeAlunos){
//        listaAlunos.add(aluno);
//        }
        //incializacao do filewriter
        FileWriter fileWriter = null;

        try {
            //aqui vai o nome do arquivo dentro de ( )
            fileWriter = new FileWriter("alunosa1111111111111.csv");
            
            //escreve uma lista de aluno para o csv
//            for (Aluno aaluno : listaAlunos) {
//                fileWriter.append(aaluno.getId());
//                fileWriter.append(pontovirgula);
//                fileWriter.append(aaluno.getNomeDoAluno());
//                fileWriter.append(pulalinha);
//            }
			

            System.out.println("Deu bom!"); 

        } catch (IOException e) {
            System.out.println("Erro ao escrever.");
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro durante flush/close.");
            }

        }
    }
    }