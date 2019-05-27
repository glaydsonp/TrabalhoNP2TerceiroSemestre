
package model.exceptions;

import java.io.IOException;

public class DomainExceptions extends IOException{
    
    public DomainExceptions(){
        super();
    }
    
    public DomainExceptions(String message){
        super(message);
    }
}
