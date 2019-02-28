package main.java.ru.grusha.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.ru.grusha.model.staff.Organization;

/**
 * 
 * @author nesyedobnaya
 * класс для чтения/записи в xml объектов класса Organization
 */
@XmlRootElement(name = "organizations")
public class Organizations{

	@XmlElement(name = "organization")
	private List<Organization> listOfOrganizations =  new ArrayList<Organization>();;

	public List<Organization> getListOfOrganizations() {
		return listOfOrganizations;
	}
}