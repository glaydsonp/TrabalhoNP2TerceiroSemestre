package model;

import java.util.Map;
import java.util.TreeMap;

public class CorpoDeAlunos {

    Map<String, Aluno> alunos;

    public CorpoDeAlunos() {
        this.alunos = new TreeMap<>();
    }

    public boolean add(Aluno aluno) {
        if (!alunos.containsKey(aluno.getId())) {
            alunos.put(aluno.getId(), aluno);
            return true;
        } else {
            System.out.println("Aluno já existente.");
            return false;
        }
    }

    public Aluno getAluno(String id) {
        return alunos.get(id);
    }

    @Override
    public String toString() {
        return "Corpo de Alunos" + alunos;
    }
}
