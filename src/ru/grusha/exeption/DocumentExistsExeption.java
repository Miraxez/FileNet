package ru.grusha.exeption;

public class DocumentExistsExeption extends Exception{ 
	
	private static final long serialVersionUID = 1L;
    	
	//исключение: документ с таким номером уже существует
	public DocumentExistsExeption(String message){	     	        
	super(message);		    
	}	     	
}