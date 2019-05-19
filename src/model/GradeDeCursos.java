package model;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GradeDeCursos {

    Map<Curso, RelatorioDeNotas> relatorios;

    public GradeDeCursos() {
        relatorios = new TreeMap<>();
    }

    public boolean add(Curso curso) {
        if (!relatorios.containsKey(curso)) {
            relatorios.put(curso, new RelatorioDeNotas());
            return true;
        } else {
            System.out.println("Curso já existente.");
            return false;
        }

    }

    public Set<Curso> getCursos() {
        return relatorios.keySet();
    }

    public RelatorioDeNotas getRelatorio(Curso curso) {
        return relatorios.get(curso);
    }

    public void add(Rendimento rendimento) {
        RelatorioDeNotas relatorio = relatorios.get(rendimento.getCurso());
        relatorio.add(rendimento);
    }

    @Override
    public String toString() {
        String listaCursos = ""; 
        for (Curso id : relatorios.keySet()){
            listaCursos += "Curso: " + id + "\n"; 
            listaCursos += "Relatório: " + relatorios.get(id) + "\n";
        }
        return "GradeDeCursos \n" + relatorios;
    }
}
