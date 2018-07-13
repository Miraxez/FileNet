package main.java.ru.grusha.factory;

import main.java.ru.grusha.model.documents.Document;
import main.java.ru.grusha.model.documents.Incoming;
import main.java.ru.grusha.utils.FactoryUtil;

/**
 * 
 * @author nesyedobnaya
 * фабричный класс для создания входящего документа
 */
public class IncomingFactory extends Factory{	
	
	/**
	 * фабричный метод, возвращающий заполненный входящий документ
	 */
	@Override
	public Document getDocument() {
		Incoming incoming = new Incoming();		
		incoming.setId((FactoryUtil.createRandomInteger(4)));
		incoming.setAuthor(FactoryUtil.randomPerson());
		incoming.setName("Название документа");
		incoming.setText((FactoryUtil.createRandomInteger(10))+"");
		incoming.setRegistrationDate(FactoryUtil.getRandomDate(10000));
		incoming.setOutgoingRegistrationDate(FactoryUtil.getRandomDate(10000));    	
		incoming.setOutgoingNumber(FactoryUtil.createRandomInteger(4));    	
		incoming.setSender(FactoryUtil.randomPerson());    	
		incoming.setAddressee(FactoryUtil.randomPerson());    	
		return incoming;
	}    
}
