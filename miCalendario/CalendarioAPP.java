package miCalendario;

import java.time.*;

public class CalendarioAPP {
	
	public static void main(String[] args) {

		CalendarioControlador c = new CalendarioControlador();
		c.iniciar();
		

/*		
 * --> Descomenta para ver los metodos simples de la clase "LocalDate" y la fecha de "hoy".
 * 
		LocalDate fecha = LocalDate.now();
		System.out.println(fecha.toString());
		System.out.println("Hoy es: "+fecha.getDayOfMonth()+", "+fecha.getDayOfWeek());
		System.out.println("Mes: "+fecha.getMonthValue()+", "+fecha.getMonth());
		System.out.println("Dias del mes: "+fecha.lengthOfMonth());
		System.out.println("Anio en curso: "+(fecha.getYear()));
		
	*/
	}

}
