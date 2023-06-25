package miCalendario;

import java.time.*;

public class Calendario {
	
	private static LocalDate fecha;
	private int anio;
	private int mes;
	private static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
							  "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre","Diciembre"};
	
	public Calendario (int anio, int mes) {
		this.anio = anio;
		this.mes = mes;
		fecha = LocalDate.of(this.anio,this.mes, 1);
	}

	/**
	 * Devuelve el primer dia del mes
	 */
	public int getPrimerDia() {
		DayOfWeek semana = fecha.getDayOfWeek(); 
			return semana.getValue() -1; 
	}
	/**
	 * Devuelve el numero de dias del mes como entero
	 */
	public int getDiasMes() {
		return fecha.lengthOfMonth();
	}
	
	/**
	 * Devuelve el mes en curso
	 */
	public static String getMes() {
		return meses[(fecha.getMonthValue()-1)];
	}
	
	
	
	public boolean isBisiesto() {
		return fecha.isLeapYear();
	}

	
}
