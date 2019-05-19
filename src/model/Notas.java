package model;

import model.entities.Prova;
import java.util.Map;
import java.util.TreeMap;

public class Notas {

    Map<Prova, Double> notas;

    public Notas() {
    }

    public Notas(Nota nota, Curso curso) {
        notas = new TreeMap<>();

        for (Prova prova : Prova.values()) {
            notas.put(prova, 0.0);
        }
    }

    public Double getNota(Prova prova) {
        return notas.get(prova);
    }

    public Map<Prova, Double> getNotas() {
        return notas;
    }

    public void setNotas(Prova prova, Double nota) {
        this.notas.put(prova, nota);
    }
    
    public void add(Prova prova, Double nota) {
        this.notas.put(prova, nota);
    }
    
    @Override
    public String toString() {
        String res = "\n";
        for (Prova prova : notas.keySet()) {
            res += prova + ": " + notas.get(prova) + "\n";
        }

        return "Notas: " + res;
    }


}
