package main.java.ru.grusha.webapp;

import java.sql.SQLException;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import main.java.ru.grusha.exeption.DocumentExistsExeption;
import main.java.ru.grusha.factory.Generator;
import main.java.ru.grusha.utils.DocumentType;
import main.java.ru.grusha.utils.FactoryUtil;

@ApplicationPath("/ecm")
public class MainApplication extends Application{

	public MainApplication() throws SQLException{
		FactoryUtil.loadStaff();
		FactoryUtil.saveStaffInDB();
		
		Generator generator = new Generator();
		for (DocumentType type : DocumentType.values()) { 
			try {
				generator.createDocument(type);
			}catch(DocumentExistsExeption ex){
				System.out.println(ex.getMessage());	
			}
		}	
	}
}
