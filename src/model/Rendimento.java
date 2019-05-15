package model;

import model.entities.Prova;

public class Rendimento {

    Curso curso;

    Notas notas;

    public Rendimento(Curso curso) {
        this.curso = curso;
        this.notas = new Notas();
    }

    public Rendimento() {
    }

    public Curso getCurso() {
        return curso;
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNota(Prova prova, double nota) {
        this.notas.setNota(prova, nota);
    }

    @Override
    public String toString() {
        return "\nRendimento\n" + curso + "\n" + notas + "]";
    }

}
