package ru.grusha.factory;

import java.util.Random;

import ru.grusha.model.Document;
import ru.grusha.model.Incoming;
import ru.grusha.storage.NameStorage;

public class IncomingGenerator extends Factory{
	
	//генерация входящего документа
	public static Document createIncoming() {
		Incoming incoming = new Incoming();		
		makeOutgoingRegistrationDate(incoming);    	
		makeOutgoingNumber(incoming);    	
		makeSender(incoming);    	
		makeAddressee(incoming);    	
		return incoming;    
	}
    
	//генерация исходящей даты регистрации
	public static void makeOutgoingRegistrationDate(Incoming incoming){
		incoming.setOutgoingRegistrationDate(RandomDate());
	}
    
	//генерация исходящего регистрационного номера
	public static void makeOutgoingNumber(Incoming incoming){
		incoming.setOutgoingNumber((int)(Math.random()*10000));
	}
    
	//случайный выбор отправителя
	public static void makeSender(Incoming incoming){
		incoming.setSender(NameStorage.sender[new Random().nextInt(5)]);
	}
    
	//случайный выбор адресата
	public static void makeAddressee(Incoming incoming){
		incoming.setAddressee(NameStorage.addressee[new Random().nextInt(5)]);
	}  
    
}
