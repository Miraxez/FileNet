package ru.grusha.factory;

import java.text.SimpleDateFormat;
import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.model.Document;
import ru.grusha.utils.FactoryUtil;
import ru.grusha.utils.DocType;
import ru.grusha.storage.DocumentStorage;

public class Factory {
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");//формат вывода даты	
		
	//генерация общих полей документа
	public Document fillCommonFields(Document document) {		       
		document.setID((FactoryUtil.createRandomInteger(4)));
		document.setAuthor(FactoryUtil.randomPerson());
		document.setName("Название документа");
		document.setText((FactoryUtil.createRandomInteger(10))+"");
		document.setRegistrationDate(FactoryUtil.getRandomDate(10000));
		return document;	 
	}
	 
	public Document createDocument(DocType type) throws DocumentExistsExeption{ 
		String registrationNumber=(FactoryUtil.createRandomInteger(6))+"";
		DocumentStorage.check(DocumentStorage.data, registrationNumber);//проверка, существует ли уже документ с таким номером
		Document document = createDocumentOfCertainType(type);
		document.setRegistrationNumber(registrationNumber);
		fillCommonFields(document);
		return document;    	
	}	      
       
	//создание экземпляров документа заданного типа    
	public static Document createDocumentOfCertainType(DocType type){            
		switch (type){                 
			case TASK: return TaskFactory.createTask();
			case INCOMING: return IncomingFactory.createIncoming();
			case OUTGOING: return OutgoingFactory.createOutgoing();                 
			default: return null;            
		}        
	}
}
