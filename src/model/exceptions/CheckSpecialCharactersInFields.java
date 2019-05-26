
package model.exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CheckSpecialCharactersInFields {
    
    private String name, id, year, courseType;

    private final String NameCharactersAllowed = "[^a-zA-Z ]+";
    private final String IDCharactersAllowed = "[^-_0-9a-zA-Z]+";
    private final String YearCharactersAllowed = "[^0-9]";
    
    public CheckSpecialCharactersInFields(){
        
    }
    
    public CheckSpecialCharactersInFields(String aId) throws InputWithSpecialCharactersException{
        setId(aId);
    } 
    
    public CheckSpecialCharactersInFields(String aName, String aId) throws InputWithSpecialCharactersException{
        setName(aName);
        setId(aId);
    }   
    
    public CheckSpecialCharactersInFields(String aName, String aYear,String aCourseType) throws InputWithSpecialCharactersException{
        setName(aName);
        setYear(aYear);
        setCourseType(aCourseType);
    }
    
    private String getName() {
        return name;
    }

    private void setName(String name) throws InputWithSpecialCharactersException {
        if (name == null || name.trim().equals("")) throw new InputWithSpecialCharactersException("Nome não pode ser vazio. Por favor insira um Nome válido!");
        this.name = name;
    }

    private String getId() {
        return id;
    }

    private void setId(String id) throws InputWithSpecialCharactersException{
        if (id == null || id.trim().equals("")) throw new InputWithSpecialCharactersException("ID não pode ser vazio. Por favor insira um ID válido!");
        this.id = id;
    }
    
    private String getYear() {
        return year;
    }

    private void setYear(String year) throws InputWithSpecialCharactersException{
        if (year == null || year.trim().equals("")) throw new InputWithSpecialCharactersException("Ano não pode ser vazio. Por favor insira um Ano válido!");
        this.year = year;
    }
    
    public String getCourseType() {
        return courseType;
    }

    private void setCourseType(String courseType) throws InputWithSpecialCharactersException{
        if (courseType == null || courseType.trim().equals("")) throw new InputWithSpecialCharactersException("Tipo do curso não pode ser vazio. Por favor insira um Tipo válido!");
        this.courseType = courseType;
    }
    
    public void VerifyId() throws InputWithSpecialCharactersException {
        Pattern pattern = Pattern.compile(IDCharactersAllowed);
        Matcher matcher = pattern.matcher(this.getId());
        
        if(matcher.find()){
             throw new InputWithSpecialCharactersException("Insira um ID válido!");
        }
    }
    
    public void VerifyName() throws InputWithSpecialCharactersException {
        Pattern pattern = Pattern.compile(NameCharactersAllowed);
        Matcher matcher = pattern.matcher(this.getName());
        
        if(matcher.find()){
             throw new InputWithSpecialCharactersException("Insira um Nome válido!");
        }
    }
    
    public void VerifyYear() throws InputWithSpecialCharactersException{
        Pattern pattern = Pattern.compile(YearCharactersAllowed);
        Matcher matcher = pattern.matcher(this.getYear());
        
        if(matcher.find()){
             throw new InputWithSpecialCharactersException("Insira um Ano válido!");
        }
    }
    
    public void VerifyCourseType() throws InputWithSpecialCharactersException{
        Pattern pattern = Pattern.compile(NameCharactersAllowed);
        Matcher matcher = pattern.matcher(this.getCourseType());
        
        if(matcher.find()){
             throw new InputWithSpecialCharactersException("Insira um Tipo de Curso válido!");
        }
    }
    
}
