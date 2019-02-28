package main.java.ru.grusha.utils;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
 	
 	public static String marshalToString(Object object)  {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(object.getClass());		
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller(); 
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter stringWriter = new StringWriter();
			jaxbMarshaller.marshal(object, stringWriter);  
			String result = stringWriter.toString();
			return result;
			} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
 	}
}