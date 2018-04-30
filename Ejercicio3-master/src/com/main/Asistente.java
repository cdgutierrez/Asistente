package com.main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


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
		case 6: strOut= fasist.tiempoDiasDesdeFecha(cmdmsg.getStdStrIn());break;
		case 7: strOut= fasist.tiempoMesesDesdeFecha(cmdmsg.getStdStrIn());break;
		case 8: strOut= fasist.tiempoAniosDesdeFecha(cmdmsg.getStdStrIn());break;
		case 9: strOut= fasist.tiempoAniosHastaFecha(cmdmsg.getStdStrIn());break;
		case 10: strOut= fasist.tiempoDiasHastaFecha(cmdmsg.getStdStrIn());break;
		case 11: strOut= fasist.tiempoMesesHastaFecha(cmdmsg.getStdStrIn());break;
		
		default: strOut=msjNoDetectado();
		}
		
		return strOut;
		
	}
		
	private static String msjNoDetectado() {
		return "Disculpa... no entiendo el pedido, ¿podrías repetirlo?";
	}
	
	
}
