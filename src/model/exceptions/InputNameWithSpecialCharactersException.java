
package model.exceptions;

import java.io.IOException;

public class InputNameWithSpecialCharactersException extends IOException{
    
    public InputNameWithSpecialCharactersException(){
        super();
    }
    
    public InputNameWithSpecialCharactersException(String message){
        super(message);
    }
}
