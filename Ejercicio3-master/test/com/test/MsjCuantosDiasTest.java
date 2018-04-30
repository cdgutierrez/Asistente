package com.test;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.main.Asistente;

public class MsjCuantosDiasTest {
	String strIn = "cuántos días pasaron desde el 2 de abril de 2018";
	Asistente grace;
	
	@Before
	public void setup() {
		grace = new Asistente("grace");
	}
	
	@Test
	public void sinsentidodias() throws ParseException {
		Assert.assertEquals(
				"Entre el 02 de abril de 2018 y hoy pasaron 28 dias",
				grace.escuchar(strIn)
			);
	}
	
	@Test
	public void sinsentidomeses() throws ParseException {
		Assert.assertEquals(
				"Entre el 02 de diciembre de 2015 y hoy pasaron 28 meses",
				grace.escuchar("cuantos meses pasaron desde el 02 de diciembre de 2015")
			);
	}
	
	@Test
	public void sinsentidoaniosdesde() throws ParseException {
		Assert.assertEquals(
				"Entre el 02 de diciembre de 2015 y hoy pasaron 2 años",
				grace.escuchar("cuantos años pasaron desde el 02 de diciembre de 2015")
			);
	}
	
	@Test
	public void sinsentidoaniohasta() throws ParseException {
		Assert.assertEquals(
				"Entre hoy y el 02 de diciembre de 2025 pasaron 7 años",
				grace.escuchar("cuantos años pasaran hasta el 02 de diciembre de 2025")
			);
	}
	@Test
	public void sinsentidodiahasta() throws ParseException {
		Assert.assertEquals(
				"Entre hoy y el 02 de diciembre de 2025 pasaran 2772 dias",
				grace.escuchar("cuantos dias pasaran hasta el 02 de diciembre de 2025")
			);
	}
	@Test
	public void sinsentidomeshasta() throws ParseException {
		Assert.assertEquals(
				"Entre hoy y el 02 de diciembre de 2025 pasaran 91 meses",
				grace.escuchar("cuantos meses pasaran hasta el 02 de diciembre de 2025")
			);
	}
	
}
