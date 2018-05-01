package com.test;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.main.Asistente;

public class MsjSaludoTest {
	Asistente grace;
	String nombre = "@grace";
	@Before
	public void setup() {
		grace = new Asistente(nombre);
	}
	
	
	
	@Test
	public void sinsentido() throws ParseException {
		String[] mensajes = {"buenas","HOLA","que tal","tardes","BUEN D�A","noches","buen dia","hey"};
		
		for (String mensaje : mensajes) {
			
			Assert.assertEquals("Hola! soy "+ nombre,grace.escuchar(mensaje));
		}
	}
	
}
