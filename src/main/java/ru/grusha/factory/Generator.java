package main.java.ru.grusha.factory;

import main.java.ru.grusha.exeption.DocumentExistsExeption;
import main.java.ru.grusha.model.documents.Document;
import main.java.ru.grusha.storage.DocumentStorage;
import main.java.ru.grusha.utils.DocumentType;
import main.java.ru.grusha.utils.FactoryUtil;

/**
 * генератор проверяет, существует ли уже документ с таким номером
 */
public class Generator {
	
	/**
	 * @param type - тип требующегося документа
	 * @return - созданный документ
	 * @throws DocumentExistsExeption - документ с таким номером уже существует
	 */
	public Document createDocument(DocumentType type) throws DocumentExistsExeption{ 
		String registrationNumber=(FactoryUtil.createRandomInteger(6))+"";
		DocumentStorage.check(DocumentStorage.data, registrationNumber);//проверка, существует ли уже документ с таким номером
		Document document = type.getFactory().getDocument();
		document.setRegistrationNumber(registrationNumber);
		DocumentStorage.data.add(document);
		return document;    	
	}
}
