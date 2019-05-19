package model;

import model.entities.TipoDoCurso;

public class Curso implements Comparable<Curso> {

    private String nomeDoCurso;
    private Integer anoDoCurso;
    private TipoDoCurso tipoDoCurso;
    

    public Curso() {
    }

    public Curso(String nomeDoCurso, Integer anoDoCurso, TipoDoCurso tipoDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
        this.anoDoCurso = anoDoCurso;
        this.tipoDoCurso = tipoDoCurso;
        
    }

    public String getNomeDoCurso() {
        return nomeDoCurso;
    }

    public void setNomeDoCurso(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }

    public Integer getAnoDoCurso() {
        return anoDoCurso;
    }

    public void setAnoDoCurso(int anoDoCurso) {
        this.anoDoCurso = anoDoCurso;
    }

    public TipoDoCurso getTipoDoCurso() {
        return tipoDoCurso;
    }

    public void setTipoDoCurso(TipoDoCurso tipoDoCurso) {
        this.tipoDoCurso = tipoDoCurso;
    }

    @Override
    public boolean equals(Object otherObject) {
        //verificar se o outro objeto é nulo ou não é um Curso
        if (this == otherObject) {
            return true;
        }
        //fazer uma variavel do tipo Curso

        if (otherObject == null || !(otherObject instanceof Curso)) {
            return false;
        }

        Curso outroCurso = (Curso) otherObject;

        return this.getNomeDoCurso().equals(outroCurso.getNomeDoCurso())
                && this.tipoDoCurso == outroCurso.tipoDoCurso
                && this.getAnoDoCurso().equals(outroCurso.getAnoDoCurso());
    }

    @Override
    public int compareTo(Curso outroCurso) {
        if (!this.getNomeDoCurso().equals(outroCurso.getNomeDoCurso())) {
            return this.getNomeDoCurso().compareTo(outroCurso.getNomeDoCurso());
        }
        return this.tipoDoCurso.compareTo(outroCurso.tipoDoCurso);
    }

    @Override
    public String toString() {
        return "Curso\n" + 
                "Nome do curso: " + nomeDoCurso + 
                "\nAno do curso: " + anoDoCurso + 
                "\nTipo: " + tipoDoCurso;
    }
}
