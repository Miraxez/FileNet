package main.java.ru.grusha.webapp;

import java.util.TreeSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.ru.grusha.model.documents.Document;
import main.java.ru.grusha.model.staff.Person;
import main.java.ru.grusha.storage.DocumentStorage;
import main.java.ru.grusha.utils.FactoryUtil;
import main.java.ru.grusha.utils.JaxbParser;
import main.java.ru.grusha.utils.JsonFileWriter;
import main.java.ru.grusha.utils.ReportUtil;
import main.java.ru.grusha.wrappers.Documents;

@Path("/employees")
public class EmployeesController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String employeesToJson(){
		JsonFileWriter jsonWriter = new JsonFileWriter();
		String peopleJson = jsonWriter.objectToJsonString(FactoryUtil.loadedPeople);
		return peopleJson;
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String documentsOfAuthorsToXML(@PathParam("id") int id){
		
		Documents docs = new Documents();
		
		String ReportXML=null;
		TreeSet<Person> setOfAuthors = ReportUtil.authorsToSet(DocumentStorage.data);
		for (Person authorFromSet: setOfAuthors) {
			if (authorFromSet.getId()==(id)){
				for (Document documentFromStorage: DocumentStorage.data) {
					if (authorFromSet.equals(documentFromStorage.getAuthor())) {
						docs.getDocuments().add(documentFromStorage);
					}
				}
				ReportXML=JaxbParser.marshalToString(docs);
			}
		}
		return ReportXML;
	}
}
