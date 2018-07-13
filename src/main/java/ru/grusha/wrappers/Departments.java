package main.java.ru.grusha.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.ru.grusha.model.staff.Department;

/**
 * 
 * @author nesyedobnaya
 * класс для чтения/записи в xml объектов класса Department
 */
@XmlRootElement(name = "departments")
public class Departments{

	@XmlElement(name = "department")
	private List<Department> listOfDepartments =  new ArrayList<Department>();;

	public List<Department> getListOfDepartments() {
		return listOfDepartments;
	}
}