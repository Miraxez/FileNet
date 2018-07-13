package main.java.ru.grusha.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import main.java.ru.grusha.model.documents.Document;
import main.java.ru.grusha.model.staff.Person;

public class JsonFileWriter {
	
	/**
	 * метод для записи в json файл отчета по созданным доументам автора
	 * @param author автор набора документов
	 * @param documentsOfAuthor набор документов
	 */
	public void reportToAFile(Person author, List<Document> documentsOfAuthor) {

		String pathToAFile=null;
		try {
			pathToAFile = (JsonFileWriter.class.getProtectionDomain().getCodeSource().getLocation().toURI()
					.getPath() + author.getLastName() + ".json");
		} catch (URISyntaxException e) {
			System.out.println("Путь не сгенерирован " + e);
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter(pathToAFile)) {
			String json = gson.toJson(documentsOfAuthor);
			writer.write(json);
		} catch (IOException e1) {
			System.out.println("Файл "+author.getLastName() +".json не записан" + e1);
		}
	}
	
	public String objectToJsonString(Object object){
		
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		String json = gson.toJson(object);
		return json;
	}
}