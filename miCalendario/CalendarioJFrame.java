package miCalendario;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

@SuppressWarnings("serial")
public class CalendarioJFrame extends JFrame{
	
	public JPanel laminaSuperior;
	public JPanel laminaCentral;
	public JPanel laminaInferior;
	public JLabel mes;
	public JLabel anio;
	public JButton anterior;
	public JButton siguiente;
	public JButton calculadora;
	private static String mesActual =  Calendario.getMes();
	
	public CalendarioJFrame() {
		this.setSize(800,600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Calendario Swing");
		setLaminaSuperior();
		setLaminaCentral(6);
		setLaminaInferior();
		mes = this.setJLabel("Mes: "+mesActual,200,50);
		anio = this.setJLabel("Año: 2023", 400,50);
		anterior = this.setBoton("Anterior", 30, 20);
		siguiente = this.setBoton("Siguiente", 570, 20);
		calculadora = this.setBoton("Calculadora",300,20);
		
	}
	//contenedor del mes y anio en curso
	public void setLaminaSuperior() {
		laminaSuperior = new JPanel();
		laminaSuperior.setLayout(null);
		laminaSuperior.setBounds(0,0,800,130);
		laminaSuperior.setBackground(new Color(242, 177, 77));
		this.add(laminaSuperior);
	}
	
	//contenedor de los dias en curso
	public void setLaminaCentral(int filas) {
		laminaCentral = new JPanel();
		laminaCentral.setLayout(new GridLayout(filas,7,2,2));
		laminaCentral.setBounds(0,130,800,370);
		laminaCentral.setBackground(new Color(31,4,153));
		this.add(laminaCentral);
	}
	//contenedor de botones siguiente/anterior
	public void setLaminaInferior() {
		laminaInferior = new JPanel();
		laminaInferior.setLayout(null);
		laminaInferior.setBounds(0,500,800,100);
		laminaInferior.setBackground(new Color(240, 178, 122));
		this.add(laminaInferior);
	}
	//botones de semana y dias
	public JButton setBoton(String titulo,Color background,Color foreground) {
		JButton b = new JButton();
			b.setBackground(background);
			b.setText(titulo);
			b.setFont(new Font("Sans Serif",Font.BOLD,15));
			b.setForeground(foreground);
			b.setBorderPainted(false);
			b.setFocusable(false);
		return b;
	}
	
	//botones de siguiente y anterior
		public JButton setBoton(String titulo,int posX,int posY) {
			JButton b = new JButton();
				b.setBounds(posX,posY,200,30);
				b.setText(titulo);
				b.setBorder(new LineBorder(new Color(31,4,153),3));
				b.setBackground(new Color(15,126,218));
				b.setFont(new Font("Comic Sans",Font.BOLD,18));
				b.setForeground(new Color(187,207,197));
				b.setFocusable(false);
				laminaInferior.add(b);
			return b;
		}
		
	//etiquetas Label "Mes: xxxx" "Anio: xxxx"
	public JLabel setJLabel(String titulo,int posX,int posY) {
		JLabel j = new JLabel();
			j.setText(titulo);
			j.setBounds(posX, posY, 235, 50);
			j.setForeground(new Color(187,207,197));
			j.setHorizontalAlignment(JLabel.CENTER);
			j.setFont(new Font("Comic Sans",Font.BOLD,25));
			j.setBorder(new LineBorder(new Color(31,4,153),3));
			j.setBackground(new Color(15,126,218));
			j.setOpaque(true);
			laminaSuperior.add(j);
		return j;
	}

	
}
