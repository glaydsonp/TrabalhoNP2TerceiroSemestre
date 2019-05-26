package model;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GradeDeCursos {

    Map<Curso, Rendimento> grade = new TreeMap<>();
    
    public GradeDeCursos() {

    }
    
    public GradeDeCursos(Curso curso, Rendimento rendimento) {
        ListaCurso lista = new ListaCurso();
        lista.add(curso);
        this.grade.put(curso, rendimento);
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
    
    public void addGradeCurso(Curso curso, Rendimento rend) {
        if (!grade.containsKey(curso)) {
//            GradeDeCursos gradeCursos = new GradeDeCursos();
            grade.put(curso, rend);
//            return gradeCursos;
//            grade.put(curso, rend);
//            return grade;
        } else {
            System.out.println("Curso já existente.");
//            return null;
        }
    }

    public Set<Curso> getCursos() {
        return grade.keySet();
    }

    public Rendimento getRelatorio(Curso curso) {
        return grade.get(curso);
    }

    @Override
    public String toString() {
        String listaCursos = "";
        for (Curso id : grade.keySet()) {
            listaCursos += "Curso: " + id + "\n";
            listaCursos += "Rendimento: " + grade.get(id) + "\n";
        }
        return "\nGradeDeCursos \n" + grade;
    }
}
