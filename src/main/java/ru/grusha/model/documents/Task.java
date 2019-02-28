package main.java.ru.grusha.model.documents;

import java.util.Date;

import main.java.ru.grusha.model.staff.Person;
import main.java.ru.grusha.utils.FormatUtil;

public class Task extends Document {
	
	private Date deliveryDate;//дата выдачи поручения
	private Date dueDate;//срок исполнения поручения   
	private Person executor;//ответственный исполнитель   
	private boolean controleAttribute;//признак контрольности        
	private Person controller;//контролер поручения
    
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public Person getExecutor() {
		return executor;
	}

	public void setExecutor(Person person) {
		this.executor = person;
	}

	public Person getController() {
		return controller;
	}

	public void setController(Person person) {
		this.controller = person;
	}

	public boolean getControleAttribute() {
		return controleAttribute;
	}

	public void setControleAttribute(boolean b) {
		this.controleAttribute = b;
	}

	@Override
	public String toString() {
		return "Поручение № " + getRegistrationNumber()
			+ ", ID:  " + getId() 
			+ ", Название документа: " + getName() 
			+ " Дата регистрации: " + FormatUtil.formatDate(getRegistrationDate())
			+ ", Автор: " + getAuthor().toString()
			+ ", Текст документа: "+ getText() 
			+ ", Дата выдачи: " + FormatUtil.formatDate(getDeliveryDate())
			+ ", Срок исполнения: " + FormatUtil.formatDate(getDueDate())
			+ ", Ответственный исполнитель: " + getExecutor().toString()				
			+ ", Исполнено: " + getControleAttribute()
			+ ", Контролер: " + getController().toString();
	}

	@Override
	public void setTableName() {}	
}
