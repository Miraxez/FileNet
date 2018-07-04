package ru.grusha.wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.grusha.staff.Organization;

/**
 * 
 * @author nesyedobnaya
 * класс для чтения/записи в xml объектов класса Organization
 */
@XmlRootElement(name = "organizations")
public class Organizations{

	@XmlElement(name = "organization")
	private List<Organization> listOfOrganizations = null;

	public List<Organization> getListOfOrganizations() {
		return listOfOrganizations;
	}

	public void setListOfOrganizations(List<Organization> listOfOrganizations) {
		this.listOfOrganizations = listOfOrganizations;
	}
}