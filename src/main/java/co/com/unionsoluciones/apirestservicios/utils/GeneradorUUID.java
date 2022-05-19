package co.com.unionsoluciones.apirestservicios.utils;

import java.util.UUID;

public class GeneradorUUID {

	private GeneradorUUID() {

	}

	public static String generarLlave() {
		UUID uuid = UUID.randomUUID();
		String gen = uuid.toString();
		gen = gen.replaceAll("-", "");
		return gen;
	}

}
