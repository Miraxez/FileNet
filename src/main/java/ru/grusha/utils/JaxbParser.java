package main.java.ru.grusha.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JaxbParser {	
 	
	/**
	 * 
	 * @param file xml файл, содержащий набор объектов 
	 * @param classOfObject класс объектов в xml файле
	 * @return набор объектов
	 */
 	public static Object unMarshal(File file, Class<?> classOfObject) {
 		
 		try {
 			JAXBContext jaxbContext = JAXBContext.newInstance(classOfObject);		
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 	     
			Object obj = jaxbUnmarshaller.unmarshal(file); 	    
			return obj; 
		} catch (JAXBException e) {			
			e.printStackTrace();
		}
		return null;
	} 
}