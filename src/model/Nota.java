package model;

import java.text.DecimalFormat;

public class Nota {

    private double nota;

    //Importando a classe DecimalFormat para termos a nota com dois dígitos significativos no método toString.
    private static DecimalFormat df = new DecimalFormat("0.00");

    public Nota() {
    }

    public Nota(double aNota) {
        // Validando a nota.
        // Para o caso da nota ser menor que zero, atribuir valor zero.
        // Para o caso da nota ser maior que dez (nota máxima), atribuir valor máximo dez.
        if (aNota >= 0.0 && aNota <= 10.0) {
            this.nota = aNota;
        } else if (aNota < 0.0) {
            this.nota = 0.0;
        } else if (aNota > 10.0) {
            this.nota = 10.0;
        }
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    

    @Override
    public String toString() {
        return df.format(nota);
    }

}
