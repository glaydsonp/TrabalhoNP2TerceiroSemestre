package model;

import model.entities.Prova;
import java.util.Map;
import java.util.TreeMap;

public class Notas {
    Nota media;
    Map<Prova, Double> notas;

    public Notas() {
    }
    
    public Notas(Nota nota, Curso curso) {
        notas = new TreeMap<>();

        for (Prova prova : Prova.values()) {
            notas.put(prova, 0.0);
        }
        setMedia(nota,curso);
    }
    private void setMedia(Nota nota, Curso curso){
        notas.put(Prova.MEDIA_FINAL,getMedia(nota,curso));
    }

    public void setNota(Prova prova, double valor) {
        notas.put(prova, valor);
    }
    public double getMedia(Nota nota, Curso curso){
        Double mediaFinal = 0.0;

//        String nivel;
//        nivel = String.valueOf(curso.getTipoDoCurso());
        if (String.valueOf(curso.getTipoDoCurso()).equals("GRADUACAO")){
        mediaPos(nota);
        }
        else if (String.valueOf(curso.getTipoDoCurso()).equals("POS_GRADUACAO")){
        mediaGrad(nota);
        }
        else{
            System.out.println("Erro: nivel de curso invalido.");
        }
        
        return mediaFinal;
    }
    
    public double mediaGrad(Nota nota){
        Double mediaInicial;
        Double mediaFinalGrad;
        switch (comparaNotas()) {
            case 0:
        	mediaInicial = (getNota(Prova.NP1) + getNota(Prova.NP2))/2;
        	break;
        	
            case 1:
        	mediaInicial = (getNota(Prova.SUB) + getNota(Prova.NP2))/2;
        	break;
        	
            case 2:
        	mediaInicial = (getNota(Prova.SUB) + getNota(Prova.NP1))/2;
        	break;
            default:
        	return 0;
        }
        
        if (mediaInicial >= 7) { 
            mediaFinalGrad = mediaInicial;
            		
        }            	
        else {
            mediaFinalGrad = (mediaInicial + getNota(Prova.EXAME)) /2;
        }
        return mediaFinalGrad;
    }
    public double mediaPos(Nota nota){
        Double mediaInicial;
        Double mediaFinalPos;
            switch (comparaNotas()) {
        	case 0:
        		mediaInicial = (getNota(Prova.NP1) + getNota(Prova.NP2))/2;
        		break;
        	
        	case 1:
        		mediaInicial = (getNota(Prova.SUB) + getNota(Prova.NP2))/2;
        		break;
        	
        	case 2:
        		mediaInicial = (getNota(Prova.SUB) + getNota(Prova.NP1))/2;
        		break;
        	default:
        		return 0;
        }
        
            if (mediaInicial >= 5) { 
            	mediaFinalPos = mediaInicial;
            		
            }            	
            else {
            	mediaFinalPos = (mediaInicial + getNota(Prova.EXAME)) /2;
                if(mediaFinalPos >=5.0) {
                    mediaFinalPos = 5.0;
                }
            }    
        return mediaFinalPos;
        
    }
    public double getNota(Prova prova) {
        return notas.get(prova);
    }
    
    public int comparaNotas() {
    	if (getNota(Prova.SUB) > getNota(Prova.NP1))  {
    		return 1;
    	}
    	else if(getNota(Prova.SUB) > getNota(Prova.NP2)) {
    		return 2;
    	}
    	else {
    		return 0;
    	}
    }

    @Override
    public String toString() {
        String res = "\n";
        for (Prova prova : notas.keySet()) {
            res += prova + ": " + notas.get(prova) + "\n";
        }

        return "Notas:" + res;
    }

}
