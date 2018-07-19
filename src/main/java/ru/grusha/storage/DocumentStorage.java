package main.java.ru.grusha.storage;

import java.util.TreeSet;

import main.java.ru.grusha.exeption.DocumentExistsExeption;
import main.java.ru.grusha.model.documents.Document;

public class DocumentStorage {
 
	public static final TreeSet<Document> data = new TreeSet<Document>();
	
	/**
	 * проверка совпадения регистрационного номера с другими документами набора	
	 * @param tree набор документов
	 * @param registrationNumber регистрационный номер документа, который требуется добавить в набор
	 * @throws DocumentExistsExeption - документ с таким номером может уже существовать в наборе
	 */
	public static void check(TreeSet<Document> tree, String registrationNumber) throws DocumentExistsExeption{
		for (Document documentFromTree: tree) {        
			if (registrationNumber.equals(documentFromTree.getRegistrationNumber()))  {         	
				throw new DocumentExistsExeption("Документ с таким регистрационным номером уже существует");        
			}		
		}
	}
}
