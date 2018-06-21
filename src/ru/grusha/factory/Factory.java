package ru.grusha.factory;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.model.Document;
import ru.grusha.model.Incoming;
import ru.grusha.model.Outgoing;
import ru.grusha.model.Task;
import ru.grusha.storage.DocumentStorage;
import ru.grusha.storage.NameStorage;

public class Factory {
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd");//формат вывода даты
	
	//генерация общих полей документа
	public Document makeCommonFields(Document document) {		       
		generateID(document);
		author(document);
		name(document);
		text(document);
		type(document);
		registrationDate(document);
		return document;	 
	}
	 
	public Document createDocument(String kind) throws DocumentExistsExeption{ 
		int registrationNumber=(int)(Math.random()*1000000);//генерация регистрационного номера
		DocumentStorage.check(DocumentStorage.data, registrationNumber);//проверка, существует ли уже документ с таким номером
		Document document = createDocumentOfCertainKind(kind);
		document.setRegistrationNumber(registrationNumber);
		makeCommonFields(document);
		DocumentStorage.data.add(document);
		return document;    	
	}
	
	//генерация идентификатора
	public void generateID(Document document){
		document.setID(String.format("%.0f%n",(Math.random()*10000)));    
	}
     
	//случайный выбор автора документа
	public void author(Document document){
		document.setAuthor(NameStorage.author[new Random().nextInt(5)]);
	}
        
	//метод для генерации случайных строк
	public static String generateString(int byteLength) {           	
		SecureRandom secureRandom = new SecureRandom();
		byte[] token = new byte[byteLength];
		secureRandom.nextBytes(token);
		return new BigInteger(1, token).toString(32);
	}
           
	//генерация текста документа
	public void text(Document document){
		document.setText(generateString(16));            
	}
    
	//генерация регистрационного номера        
	public void name(Document document){
		document.setName("Название документа");
	}
    
	//определение типа документа    
	public static String type(Document document){
		String str = null;
		Task t = new Task();
		Incoming i = new Incoming();
		Outgoing o = new Outgoing();
		if ((document.getClass())==t.getClass()) str = "Поручение";
		if ((document.getClass())==i.getClass()) str = "Входящий";
		if ((document.getClass())==o.getClass()) str = "Исходящий";
		return str;		
	}        
    
	//генерация случайной даты
	public static Date RandomDate() {            
		int year = ThreadLocalRandom.current().nextInt(100, 118);
		int month = ThreadLocalRandom.current().nextInt(0, 11);		
		int date = ThreadLocalRandom.current().nextInt(1, 30);
		return new Date(year, month, date);       
	}
    
	//метод, возвращающий случайное число в заданном диапазоне
	public static int randBetween(int start, int end) {            
		return start + (int)Math.round(Math.random() * (end - start));        
	}
    
	//генерация даты регистрации
	public void registrationDate(Document document){
		document.setRegistrationDate(RandomDate());
	}
    
	//создание экземпляров документа заданного типа    
	public static Document createDocumentOfCertainKind(String kind){            
		switch (kind){                 
		case "Task": return TaskFactory.createTask();
		case "Incoming": return IncomingGenerator.createIncoming();
		case "Outgoing": return OutgoingGenerator.createOutgoing();                 
		default: return null;            
		}        
	}
}
