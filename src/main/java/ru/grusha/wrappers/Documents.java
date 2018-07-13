package main.java.ru.grusha.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.ru.grusha.model.documents.Document;
import main.java.ru.grusha.model.documents.Incoming;
import main.java.ru.grusha.model.documents.Outgoing;
import main.java.ru.grusha.model.documents.Task;

/**
 * 
 * @author nesyedobnaya
 * класс для чтения/записи в xml объектов класса Person
 */
@XmlRootElement(name = "documents")
public class Documents{

	@XmlElementWrapper(name = "documents_of_author")
    @XmlElements({
            @XmlElement(name = "task", type = Task.class),
            @XmlElement(name = "incoming", type = Incoming.class),
            @XmlElement(name = "outgoing", type = Outgoing.class)
    })
	private List<Document> listOfDocuments = new ArrayList<Document>();
	
	public List<Document> getDocuments() {
		return listOfDocuments;
	}
}