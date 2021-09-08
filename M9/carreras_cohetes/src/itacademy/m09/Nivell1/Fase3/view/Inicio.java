package itacademy.m09.Nivell1.Fase3.view;

import itacademy.m09.Nivell1.Fase3.domain.Cohetes;

import javax.swing.JFrame;


public class Inicio {

	public static void main(String[] args) {				
		
		int [] propulsores1 = { 10, 30, 80 };
		int [] propulsores2 = { 30, 40, 50, 50, 30, 10};

		Cohetes cohete1 = new Cohetes("32WESSDS", propulsores1);
		Cohetes cohete2 = new Cohetes("LDSFJA32", propulsores2);

		JFrame marco = new PantallaPrincipal(cohete1, cohete2);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}
