package com.test;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.main.Asistente;

public class MsjTiempoDesdeTest {

	Asistente grace;
	
	@Before
	public void setup() {
		grace = new Asistente("grace");
	}
	
	@Test
	public void tiempoDesde() throws ParseException {
		Assert.assertEquals(
				"Entre el 20 de enero de 1992 y hoy pasaron 26 años",
				grace.escuchar("cuantos años pasaron desde el 20 de enero de 1992?")
			);
		
		Assert.assertEquals(
				"Hubo un error en el calculo de los años, verifique que sea una fecha pasada",
				grace.escuchar("cuantos años pasaron desde el 20 de enero de 2022?")
			);
		
		Assert.assertEquals(
				"Entre el 15 de enero de 2018 y hoy pasaron 105 dias",
				grace.escuchar("cuantos dias pasaron desde el 15 de enero de 2018?")
			);
		
		Assert.assertEquals(
				"Entre el 01 de enero de 2017 y hoy pasaron 484 dias",
				grace.escuchar("cuantos dias pasaron desde el 1 de enero de 2017?")
			);
		Assert.assertEquals(
				"Hubo un error en el calculo de los dias, verifique que sea una fecha pasada",
				grace.escuchar("cuantos dias pasaron desde el 1 de enero de 2027?")
			);
		Assert.assertEquals(
				"Entre el 01 de enero de 2017 y hoy pasaron 15 meses",
				grace.escuchar("cuantos meses pasaron desde el 1 de enero de 2017?")
			);
		
		Assert.assertEquals(
				"Hubo un error en el calculo de los meses, verifique que sea una fecha pasada",
				grace.escuchar("cuantos meses pasaron desde el 1 de enero de 2019?")
			);
		
		Assert.assertEquals(
				"Entre el 19 de abril de 2018 y hoy pasaron 11 dias",
				grace.escuchar("cuantos dias pasaron desde el 19 de abril de 2018?")
			);
		
		Assert.assertEquals(
				"Entre el 19 de abril de 2018 y hoy pasaron 11 dias",
				grace.escuchar("cuantos dias pasaron desde el 19 de abril de 2018?")
			);
	}
	
}
