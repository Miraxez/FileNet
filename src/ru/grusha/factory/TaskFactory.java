package ru.grusha.factory;

import java.util.Random;

import ru.grusha.model.Document;
import ru.grusha.model.Task;
import ru.grusha.storage.NameStorage;

public class TaskFactory extends Factory{
	
	public static String[] controleAttribute = {"Выдано", "В процессе", "Исполнено"};
	
	public static Document createTask() {
		Task task = new Task();
		makeDeliveryDate(task);
		makeDueDate(task);
		makeExecutor(task);
		makeController(task);
		makeControleAttribute(task);    	
		return task;   			
	}
    
	//генерация даты выдачи/
	public static void makeDeliveryDate(Task task){
		task.setDeliveryDate(RandomDate());
	}
    
	//генерация срока исполнения задания/
	public static void makeDueDate(Task task){
		task.setDueDate(task.getDeliveryDate());//срок исполнения не может быть раньше даты выдачи    	
	}
    
	//случайный выбор исполнителя получения
	public static void makeExecutor(Task task){    	
		task.setExecutor(NameStorage.executor[new Random().nextInt(5)]);;
	}
    
	//случайный выбор контролера
	public static void makeController(Task task){    	
		task.setController(NameStorage.controller[new Random().nextInt(5)]);
	}
    
	//генерация признака контрольности
	public static void makeControleAttribute(Task task){
		task.setControleAttribute(controleAttribute[new Random().nextInt(3)]);
	}      
}
