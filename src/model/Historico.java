package model;

import java.util.Map;
//import java.util.Set;
import java.util.TreeMap;

public class Historico {

    Map<Aluno, GradeDeCursos> historico;
//    private GradeDeCursos grade = new GradeDeCursos();

    public Historico() {
        historico = new TreeMap<>();
    }

    public Historico(Map<Aluno, GradeDeCursos> historico) {
        historico = new TreeMap<>();
    }

    public void add(Aluno aluno, Curso curso, Rendimento rend) {
        GradeDeCursos grade = new GradeDeCursos();
        Faculdade.historico.put(aluno, grade);
        grade.addGradeCurso(curso, rend);
    }

    public Boolean containsKey(Aluno aluno) {
        return historico.containsKey(aluno);
    }

    public GradeDeCursos get(Aluno aluno) {
        return historico.get(aluno);
    }

    private void put(Aluno aluno, GradeDeCursos gradeDeCursos) {
        historico.put(aluno, gradeDeCursos);
    }

    public GradeDeCursos getHistorico(String id) {
        Aluno aluno = new Aluno(id, Faculdade.corpoDeAlunos.getAluno(id));
        if (Faculdade.historico.containsKey(aluno)) {
            return Faculdade.historico.get(aluno);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Historico " + historico;
    }
}
