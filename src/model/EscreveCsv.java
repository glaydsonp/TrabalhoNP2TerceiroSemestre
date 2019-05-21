/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
    public class EscreveCsv {
	
	
    Map<String, String> corpoDeAlunos = new HashMap<>();
    List<List<String>> escreveAlunos;
	
	//    //cria lista de arquivos na pasta e faz a leitura deles
//    public void criaLista() throws IOException {
//        File folder = new File(caminhoCsv());
//        File[] listOfFiles = folder.listFiles();
//        for (File listOfFile : listOfFiles) {
//            if (listOfFile.isFile()) {
//                if (listOfFile.getAbsolutePath().endsWith(".csv")) {
//                    System.out.println("File " + listOfFile.getName());
//                    if (listOfFile.getName().equals("listaAlunos.csv")) {
//                        System.out.println("csv dos listaAlunos: " + listOfFile.getName());
////                        lerCsvAluno();
//                    } else if (listOfFile.getName().equals("cursos.csv")) {
//                        System.out.println("csv dos cursos: " + listOfFile.getName());
////                        lerCsvCurso();
//                    } else {
//                        System.out.println("csv especifico de cada curso: " + listOfFile.getName());
////                        lerCsvEspecifico(listOfFile);
//                    }
//                }
//            } else {
//                System.out.println("");
//            }
//        }
//    }
public String caminhoCsv() {
        String caminho = System.getProperty("user.dir");
        caminho += File.separator;
        return caminho;
    }

    //delimitadores para o arquivo csv
    private static final String pontoVirgula = ";";
    private static final String pulaLinha = "\n";

    public static void  EscreveArquivoCsv(String nomeArquivo) {

        //listaAlunos para teste
        Aluno aluno1 = new Aluno("555", "Ahmed");
        Aluno aluno2 = new Aluno("666", "Sara");
        Aluno aluno3 = new Aluno("zz2", "Seila O. Quemaiz");
        Aluno aluno4 = new Aluno("f32", "ana paula");

        //cria objetos listaAlunos para teste
        List listaAlunos = new ArrayList();
        listaAlunos.add(aluno1);
        listaAlunos.add(aluno2);
        listaAlunos.add(aluno3);
        listaAlunos.add(aluno4);

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(nomeArquivo);
			
            //escreve uma lista de aluno para o csv
            for (Aluno aluno : listaAlunos) {
                fileWriter.append(aluno.getId());
                fileWriter.append(pontoVirgula);
                fileWriter.append(aluno.getnomeDoAluno());
                fileWriter.append(pulaLinha);
            }
			

            System.out.println("Deu bom!");

        } catch (Exception e) {
            System.out.println("Erro ao escrever.");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro durante flush/close.");
                e.printStackTrace();
            }

        }
    }
    }