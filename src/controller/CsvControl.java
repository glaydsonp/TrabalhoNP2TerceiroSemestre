package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import model.Aluno;
import model.CorpoDeAlunos;
import model.ListaCurso;
import model.CsvAluno;
import model.CsvCurso;
import model.Curso;
import model.Faculdade;
import static model.Faculdade.corpoDeAlunos;
import model.GradeDeCursos;
import model.Nota;
import model.Rendimento;
import model.entities.Prova;

public class CsvControl {

    CsvAluno csvAluno = new CsvAluno();
    CsvCurso csvCurso = new CsvCurso();

    //Esse método vai chamar o CSV de Alunos para serem cadastrados no programa
    public void lerCsvAluno() throws IOException {
        csvAluno.lerCsvAluno();
    }

    //Esse método vai chamar o CSV de Cursos para serem cadastrados no programa
    public void lerCsvCurso() throws IOException {
        csvCurso.lerCsvCurso();
    }

    private static final String pontovirgula = ";";
    private static final String pulalinha = "\n";

    public void escreveAlunosCsv() throws IOException {

        //incializacao do filewriter
        FileWriter fileWriter = null;

        try {
            //aqui vai o nome do arquivo dentro de ( )
            fileWriter = new FileWriter("alunos.csv");

            Iterator<Map.Entry<String, String>> itr = corpoDeAlunos.alunos.entrySet().iterator();

            while (itr.hasNext()) {
                Map.Entry<String, String> entry = itr.next();
                fileWriter.append(entry.getKey());
                fileWriter.append(pontovirgula);
                fileWriter.append(entry.getValue());
                fileWriter.append(pulalinha);
            }
            System.out.println("Alteracoes em alunos.csv realizadas com sucesso!!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar alunos.csv.");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro durante flush/close.");
            }

        }
    }

    public void escreveCursosCsv() throws IOException {

        //incializacao do filewriter
        FileWriter fileWriter = null;

        try {
            //aqui vai o nome do arquivo dentro de ( )
            fileWriter = new FileWriter("cursos.csv");

            for (Curso aCurso : Faculdade.gradeDeCursos.listaCurso) {
                fileWriter.append(aCurso.getNomeDoCurso());
                fileWriter.append(pontovirgula);
                fileWriter.append(aCurso.getTipoDoCurso().toString());
                fileWriter.append(pontovirgula);
                fileWriter.append(aCurso.getAnoDoCurso().toString());
                fileWriter.append(pulalinha);
            }
            System.out.println("Alteracoes em cursos.csv realizadas com sucesso!!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar cursos.csv.");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro durante flush/close.");
            }

        }
    }

    //TODO
    public void escreveCursoEspecificoCsv() throws IOException {
        String nomeCurso = null;
        //incializacao do filewriter
        FileWriter fileWriter = null;

        try {
            //itera todos os cursos cadastrados na faculdade
            for (Curso aCurso : Faculdade.gradeDeCursos.listaCurso) {
                GradeDeCursos grade1;
                String idAluno;
                Double notaP1;
                Double notaP2;
                Double notaSub;
                Double notaExame;
                List todasLinhas = new ArrayList();
                String linha = null;

                //cria o nome do arquivo usando atributos do Curso
                nomeCurso = aCurso.getNomeDoCurso() + "_"
                        + aCurso.getTipoDoCurso().toString() + "_"
                        + aCurso.getAnoDoCurso().toString() + ".csv";

                //itera sobre todos alunos que possuam o curso acima mencionado
                for (Map.Entry<Aluno, GradeDeCursos> entryH : Faculdade.historico.historico.entrySet()) {

                    Aluno aluno1 = entryH.getKey();
                    grade1 = entryH.getValue();

                    //itera sobre todos os cursos da grade que sejam iguais ao curso que nomeia o arquivo
                    for (Map.Entry<Curso, Rendimento> entryG : grade1.grade.entrySet()) {

                        Curso cursoG = entryG.getKey();
                        Rendimento rendG = entryG.getValue();

                        //se esse aluno tiver um curso igual ao do nome, idAluno tera o valor do id desse aluno
                        //e o rendimento desse aluno ficara disposto no arquivo logo apos o id
                        if ((cursoG.getNomeDoCurso().equals(aCurso.getNomeDoCurso()))
                                && (cursoG.getAnoDoCurso() == aCurso.getAnoDoCurso())
                                && (cursoG.getTipoDoCurso().equals(aCurso.getTipoDoCurso()))
                                ) {
                            idAluno = aluno1.getId();
                            notaP1 = rendG.getNotas().getNota(Prova.NP1);
                            notaP2 = rendG.getNotas().getNota(Prova.NP2);
                            notaSub = rendG.getNotas().getNota(Prova.SUB);
                            notaExame = rendG.getNotas().getNota(Prova.EXAME);

                            //a linha a ser impressa no csv tera esses valores
                            linha = idAluno + ";" + notaP1 + ";" + notaP2 + ";" + notaSub + ";" + notaExame;
                            System.out.println(linha);
                            todasLinhas.add(linha);                            
                        }
                        
                        //caso o aluno nao tenha esse curso em sua grade, a linha permanecera em branco
                    }
                }

                //aqui vai o nome do arquivo dentro de ( )
                fileWriter = new FileWriter(nomeCurso);
                for (Object line : todasLinhas) {
                    fileWriter.append(line.toString());
                    fileWriter.append(pulalinha);
                }

                System.out.println("Alteracoes em " + nomeCurso + " realizadas com sucesso!!");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo .csv");
        } 
           
//                fileWriter.flush();
                fileWriter.close();
                }
    }


