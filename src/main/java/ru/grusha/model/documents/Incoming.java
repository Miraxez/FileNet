package main.java.ru.grusha.model.documents;

import java.util.Date;

import main.java.ru.grusha.model.staff.Person;
import main.java.ru.grusha.utils.FormatUtil;

public class Incoming extends Document{
	 
	private Person sender;//отправитель 
	private Person addressee;//адресат    
	private int outgoingNumber;//исходящий номер 
	private Date outgoingRegistrationDate;//исходящая дата регистрации	
	
	public Person getSender() {
		return sender;
	}

	public void setSender(Person person) {
		this.sender = person;
	}

	public Person getAddressee() {
		return addressee;
	}

	public void setAddressee(Person person) {
		this.addressee = person;
	}

	public int getOutgoingNumber() {
		return outgoingNumber;
	}

	public void setOutgoingNumber(int outgoingNumber) {
		this.outgoingNumber = outgoingNumber;
	}

	public Date getOutgoingRegistrationDate() {
		return outgoingRegistrationDate;
	}

	public void setOutgoingRegistrationDate(Date outgoingRegistrationDate) {
		this.outgoingRegistrationDate = outgoingRegistrationDate;
	}
    
	@Override
	public String toString() {
		return "Входящий документ №" + getRegistrationNumber()
			+", ID: " + getId() 
			+", Название документа: " + getName() 			
			+", Дата регистрации: " + FormatUtil.formatDate(getRegistrationDate())			
			+", Автор: " + getAuthor().toString()			
			+", Текст документа: "+getText()			
			+", Отправитель: "+ getSender().toString()			
			+", Адресат: " + getAddressee().toString()		
			+", Исходящий номер: "+ getOutgoingNumber()			
			+", Исходящая дата регистрации: " + FormatUtil.formatDate(getOutgoingRegistrationDate());    
	}

	@Override
	public void setTableName() {}
}
