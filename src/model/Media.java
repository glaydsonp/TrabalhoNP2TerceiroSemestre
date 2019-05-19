package model;

import model.entities.Prova;

public class Media {

    private Nota media;
    Notas notas = new Notas();
    Double mediaFinal = 0.0;
    
    public Media() {
    }

    public Media(Nota media) {
        this.media = media;
    }
    
    public Double getNota(){
        Nota nota = new Nota();
        return nota.getNota();
    }
    
    public double getMedia(){
        return mediaFinal;
    }
    public double getMedia(Nota nota, Curso curso) {
        switch (String.valueOf(curso.getTipoDoCurso())) {
            case "GRADUACAO":
                mediaPos(nota);
                break;
            case "POS_GRADUACAO":
                mediaGrad(nota);
                break;
            default:
                System.out.println("Erro: nivel de curso invalido.");
                break;
        }
        return mediaFinal;
    }

    public int comparaNotas() {
        if (notas.getNota(Prova.SUB) > notas.getNota(Prova.NP1)) {
            return 1;
        } else if (notas.getNota(Prova.SUB) > notas.getNota(Prova.NP2)) {
            return 2;
        } else {
            return 0;
        }
    }

    public double mediaGrad(Nota nota) {
        Double mediaInicial;
        Double mediaFinalGrad;
        switch (comparaNotas()) {
            case 0:
                mediaInicial = (notas.getNota(Prova.NP1) + notas.getNota(Prova.NP2)) / 2;
                break;

            case 1:
                mediaInicial = (notas.getNota(Prova.SUB) + notas.getNota(Prova.NP2)) / 2;
                break;

            case 2:
                mediaInicial = (notas.getNota(Prova.SUB) + notas.getNota(Prova.NP1)) / 2;
                break;
            default:
                return 0;
        }

        if (mediaInicial >= 7) {
            mediaFinalGrad = mediaInicial;

        } else {
            mediaFinalGrad = (mediaInicial + notas.getNota(Prova.EXAME)) / 2;
        }
        return mediaFinalGrad;
    }

    public double mediaPos(Nota nota) {
        Double mediaInicial;
        Double mediaFinalPos;
        switch (comparaNotas()) {
            case 0:
                mediaInicial = (notas.getNota(Prova.NP1) + notas.getNota(Prova.NP2)) / 2;
                break;

            case 1:
                mediaInicial = (notas.getNota(Prova.SUB) + notas.getNota(Prova.NP2)) / 2;
                break;

            case 2:
                mediaInicial = (notas.getNota(Prova.SUB) + notas.getNota(Prova.NP1)) / 2;
                break;
            default:
                return 0;
        }

        if (mediaInicial >= 5) {
            mediaFinalPos = mediaInicial;

        } else {
            mediaFinalPos = (mediaInicial + notas.getNota(Prova.EXAME)) / 2;
            if (mediaFinalPos >= 5.0) {
                mediaFinalPos = 5.0;
            }
        }
        return mediaFinalPos;

    }

}
