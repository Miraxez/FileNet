package main.java.ru.grusha.model.staff;

public class Organization extends Staff{
	
	private String fullName;//полное название
	private String shortName;//краткое название
	private Person chief;//руководитель
	private String telephone;//контактные телефоны	

	public void setFullName(String name) {
		this.fullName = name;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setShortName(String name) {
		this.shortName = name;
	}
	
	public String getShortName() {
		return shortName;
	}

	public void setChief(Person person) {
		this.chief = person;
	}
	
	public Person getChief() {
		return chief;
	}

	public void setTelephone(String name) {
		this.telephone = name;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public String toString() {
		String str ="ID: "+ getId()+ " Полное название: "+getFullName()
				+", Краткое название: "+getShortName()
				+", Руководитель: "+getChief()
				+", Телефон: "+getTelephone()+" ";	        
		return str;		  	
	}
}