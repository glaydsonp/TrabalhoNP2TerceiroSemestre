
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.exceptions.InputNameWithSpecialCharactersException;


public class CheckSpecialCharactersInFields {
    
    private String name, id;
    private final String NameBannedSpecialCharacters = "[^a-zA-Z]+";
    private final String IDBannedSpecialCharacters = "[^0-9a-zA-Z]+";
    
    public CheckSpecialCharactersInFields(){
        
    }
    
    public CheckSpecialCharactersInFields(String aId, String aName) throws InputNameWithSpecialCharactersException{
        setId(aId);
        setName(aName);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) throws InputNameWithSpecialCharactersException {
        if (name == null || name.trim().equals("")) throw new InputNameWithSpecialCharactersException("Nome não pode ser vazio. Por favor insira um Nome válido!");
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InputNameWithSpecialCharactersException{
        if (id == null || id.trim().equals("")) throw new InputNameWithSpecialCharactersException("ID não pode ser vazio. Por favor insira um ID válido!");
        this.id = id;
    }
    
    public void VerifyId() throws InputNameWithSpecialCharactersException {
        Pattern pattern = Pattern.compile(IDBannedSpecialCharacters);
        Matcher matcher = pattern.matcher(this.getId());
        
        if(matcher.find()){
             throw new InputNameWithSpecialCharactersException("Insira um ID válido!");
        }
    }
    
    public void VerifyName() throws InputNameWithSpecialCharactersException {
        Pattern pattern = Pattern.compile(NameBannedSpecialCharacters);
        Matcher matcher = pattern.matcher(this.getName());
        
        if(matcher.find()){
             throw new InputNameWithSpecialCharactersException("Insira um Nome válido!");
        }
    }
    
}
