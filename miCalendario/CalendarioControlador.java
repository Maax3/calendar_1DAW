package miCalendario;

import java.awt.Color;
import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;

import miCalculadora.Calculadora;

public class CalendarioControlador extends MouseAdapter implements ActionListener{

	private Color azulClaro = new Color(15,126,218); 
	private Color azulOscuro = new Color(31,4,153);
	private static LocalDate fechaActual = LocalDate.now(); //el calendario se actualizaría siempre a la fecha actual
	private int mes = fechaActual.getMonthValue();	//puede empezar en una fecha fija pasando un entero en lugar de fechaActual
	private int anio = fechaActual.getYear(); 		//puede empezar en una fecha fija pasando un entero en lugar de fechaActual
	private Calendario miCalendario = new Calendario(anio,mes);
	private CalendarioJFrame vista  = new CalendarioJFrame();

	public void iniciar() {
		iniciarBotonera();
		vista.setVisible(true);
	}
	
	public void iniciarBotonera() {
		addBotonesSemana();
		addBotonesDias();
		addBotonesLaminaInferior();
	}
	
	public void addBotonesSemana() {
		String[] diasSemana = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
		
		JButton b;
		for (int i = 0; i < diasSemana.length; i++) {
			b = vista.setBoton(diasSemana[i],azulOscuro,Color.WHITE);
			vista.laminaCentral.add(b);
		}
	}
	
	public void addBotonesDias() {
		addBotonesVacios(miCalendario.getPrimerDia(),azulClaro,Color.BLACK);
		
		JButton b;
		for (int i = 1; i <= miCalendario.getDiasMes(); i++) {
			b = vista.setBoton(String.valueOf(i),azulClaro,Color.BLACK);
			vista.laminaCentral.add(b);
			b.addMouseListener(this);
		}
	}	
	
	public void addBotonesLaminaInferior() {
		JButton sig = vista.siguiente;
		JButton ant = vista.anterior;
		JButton calc = vista.calculadora;
		sig.addActionListener(this);
		ant.addActionListener(this);
		calc.addActionListener(this);
	}
	
	public void addBotonesVacios(int vueltas,Color fondo, Color borde ) {
		JButton b;
		for (int i = 0; i < vueltas; i++) {
			b = vista.setBoton("",fondo,borde);
				vista.laminaCentral.add(b);
		}
	}
	
	public void addBotonesVacios(int vueltas) {
		JButton b;
		for (int i = 0; i < vueltas; i++) {
			b = vista.setBoton("",azulOscuro,null);
				vista.laminaCentral.add(b);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Siguiente")) {
			mes++;
			if (mes > 12) {
				anio++;
				mes= 1;
				repintarDias();
				vista.anio.setText("Año: "+anio);
			}else
				repintarDias();
			vista.mes.setText("Mes: "+Calendario.getMes());
		}
		
		if (e.getActionCommand().equals("Anterior")) {
			mes--;
			vista.mes.setText("Mes: "+Calendario.getMes());
			if (mes < 1) {
				anio--;
				mes = 12;
				repintarDias();
				vista.anio.setText("Año: "+anio);
			}else
				repintarDias();
			vista.mes.setText("Mes: "+Calendario.getMes());
		}
		
		if (e.getActionCommand().equals("Calculadora")) {
			Calculadora calc = new Calculadora();
			calc.Iniciar();
		}
		
	}
	
	/*
	 * 1. Eliminamos el panel central (grid de los días)
	 * 2. Ajustamos el grid con la suma de dias y el comienzo del primer día (Ej, Sabado == +6...)
	 * 3. Repintamos botones
	 * 4. Ajustamos el grid en caso de que sea Febrero
	 * 5. Actualizamos UI.
	 */
	public void repintarDias() {
		miCalendario = new Calendario(anio,mes);
		vista.remove(vista.laminaCentral);
			
		if ((miCalendario.getPrimerDia() + miCalendario.getDiasMes()) > 35)
				vista.setLaminaCentral(7);
			else
				vista.setLaminaCentral(6);
			
		addBotonesSemana();
		addBotonesDias();
			
		if (Calendario.getMes().equals("Febrero") && !miCalendario.isBisiesto() && miCalendario.getPrimerDia() < 5) 
			addBotonesVacios(3);
	
		else if (miCalendario.getPrimerDia() < 3 && miCalendario.getDiasMes() == 29) 
			addBotonesVacios(2);
		
		vista.laminaCentral.updateUI();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton b = (JButton) e.getComponent();
			b.setBackground(new Color(255, 191, 0));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton b = (JButton) e.getComponent();
			b.setBackground(new Color(15,126,218));
	}
	
	
}
