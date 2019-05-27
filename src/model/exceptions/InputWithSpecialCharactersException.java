
package model.exceptions;

import java.io.IOException;

public class InputWithSpecialCharactersException extends IOException{
    
    public InputWithSpecialCharactersException(){
        super();
    }
    
    public InputWithSpecialCharactersException(String message){
        super(message);
    }
}
