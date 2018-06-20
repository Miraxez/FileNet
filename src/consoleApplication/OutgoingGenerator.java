package consoleApplication;

import java.util.Random;

public class OutgoingGenerator extends Generator{
	
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
		outgoing.addressee=NameStorage.addressee[new Random().nextInt(5)];
	}
    
	//случайный выбор способа доставки
	public static void makeDelivery(Outgoing outgoing){    	
		outgoing.delivery=delivery[new Random().nextInt(3)];
	}   
}
