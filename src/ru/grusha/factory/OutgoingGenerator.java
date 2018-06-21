package ru.grusha.factory;

import java.util.Random;

import ru.grusha.model.Document;
import ru.grusha.model.Outgoing;
import ru.grusha.storage.NameStorage;

public class OutgoingGenerator extends Factory{
	
	public static String[] delivery = {"Курьер", "Факс", "Электронная почта"};

	//генерация исходящего документа
	public static Document createOutgoing() {
		Outgoing outgoing = new Outgoing();
		makeDelivery(outgoing);
		makeOutgoingAddressee(outgoing);    	
		return outgoing;   			
	}
    
	//случайный выбор адресата
	public static void makeOutgoingAddressee(Outgoing outgoing){
		outgoing.setAddressee(NameStorage.addressee[new Random().nextInt(5)]);
	}
    
	//случайный выбор способа доставки
	public static void makeDelivery(Outgoing outgoing){    	
		outgoing.setDelivery(delivery[new Random().nextInt(3)]);
	}   
}
