package com.main;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComandoAsistente {

	private String stdStrIn=null;
	private int tipoMensaje;
	public ComandoAsistente () {
		
	}
	public ComandoAsistente(String strIn) {
		this.stdStrIn = stdStr(strIn);
		this.tipoMensaje = nroMensaje(stdStrIn);
	}
	
	public String getStdStrIn() {
		return stdStrIn;
	}
	public void setStdStrIn(String stdStrIn) {
		this.stdStrIn = stdStrIn;
	}
	public int getTipoMensaje() {
		return tipoMensaje;
	}
	public void setTipoMensaje(int tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	
	private String stdStr(String strIn) {
		
        String limpio = Normalizer.normalize(strIn.trim().toLowerCase(), Normalizer.Form.NFD);

        // eliminar char que no son ascii salvo ¿?!¡ñ
        limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
        limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
        
        return limpio;
	}
	
	private int nroMensaje(String strIn) {
		
		
		/*
		 * 0 - saludos
		 * 1 - agradecimientos
		 * 2 - hora
		 * 3 - fecha
		 * 4 - diaDeLaSemana
		 * 5 - queDia Fue/Sera ...
		 * 6 - tiempoDesde ...
		 * 
		 */
		
	
		
        // Matriz de mensajes, la fila corresponde al tipo de mensaje que luego usamos para un case
        // la referencia es tomada desde los puntos de los test
        // en caso de no encontrar un mensaje valido, devolver -1 y pedir repetir la pregunta
		// estos strings de mensajes siempre tienen que estar en minusculas
        
		String[][] mensajes = {
				{"buenas","hola","que tal","tardes","noches","buen dia","hey"},
				{"muchas gracias","gracias","muchisimas gracias"},
				{"que hora es","la hora","me decis la hora"},
				{"que dia es","la fecha","me decis la fecha"},
				{"que dia de la semana es hoy"},
				{"que dia sera","que dia fue"},
				{"cuantos dias pasaron desde","cuantos meses pasaron desde","cuantos años pasaron desde" },


		};
		
	

		boolean f=false; // flag para cortar el for en la primer ocurrencia, quizas haya otra mejora
		int nMsj=-1;
		
		for(int i=0;i<mensajes.length;i++ ){
			
			for(int j=0;j<mensajes[i].length;j++) {
				
				
				
				// expresion regular segun lo que esta en el test, quizas haya que mejorarlo
			
				Pattern regex = Pattern.compile("\\b" + Pattern.quote(mensajes[i][j]) + "\\b");
				Matcher match = regex.matcher(strIn.toLowerCase().trim());

				if(match.find()) {
					
//				    System.out.println("Encontrado: '" + match.group() 
//                    + "' dentro de '" + strIn.toLowerCase().trim() 
//                    + "' en la posición " + match.start());
					
					nMsj = i;
				    f=true;
				    break;
				} 
			}
			
			if(f)
				break;
		}
		
		return nMsj;
	}
	
	
}
