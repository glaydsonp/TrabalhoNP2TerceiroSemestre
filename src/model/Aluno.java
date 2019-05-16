package model;

public class Aluno implements Comparable<Aluno> {

    private String id, nomeDoAluno;

    public Aluno() {
    }

    public Aluno(String id, String nomeDoAluno) {
        this.id = id;
        this.nomeDoAluno = nomeDoAluno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getnomeDoAluno() {
        return nomeDoAluno;
    }

    public void setnomeDoAluno(String nomeDoAluno) {
        this.nomeDoAluno = nomeDoAluno;
    }

    @Override
    public boolean equals(Object otherObject) {
        //verificar se o outro objeto é nulo ou não é um Aluno
        if (otherObject == null || !(otherObject instanceof Aluno)) {
            return false;
        }

        //fazer uma variavel do tipo Aluno
        Aluno outroAluno = (Aluno) otherObject;

        //verifica se o campo id é igual 
        return this.getId().equals(outroAluno.id);
    }

    @Override
    public int compareTo(Aluno otherAluno) {
        if (this.getId().equals(otherAluno.getId()) == false) {
            return this.getId().compareTo(otherAluno.getId());
        }
        return this.getId().compareTo(otherAluno.getId());
    }

    @Override
    public String toString() {
        return "Aluno" + 
                "\nNome do Aluno: " + nomeDoAluno;
    }
}
