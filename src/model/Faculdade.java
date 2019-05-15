package model;

public class Faculdade {

    GradeDeCursos grade;
    public CorpoDeAlunos corpoDeAlunos = new CorpoDeAlunos();
    public GradeDeCursos gradeDeCursos = new GradeDeCursos();

    public Faculdade() {
        grade = new GradeDeCursos();
    }

    public void add(Curso curso) {
        grade.add(curso);
    }

    public void add(Rendimento rendimento) {
        grade.add(rendimento);
    }

    @Override
    public String toString() {
        return "Faculdade \n" + grade + "]";
    }
}
