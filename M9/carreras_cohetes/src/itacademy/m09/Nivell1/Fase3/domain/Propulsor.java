package itacademy.m09.Nivell1.Fase3.domain;

import javax.swing.JLabel;

public class Propulsor {
	
	private	JLabel label ;        
	private Thread thread;
	
	private	int potenciaActual = 0;
	private final int potenciaMaxima;
		
	public Propulsor(int potencia) {
		potenciaMaxima = potencia;
		
	}
	
	public Thread getThread() {
		return thread;
	}

	public void setThread(Runnable r) {
		thread = new Thread(r);
	}
	
	public void setTextLabel () {
		label.setText(potenciaActual + "");
	}

	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}


	public int getPotenciaActual() {
		return potenciaActual;
	}


	public void setPotenciaActual(int potenciaActual) {
		this.potenciaActual = potenciaActual;
	}


	public int getPotenciaMaxima() {
		return potenciaMaxima;
	}
	
	
}
