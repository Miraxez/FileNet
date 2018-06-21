package ru.grusha;

import java.util.TreeSet;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.factory.Factory;
import ru.grusha.model.Document;
import ru.grusha.storage.DocumentStorage;

public class Console {

	public static void main(String[] args) throws DocumentExistsExeption {

		Factory doc = new Factory();	
		String setOfDocuments[] = {"Incoming", "Task", "Outgoing", "Incoming", "Task", "Outgoing"}; //список создаваемых документов          
		for (int i=0;i<setOfDocuments.length;i++) {        	       	
        	try{
        		Document o=doc.createDocument(setOfDocuments[i]);
        		System.out.println(o.toString());//вывод полей документа в консоль для проверки
        	}catch(DocumentExistsExeption ex){
        		System.out.println(ex.getMessage());	
        	}        	      	    	
		}
        
		//создание набора авторов
		TreeSet<String> setOfAuthors = new TreeSet<String>();                 
		for (Document e: DocumentStorage.data) {        	
			setOfAuthors.add(e.getAuthor());        	
		}
                
		//вывод отчета (перечень авторов и список созданных ими документов, отсортированных по дате регистрации и регистрационному номеру)
		for (String a: setOfAuthors) {
			System.out.println(" - "+a);        	        	
			for (Document e: DocumentStorage.data) {
				if (a==e.getAuthor()) {
					System.out.println("\t- "+Factory.type(e)
						+" от "+Factory.dateFormat.format(e.getRegistrationDate()) 
						+ " №" + e.getRegistrationNumber());
        			}        		
        		}
		}        
	}
}
	

