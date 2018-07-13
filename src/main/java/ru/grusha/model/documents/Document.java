package main.java.ru.grusha.model.documents;

import java.util.Date;

import main.java.ru.grusha.interfaces.Storable;
import main.java.ru.grusha.model.staff.Person;
import main.java.ru.grusha.utils.FormatUtil;

public abstract class Document implements Comparable<Document>, Storable{
	 
	private int id;//идентификатор документа
	private String name;//название документа	  
	private String text;//текст документа	     
	private String registrationNumber;//регистрационный номер	     
	private Date registrationDate;//дата регистрации	    
	private Person author;//автор документа	
	
				
	public int getId() {
		return id;
	}

	public void setId(int id) { 
		this.id = id;
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

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person person) {
		this.author = person;
	}
	
	@Override 	    
	public int compareTo(Document entry){ 
	    
		//сравнение по дате регистрации
		Date dateDoc = this.registrationDate;
		int result = dateDoc.compareTo(entry.registrationDate); 
		if(result != 0) return result; 

		//сравнение по регистрационному номеру
		return this.registrationNumber.compareTo(entry.getRegistrationNumber()); 
	} 
	
	/**
	 * @return возвращает строку, которая записывается в отчет
	 */
	public String print(){
		return "Документ"
				+" от "+FormatUtil.formatDate(getRegistrationDate()) 
				+ " №" + getRegistrationNumber();
	}
}
	    
