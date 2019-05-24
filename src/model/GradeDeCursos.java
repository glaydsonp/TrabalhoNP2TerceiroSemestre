package model;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GradeDeCursos {

    Map<Curso, Rendimento> grade;

    public GradeDeCursos() {
        grade = new TreeMap<>();
    }

    public boolean add(Curso curso) {
        if (!grade.containsKey(curso)) {
            grade.put(curso, new Rendimento(curso));
            return true;
        } else {
            System.out.println("Curso já existente.");
            return false;
        }
    }

   public Set<Curso> getCursos() {
        return grade.keySet();
    }

    public Rendimento getRelatorio(Curso curso) {
        return grade.get(curso);
    }
//
//    public void add(Rendimento rendimento) {
//        Rendimento relatorio = grade.get(rendimento.getCurso());
//        relatorio.add(rendimento);
//    }

    @Override
    public String toString() {
        String listaCursos = ""; 
        for (Curso id : grade.keySet()){
            listaCursos += "Curso: " + id + "\n"; 
            listaCursos += "Rendimento: " + grade.get(id) + "\n";
        }
        return "GradeDeCursos \n" + grade;
    }
}
