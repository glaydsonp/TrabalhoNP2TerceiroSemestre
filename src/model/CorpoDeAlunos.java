package model;

import java.util.Map;
import java.util.TreeMap;

public class CorpoDeAlunos {

    Map<String, String> alunos;

    public CorpoDeAlunos() {
        this.alunos = new TreeMap<>();
    }

    public boolean add(Aluno aluno) {
        if (!alunos.containsKey(aluno.getId())) {
            alunos.put(aluno.getId(), aluno.getNomeDoAluno());
            return true;
        } else {
            System.out.println("Aluno já existente.");
            return false;
        }
    }

    public String getAluno(String id) {
        return alunos.get(id);
    }

    @Override
    public String toString() {
        String listaAlunos = "";
        for (String id : alunos.keySet()) {
            listaAlunos += "\nID: " + id;
            listaAlunos += "\nNome: " + alunos.get(id);
        }
        return "Corpo de Alunos\n" + listaAlunos;
    }
}
