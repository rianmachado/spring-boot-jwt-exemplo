package br.com.pitang.desafio.entities.utilits;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UtilDate {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilDate.class);

	private UtilDate() {
	}

	public static final String DDMMYYYYHHMMSS = "dd/MM/yyyy hh:mm:ss";

	public static Date getDateNow(String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String retorno = simpleDateFormat.format(new Date());
		try {
			return simpleDateFormat.parse(retorno);
		} catch (ParseException e) {
			LOGGER.error(e.getLocalizedMessage());
			return null;
		}
	}

	public static String getDateToString(String format, Long date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(new Date(date));
	}

}
