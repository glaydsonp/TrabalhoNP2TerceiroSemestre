package model;

import java.util.Map;
import java.util.Set;

public class Historico {

    Map<Aluno, GradeDeCursos> historico;
    GradeDeCursos grade = new GradeDeCursos();

    public Historico() {
    }

    public Historico(Map<Aluno, GradeDeCursos> historico) {
        this.historico = historico;
    }

    public void add(Aluno aluno) {
        historico.put(aluno, new GradeDeCursos());
    }

    public Set<Aluno> getAluno() {
        return historico.keySet();
    }

    public void add(Curso curso) {
        grade.add(curso);
    }

    public void add(Aluno aluno, Curso curso) {
        if (historico.containsKey(aluno)) {
            grade.add(curso);
        }
    }

    public Map<Aluno, GradeDeCursos> getHistorico(Aluno aluno) {
        if (historico.containsKey(aluno.getId())) {
            return (Map<Aluno, GradeDeCursos>) historico.get(aluno);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Historico " + historico;
    }
}
