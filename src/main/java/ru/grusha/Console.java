package main.java.ru.grusha;

import java.util.TreeSet;

import main.java.ru.grusha.exeption.DocumentExistsExeption;
import main.java.ru.grusha.factory.Generator;
import main.java.ru.grusha.model.staff.Person;
import main.java.ru.grusha.storage.DocumentStorage;
import main.java.ru.grusha.utils.DocumentType;
import main.java.ru.grusha.utils.FactoryUtil;
import main.java.ru.grusha.utils.JsonFileWriter;
import main.java.ru.grusha.utils.ReportUtil;
/**
 * 
 * @author nesyedobnaya
 * класс для создания документов различных типов и вывода в консоль и в JSON файл отчета о созданных документах
 */
public class Console {

	public static void main(String[] args) {

		Generator generator = new Generator();
		FactoryUtil.loadStaff();
		
		for (DocumentType type : DocumentType.values()) { 
			try {
				generator.createDocument(type);
			}catch(DocumentExistsExeption ex){
				System.out.println(ex.getMessage());	
			}
		}		   
	
		TreeSet<Person> setOfAuthors = ReportUtil.authorsToSet(DocumentStorage.data);
		ReportUtil.printReport(DocumentStorage.data);
		for (Person authorFromSet: setOfAuthors) {
			new JsonFileWriter().reportToAFile(authorFromSet, ReportUtil.getDocumentsOfAuthor(DocumentStorage.data, authorFromSet));
		}
	}
}