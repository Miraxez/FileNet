package ru.grusha.model;

import java.util.Date;

public abstract class Document implements Comparable<Document>{
	 
	private String ID;//идентификатор документа
	private String name;//название документа	  
	private String text;//текст документа	     
	private int registrationNumber;//регистрационный номер	     
	private Date registrationDate;//дата регистрации	    
	private String author;//автор документа	
				
	public String getID() {
		return ID;
	}

	public void setID(String ID) { 
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
		
	@Override 	    
	public int compareTo(Document entry){ 
	    
	//сортировка по дате регистрации
	Date dateDoc = this.registrationDate;
	int result = dateDoc.compareTo(entry.registrationDate); 
	if(result != 0) return result; 

	//сортировка по регистрационному номеру
	int regDoc=this.registrationNumber;
	result = regDoc - entry.registrationNumber; 
	if(result!=0) 
	return (int) result/Math.abs(result); 
	return 0;  	 
	} 
	    
	@Override 		
	public String toString() { 			
		return "Документ №"+ getRegistrationNumber()
		    +", ID: " + getID() 
		    + ", Название документа: " + getName() 
		    + ", Дата регистрации: " + getRegistrationDate()
		    + ", Автор: " + getAuthor() 
		    + ", Текст документа: "+ getText();
	}
}
	    
