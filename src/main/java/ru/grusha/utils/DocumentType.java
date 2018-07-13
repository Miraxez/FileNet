package main.java.ru.grusha.utils;

import main.java.ru.grusha.factory.Factory;
import main.java.ru.grusha.factory.IncomingFactory;
import main.java.ru.grusha.factory.OutgoingFactory;
import main.java.ru.grusha.factory.TaskFactory;

/**
 * 
 * @author nesyedobnaya
 * перечень типов документов
 */
public enum DocumentType {
	
	INCOMING(new IncomingFactory()), TASK(new TaskFactory()), OUTGOING(new OutgoingFactory());
	
	private final Factory factory;
	
	DocumentType(Factory factory) {
		this.factory = factory;
	}

	public Factory getFactory() {
		return factory;
	} 
}
