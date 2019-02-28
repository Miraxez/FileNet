package main.java.ru.grusha.exeption;

@SuppressWarnings("serial")
public class DocumentExistsExeption extends Exception{     	
	
	/**
	 * 
	 * @param message - сообщение об ошибке
	 */
	public DocumentExistsExeption(String message){	   
		
		super(message);		    
	}	     	
}