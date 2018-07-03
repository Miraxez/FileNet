package ru.grusha.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import ru.grusha.staff.Person;
import ru.grusha.utils.FormatUtil;

@XmlRootElement(name = "task")
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
			+ ", ID:  " + getID() 
			+ ", Название документа: " + getName() 
			+ " Дата регистрации: " + FormatUtil.formatDate(getRegistrationDate())
			+ ", Автор: " + getAuthor().getFullName() 
			+ ", Текст документа: "+ getText() 
			+ ", Дата выдачи: " + FormatUtil.formatDate(getDeliveryDate())
			+ ", Срок исполнения: " + getDueDate()
			+ ", Ответственный исполнитель: " + getExecutor().getFullName()				
			+ ", Исполнено: " + getControleAttribute()
			+ ", Контролер: " + getController().getFullName();
	}

	@Override
	public void setTableName() {}	
}
