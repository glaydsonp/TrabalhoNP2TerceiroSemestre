package model;

public class Faculdade {

    GradeDeCursos grade;
    public static CorpoDeAlunos corpoDeAlunos = new CorpoDeAlunos();
    public static ListaCurso gradeDeCursos = new ListaCurso();
    public static Historico historico = new Historico();

    public Faculdade() {
        grade = new GradeDeCursos();
    }

    @Override
    public String toString() {
        return "Faculdade \n" + grade + "]";
    }
}
