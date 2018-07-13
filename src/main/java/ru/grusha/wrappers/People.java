package main.java.ru.grusha.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.ru.grusha.model.staff.Person;

/**
 * 
 * @author nesyedobnaya
 * класс для чтения/записи в xml объектов класса Person
 */
@XmlRootElement(name = "people")
public class People{

	@XmlElement(name = "person")
	private List<Person> employees = new ArrayList<Person>();

	public List<Person> getEmployees() {
		return employees;
	}
}