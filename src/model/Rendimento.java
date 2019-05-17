package model;

import java.util.Map;
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

    public void setNotas(Prova prova, Double nota) {
        this.notas.add(prova, nota);
    }

    @Override
    public String toString() {
        return "\nRendimento\n" + curso + "\n" + notas + "]";
    }

}
