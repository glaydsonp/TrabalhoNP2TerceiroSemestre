package model;

import model.entities.Prova;

public class Rendimento {

    Curso curso;
    Notas notas;
    Media media = new Media();

    public Rendimento() {
        this.notas = new Notas();
    }

    public Rendimento(Curso curso) {
        this.curso = curso;
        this.notas = new Notas();
    }

    public Curso getCurso() {
        return curso;
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Prova prova, Nota nota) {
        this.notas.add(prova, nota);
    }

    public String getStatusAluno() {
        if (media.getMedia() >= 5.0) {
            return "APROVADO";
        } else {
            return "REPROVADO";
        }
    }

    public Double getMedia() {
        Double media = 0.0;

        return media;
    }

    @Override
    public String toString() {
        return "\nRendimento " + notas + "]";
    }
}
