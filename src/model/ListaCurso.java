
package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class ListaCurso implements Iterable<Curso> {
    
    Collection<Curso> listaCurso;

    public ListaCurso() {
        listaCurso = new TreeSet<>();
    }

    public Boolean add(Curso curso){
        if (!listaCurso.equals(curso)) {
            listaCurso.add(curso);
            return true;
        } else {
            System.out.println("Curso já existente.");
            return false;
        }
    }
    
    @Override
    public Iterator<Curso> iterator() {
        return listaCurso.iterator();
    }
    
    @Override
    public String toString(){
        return this.listaCurso.toString();
    }
}
