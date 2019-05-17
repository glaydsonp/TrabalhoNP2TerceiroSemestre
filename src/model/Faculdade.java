package model;

public class Faculdade {

    GradeDeCursos grade;
    public static CorpoDeAlunos corpoDeAlunos = new CorpoDeAlunos();
    public static GradeDeCursos gradeDeCursos = new GradeDeCursos();

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
