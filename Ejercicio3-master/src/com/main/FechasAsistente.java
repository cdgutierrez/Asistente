package com.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FechasAsistente {

	String dia = "", mes = "", tiempo = "";
	Calendar fechaPedida = new GregorianCalendar();
	Locale locale = Locale.getDefault();

	public String darDiaSemana() {
		Calendar cad = new GregorianCalendar();
		Locale locale = Locale.getDefault();
		String dia = cad.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);

		return ("Hoy es " + dia);

	}

	public String darFecha() {
		Calendar cad = new GregorianCalendar();
		Locale locale = Locale.getDefault();
		String dia = cad.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
		String mes = cad.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);

		return ("Hoy es " + dia + " " + cad.get(Calendar.DATE) + " de " + mes + " de " + cad.get(Calendar.YEAR));

	}

	public String darHora() {

		Calendar cal = new GregorianCalendar();
		int h, m;
		h = cal.get(Calendar.HOUR_OF_DAY);
		m = cal.get(Calendar.MINUTE);
		return ("Son las " + h + ":" + m + "hs");

	}

	public String darDiaFueSera(String strIn) throws ParseException {

		int x = extraerNro(strIn);

		int desplazamiento = 0;

		if (x > 0) {

			Pattern regex = Pattern.compile(".*que dia sera dentro de \\d* (dias|dia|mes|meses|año|años)\\?$");
			Matcher match = regex.matcher(strIn);

			if (match.matches()) {
				desplazamiento = 1;
				tiempo = "será ";
			}

			regex = Pattern.compile(".*que dia fue hace \\d* (dias|dia|mes|meses|año|años)\\?$");
			match = regex.matcher(strIn);

			if (match.matches()) {
				desplazamiento = -1;
				tiempo = "fue ";
			}

			if (desplazamiento != 0) {

				regex = Pattern.compile(".*\\d* (dias|dia)\\?$");
				match = regex.matcher(strIn);

				if (match.matches()) {
					// calcula los dias
					return fechaResultado(Calendar.DATE, x, desplazamiento);
				}

				regex = Pattern.compile(".*\\d* (meses|mes)\\?$");
				match = regex.matcher(strIn);

				if (match.matches()) {
					// calcula los meses
					return fechaResultado(Calendar.MONTH, x, desplazamiento);

				}

				regex = Pattern.compile(".*\\d* (años|año)\\?$");
				match = regex.matcher(strIn);

				if (match.matches()) {
					// calcula los años
					return fechaResultado(Calendar.YEAR, x, desplazamiento);
				}

			}

		}

		Pattern regex = Pattern.compile(".*ayer\\?$");
		Matcher match = regex.matcher(strIn);

		if (match.matches()) {
			// calcula ayer
			return ("Ayer fue " + fechaResultado(Calendar.DATE, 1, -1));

		}
		return ("disculpa, no entiendo tu consulta");
	}

	private int extraerNro(String cadena) {

		StringBuilder str = new StringBuilder();
		char c;
		for (int i = 0; i < cadena.length(); i++) {
			c = cadena.charAt(i);
			if (Character.isDigit(c))
				str.append(c);
		}
		if (str.length() > 0)
			return Integer.parseInt(str.toString());
		else
			return -1;
	}
	public String tiempoDiasDesdeFecha(String strIn) throws ParseException {
		
		SimpleDateFormat formatIn = new SimpleDateFormat("'cuantos dias pasaron desde el' dd 'de' MMMMM 'de' yyyy");
		SimpleDateFormat formatOut = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");

		//String strIn = "cuántos días pasaron desde el 1 de abril de 2018";

		Date fechaStrIn = formatIn.parse(strIn);
		
		Calendar desde = new GregorianCalendar();
		Calendar hasta = new GregorianCalendar();
		
		desde.setTime(fechaStrIn);
		hasta.setTime(new Date());
		
		long dias = (hasta.getTimeInMillis() - desde.getTimeInMillis())/ (24 * 60 * 60 * 1000);
		
		return ("Entre el "+ formatOut.format(fechaStrIn) + " y hoy pasaron "  + dias + " dias");
		
	}
	
	 public String tiempoMesesDesdeFecha(String strIn) throws ParseException {
		
		SimpleDateFormat formatIn = new SimpleDateFormat("'cuantos meses pasaron desde el' dd 'de' MMMMM 'de' yyyy");
		SimpleDateFormat formatOut = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");

		//String strIn = "cuántos días pasaron desde el 1 de abril de 2018";

		Date fechaStrIn = formatIn.parse(strIn);
		
		Calendar desde = new GregorianCalendar();
		Calendar hasta = new GregorianCalendar();
		
		desde.setTime(fechaStrIn);
		hasta.setTime(new Date());
		
		int anios = hasta.get(Calendar.YEAR) - desde.get(Calendar.YEAR);
		int meses = hasta.get(Calendar.MONTH) - desde.get(Calendar.MONTH);
		int totalMeses = anios*12 + meses;
		 
		return ("Entre el "+ formatOut.format(fechaStrIn) + " y hoy pasaron "  + totalMeses + " meses");
		
	}
		 public String tiempoAniosDesdeFecha(String strIn) throws ParseException {
			
			SimpleDateFormat formatIn = new SimpleDateFormat("'cuantos años pasaron desde el' dd 'de' MMMMM 'de' yyyy");
			SimpleDateFormat formatOut = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");

			//String strIn = "cuántos días pasaron desde el 1 de abril de 2018";

			Date fechaStrIn = formatIn.parse(strIn);
			
			Calendar desde = new GregorianCalendar();
			Calendar hasta = new GregorianCalendar();
			
			desde.setTime(fechaStrIn);
			hasta.setTime(new Date());
			int anios;
			if(hasta.get(Calendar.MONTH)>=desde.get(Calendar.MONTH)) {
					anios = hasta.get(Calendar.YEAR) - desde.get(Calendar.YEAR);	
			}else {
				anios = hasta.get(Calendar.YEAR) - desde.get(Calendar.YEAR)- 1;
			}
			return ("Entre el "+ formatOut.format(fechaStrIn) + " y hoy pasaron "  + anios + " años");
			
		}
		 public String tiempoAniosHastaFecha(String strIn) throws ParseException {
				
				SimpleDateFormat formatIn = new SimpleDateFormat("'cuantos años pasaran hasta el' dd 'de' MMMMM 'de' yyyy");
				SimpleDateFormat formatOut = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");

				//String strIn = "cuántos días pasaron desde el 1 de abril de 2018";

				Date fechaStrIn = formatIn.parse(strIn);
				
				Calendar desde = new GregorianCalendar();
				Calendar hasta = new GregorianCalendar();
				
				desde.setTime(new Date());
				hasta.setTime(fechaStrIn);
				int anios;
				if(hasta.get(Calendar.MONTH)>=desde.get(Calendar.MONTH)) {
						anios = hasta.get(Calendar.YEAR) - desde.get(Calendar.YEAR);	
				}else {
					anios = hasta.get(Calendar.YEAR) - desde.get(Calendar.YEAR)- 1;
				}
			 
				return ("Entre hoy y el "+ formatOut.format(fechaStrIn) +" pasaron " + anios + " años");
				
			}
		 

		 
		 public String tiempoDiasHastaFecha(String strIn) throws ParseException {
				
				SimpleDateFormat formatIn = new SimpleDateFormat("'cuantos dias pasaran hasta el' dd 'de' MMMMM 'de' yyyy");
				SimpleDateFormat formatOut = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");

				//String strIn = "cuántos días pasaron desde el 1 de abril de 2018";

				Date fechaStrIn = formatIn.parse(strIn);
				
				Calendar desde = new GregorianCalendar();
				Calendar hasta = new GregorianCalendar();
				
				desde.setTime(fechaStrIn);
				hasta.setTime(new Date());
				
				long dias = (hasta.getTimeInMillis() - desde.getTimeInMillis())/ (24 * 60 * 60 * 1000);
				
				return ("Entre hoy y el "+ formatOut.format(fechaStrIn) + " pasaran "  + (dias<0?dias*-1:dias) + " dias");
				
			}
			
			 public String tiempoMesesHastaFecha(String strIn) throws ParseException {
				
				SimpleDateFormat formatIn = new SimpleDateFormat("'cuantos meses pasaran hasta el' dd 'de' MMMMM 'de' yyyy");
				SimpleDateFormat formatOut = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");

				//String strIn = "cuántos días pasaron desde el 1 de abril de 2018";

				Date fechaStrIn = formatIn.parse(strIn);
				
				Calendar desde = new GregorianCalendar();
				Calendar hasta = new GregorianCalendar();
				
				desde.setTime(new Date());
				hasta.setTime(fechaStrIn);
				int anios;
				if(hasta.get(Calendar.MONTH)>=desde.get(Calendar.MONTH)) {
					anios = hasta.get(Calendar.YEAR) - desde.get(Calendar.YEAR);	
				}else {
					anios = hasta.get(Calendar.YEAR) - desde.get(Calendar.YEAR)- 1;
				}
				int meses;
				if(hasta.get(Calendar.DAY_OF_MONTH)>=desde.get(Calendar.DAY_OF_MONTH)) {
					meses = hasta.get(Calendar.MONTH) - desde.get(Calendar.MONTH);	
				}else {
					meses = hasta.get(Calendar.MONTH) - desde.get(Calendar.MONTH)- 1;
				}
			   	int totalMeses = anios*12 + meses;
				 
				return ("Entre hoy y el "+ formatOut.format(fechaStrIn) + " pasaran "  + totalMeses + " meses");
				
			}
	private String fechaResultado(int calendarType, int x, int desplazamiento) {
		fechaPedida.add(calendarType, x * desplazamiento);

		dia = fechaPedida.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
		mes = fechaPedida.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
		return (tiempo + dia + " " + fechaPedida.get(Calendar.DATE) + " de " + mes + " de "
				+ fechaPedida.get(Calendar.YEAR));

	}

}
