package main.java.ru.grusha.factory;

import main.java.ru.grusha.model.documents.Document;
import main.java.ru.grusha.model.documents.Task;
import main.java.ru.grusha.utils.FactoryUtil;

/**
 * 
 * @author nesyedobnaya
 * фабричный класс для создания поручения
 */
public class TaskFactory extends Factory{		

	/**
	 * фабричный метод, возвращающий заполненное поручение
	 */
	@Override
	public Document getDocument() {
		Task task = new Task();
		task.setId((FactoryUtil.createRandomInteger(4)));
		task.setAuthor(FactoryUtil.randomPerson());
		task.setName("Название документа");
		task.setText((FactoryUtil.createRandomInteger(10))+"");
		task.setRegistrationDate(FactoryUtil.getRandomDate(10000));
		task.setDeliveryDate(FactoryUtil.getRandomDate(10000));
		task.setDueDate(FactoryUtil.getRandomDate(10000));
		task.setExecutor(FactoryUtil.randomPerson());  
		task.setController(FactoryUtil.randomPerson());
		task.setControleAttribute(Math.random() < 0.5);    	
		return task;
	}	   
}
