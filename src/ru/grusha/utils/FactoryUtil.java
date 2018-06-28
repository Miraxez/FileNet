package ru.grusha.utils;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FactoryUtil {
	
		public static String[] people = {"Иванов И.И.", "Петров Г.О.", "Новикова Е.А.", 
				"Афанасьева И.Б.", "Шляпкин В.И."};
		
		public static String[] delivery = {"Курьер", "Факс", "Электронная почта"};
	
		//генерация n-значного числа
		public static int createRandomInteger(int digits){
			return (int)(Math.random()*Math.pow(10,digits));			
		}
	     
		//случайный выбор персоны
		public static String randomPerson(){
			return (people[new Random().nextInt(people.length)]);
		}
		
		//генерация случайной даты
		public static Date getRandomDate(int daysBack) {
			return new Date(System.currentTimeMillis() - ThreadLocalRandom.current().nextLong(1000*60*60*24*daysBack));
		}
}