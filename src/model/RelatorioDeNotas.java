package model;

import java.util.ArrayList;
import java.util.Collection;

public class RelatorioDeNotas {

    Collection<Rendimento> relatorio;

    public RelatorioDeNotas() {
        relatorio = new ArrayList<>();
    }

    public void add(Rendimento rendimento) {
        relatorio.add(rendimento);
    }

    @Override
    public String toString() {
        String res = "";
        res = relatorio.stream().map((r) -> r + "\n").reduce(res, String::concat);
        return "\nRelatorio de Notas: " + res;
    }
}
