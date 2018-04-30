package com.main;


import java.text.ParseException;


public class Asistente {
	
	
	private String nombre;
	
	
	
	public Asistente(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	
	
	/* escucha recibe un string, ese string pasado al metodo nroMensaje que devuelve el id de los mensajes
	 * por cada case ejecutara el metodo del mensaje/comando recibido
	 * 
	 * 
	 */

	public String escuchar(String strIn) throws ParseException {
		ComandoAsistente cmdmsg = new ComandoAsistente(strIn);
		FechasAsistente fasist = new FechasAsistente();
		String strOut="";
		
		switch(cmdmsg.getTipoMensaje()) {
		case 0: strOut= InteraccionesAsistente.saludar(nombre);break;
		case 1: strOut= InteraccionesAsistente.agradecer();break;
		case 2: strOut= fasist.darHora();break;
		case 3: strOut= fasist.darFecha();break;
		case 4: strOut= fasist.darDiaSemana();break;
		case 5: strOut= fasist.darDiaFueSera(cmdmsg.getStdStrIn());break;
		

		
		
		default: strOut=msjNoDetectado();
		}
		
		return strOut;
		
	}
	
	
	
	
	
	
	
	private static String msjNoDetectado() {
		return "Disculpa... no entiendo el pedido, ¿podrías repetirlo?";
	}

	
	
	
	

	
	

	/* 
	 * estos 3 metodos siguientes funcionan, los comento porque no tengo test 
	 * 
	 
	
	
	static public String tiempoDiasDesdeFecha(String strIn) throws ParseException {
		
		SimpleDateFormat formatIn = new SimpleDateFormat("'cuántos días pasaron desde el' dd 'de' MMMMM 'de' yyyy");
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
	
	static public String tiempoMesesDesdeFecha(String strIn) throws ParseException {
		
		SimpleDateFormat formatIn = new SimpleDateFormat("'cuántos meses pasaron desde el' dd 'de' MMMMM 'de' yyyy");
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
	
	
	static public String tiempoAniosDesdeFecha(String strIn) throws ParseException {
		
		SimpleDateFormat formatIn = new SimpleDateFormat("'cuántos años pasaron desde el' dd 'de' MMMMM 'de' yyyy");
		SimpleDateFormat formatOut = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");

		//String strIn = "cuántos días pasaron desde el 1 de abril de 2018";

		Date fechaStrIn = formatIn.parse(strIn);
		
		Calendar desde = new GregorianCalendar();
		Calendar hasta = new GregorianCalendar();
		
		desde.setTime(fechaStrIn);
		hasta.setTime(new Date());
		
		int anios = hasta.get(Calendar.YEAR) - desde.get(Calendar.YEAR);
		 
		return ("Entre el "+ formatOut.format(fechaStrIn) + " y hoy pasaron "  + anios + " años");
		
	}
	
	
	*/
	
	
	
}
