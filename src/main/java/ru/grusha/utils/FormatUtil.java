package main.java.ru.grusha.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author nesyedobnaya
 * класс для форматирования данных
 */
public class FormatUtil {
	
	/**
	 * формат для вывода даты
	 */
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");//формат вывода даты
	
	/**
	 * метод для преобразования даты в определенный формат
	 * @param dateToFormat необходимый формат даты
	 * @return форматированная дата
	 */
	public static String formatDate(Date dateToFormat){
		return dateFormat.format(dateToFormat);
	}

}
